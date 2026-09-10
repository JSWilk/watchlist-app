package com.watchlist.controller;

import com.watchlist.entity.Watchlist;
import com.watchlist.entity.WatchlistEntry;
import com.watchlist.service.WatchlistEntryService;
import com.watchlist.service.WatchlistService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/watchlists")
@CrossOrigin(origins = "${app.cors.allowed-origin:http://localhost:5173}")
public class WatchlistController {

    private final WatchlistService watchlistService;
    private final WatchlistEntryService entryService;

    public WatchlistController(WatchlistService watchlistService, WatchlistEntryService entryService) {
        this.watchlistService = watchlistService;
        this.entryService = entryService;
    }

    @GetMapping
    public List<Watchlist> getAll() {
        return watchlistService.findAll();
    }

    @GetMapping("/{id}")
    public Watchlist getById(@PathVariable Long id) {
        return watchlistService.findById(id);
    }

    @PostMapping
    public Watchlist create(@RequestBody Watchlist watchlist) {
        return watchlistService.create(watchlist);
    }

    @PutMapping("/{id}")
    public Watchlist update(@PathVariable Long id, @RequestBody Watchlist watchlist) {
        return watchlistService.update(id, watchlist);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        watchlistService.delete(id);
    }

    @GetMapping("/{id}/random")
    public WatchlistEntry random(@PathVariable Long id) {
        return entryService.pickRandom(id);
    }
}
