package com.watchlist.service;

import com.watchlist.entity.ListEntry;
import com.watchlist.entity.Title;
import com.watchlist.entity.Watchlist;
import com.watchlist.repository.ListEntryRepository;
import com.watchlist.repository.TitleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class TitleService {
    private final TitleRepository repository;
    private final ListEntryRepository listEntryRepository;

    public TitleService(TitleRepository repository, ListEntryRepository listEntryRepository){
        this.repository = repository;
        this.listEntryRepository = listEntryRepository;
    }

    public Title getTitleById(Long titleId){
        return repository.findById(titleId).orElseThrow();
    }

    public Title getRandomTitle(Watchlist watchlist){
        List<ListEntry> entries = listEntryRepository.findByWatchlist_IdAndTitle_WatchedFalse(watchlist.getId());
        if (entries.isEmpty()) {
            throw new IllegalStateException("No unwatched titles in this watchlist");
        }
        int index = ThreadLocalRandom.current().nextInt(entries.size());
        return entries.get(index).getTitle();
    }

    public Title getRandomTitle(String category){
        List<Title> titles = repository.findByCategoryAndWatchedFalse(category);
        if (titles.isEmpty()) {
            throw new IllegalStateException("No unwatched titles in this category");
        }
        int index = ThreadLocalRandom.current().nextInt(titles.size());
        return titles.get(index);
    }

    public void deleteTitleById(Long titleId){
        repository.deleteById(titleId);
    }

    public List<Title> getAllTitles(){
        return repository.findAll();
    }

    public Title createTitle(Title title){
        return repository.findByNameIgnoreCaseAndCategory(title.getName(), title.getCategory())
                .orElseGet(() -> repository.save(title));
    }

    public Title editTitle(Title oldTitle, Title newTitle){
        oldTitle.setName(newTitle.getName());
        oldTitle.setCategory(newTitle.getCategory());
        oldTitle.setLengthMinutes(newTitle.getLengthMinutes());
        oldTitle.setProvider(newTitle.getProvider());
        return repository.save(oldTitle);
    }
}
