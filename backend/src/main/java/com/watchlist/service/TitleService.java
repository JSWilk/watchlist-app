package com.watchlist.service;

import com.watchlist.entity.Title;
import com.watchlist.repository.TitleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TitleService {
    private final TitleRepository repository;

    public TitleService(TitleRepository repository){
        this.repository = repository;
    }

    public Title getTitleById(Long titleId){
        return repository.findById(titleId).orElseThrow();
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
