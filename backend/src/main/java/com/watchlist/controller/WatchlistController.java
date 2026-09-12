package com.watchlist.controller;

import com.watchlist.entity.Watchlist;
import com.watchlist.service.WatchlistService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/watchlists")
public class WatchlistController{
    private WatchlistService watchlistService;

    WatchlistController(WatchlistService watchlistService){
        this.watchlistService = watchlistService;
    }

    @PostMapping
    public void createWatchlist(@RequestBody Watchlist watchlist){
        watchlistService.createWatchlist(watchlist);
    }

    @GetMapping
    public List<Watchlist> getAllWatchlist(){
        return watchlistService.getAllWatchlists();
    }

    @GetMapping("/{id}")
    public Watchlist getWatchlistById(@PathVariable Long id){
        return watchlistService.getWatchlistById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteWatchlistById(@PathVariable Long id){
        watchlistService.deleteWatchlist(id);
    }

    @PutMapping("/{id}")
    public Watchlist updateWatchlist(@PathVariable Long id, @RequestBody Watchlist newWatchlist){
        Watchlist oldWatchlist = watchlistService.getWatchlistById(id);
        return watchlistService.editWatchlist(oldWatchlist, newWatchlist);
    }
}