package com.watchlist.service;

import com.watchlist.entity.Watchlist;
import com.watchlist.repository.WatchlistRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WatchlistService{
    private final WatchlistRepository repository;

    public WatchlistService(WatchlistRepository repository){
        this.repository = repository;
    }

    public Watchlist getWatchlistById(Long watchlistId){
        return repository.findById(watchlistId).orElseThrow();
    }

    public List<Watchlist> getAllWatchlists(){
        return repository.findAll();
    }

    public void deleteWatchlist(Long watchlistId){
        repository.deleteById(watchlistId);
    }

    public void editWatchlist(Watchlist oldWatchlist, Watchlist newWatchlist){
        oldWatchlist.setName(newWatchlist.getName());
        repository.save(oldWatchlist);
    }

    public void createWatchlist(Watchlist watchlist){
        repository.save(watchlist);
    }
}
