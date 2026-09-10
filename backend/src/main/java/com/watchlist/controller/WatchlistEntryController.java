package com.watchlist.controller;

import com.watchlist.entity.WatchlistEntry;
import com.watchlist.service.WatchlistEntryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/watchlists/{watchlistId}/entries")
@CrossOrigin(origins = "${app.cors.allowed-origin:http://localhost:5173}")
public class WatchlistEntryController {

    private final WatchlistEntryService entryService;

    public WatchlistEntryController(WatchlistEntryService entryService) {
        this.entryService = entryService;
    }

    @GetMapping
    public List<WatchlistEntry> getAll(@PathVariable Long watchlistId,
                                        @RequestParam(defaultValue = "false") boolean sortByLength) {
        return sortByLength
                ? entryService.findByWatchlistSortedByLength(watchlistId)
                : entryService.findByWatchlist(watchlistId);
    }

    @PostMapping
    public WatchlistEntry create(@RequestBody WatchlistEntry entry) {
        return entryService.create(entry);
    }

    @PutMapping("/{id}")
    public WatchlistEntry update(@PathVariable Long id, @RequestBody WatchlistEntry entry) {
        return entryService.update(id, entry);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        entryService.delete(id);
    }
}
