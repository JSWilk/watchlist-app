package com.watchlist.service;

import com.watchlist.entity.Watchlist;
import com.watchlist.repository.WatchlistRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WatchlistService {

    private final WatchlistRepository watchlistRepository;

    public WatchlistService(WatchlistRepository watchlistRepository) {
        this.watchlistRepository = watchlistRepository;
    }

    public List<Watchlist> findAll() {
        return watchlistRepository.findAll();
    }

    public Watchlist findById(Long id) {
        return watchlistRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Watchlist not found: " + id));
    }

    public Watchlist create(Watchlist watchlist) {
        return watchlistRepository.save(watchlist);
    }

    public Watchlist update(Long id, Watchlist updated) {
        Watchlist existing = findById(id);
        existing.setName(updated.getName());
        return watchlistRepository.save(existing);
    }

    public void delete(Long id) {
        watchlistRepository.deleteById(id);
    }
}
