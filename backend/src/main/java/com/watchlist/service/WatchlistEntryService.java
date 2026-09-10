package com.watchlist.service;

import com.watchlist.entity.WatchlistEntry;
import com.watchlist.repository.WatchlistEntryRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class WatchlistEntryService {

    private final WatchlistEntryRepository entryRepository;

    public WatchlistEntryService(WatchlistEntryRepository entryRepository) {
        this.entryRepository = entryRepository;
    }

    public List<WatchlistEntry> findByWatchlist(Long watchlistId) {
        return entryRepository.findByWatchlistIdAndWatchedFalse(watchlistId);
    }

    public List<WatchlistEntry> findByWatchlistSortedByLength(Long watchlistId) {
        return findByWatchlist(watchlistId).stream()
                .sorted(Comparator.comparing(
                        WatchlistEntry::getLengthMinutes,
                        Comparator.nullsLast(Comparator.naturalOrder())))
                .toList();
    }

    public WatchlistEntry create(WatchlistEntry entry) {
        return entryRepository.save(entry);
    }

    public WatchlistEntry update(Long id, WatchlistEntry updated) {
        WatchlistEntry existing = entryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Entry not found: " + id));
        existing.setTitle(updated.getTitle());
        existing.setLengthMinutes(updated.getLengthMinutes());
        existing.setWatched(updated.isWatched());
        return entryRepository.save(existing);
    }

    public void delete(Long id) {
        entryRepository.deleteById(id);
    }

    public WatchlistEntry pickRandom(Long watchlistId) {
        List<WatchlistEntry> unwatched = findByWatchlist(watchlistId);
        if (unwatched.isEmpty()) {
            throw new IllegalStateException("No unwatched entries left in watchlist: " + watchlistId);
        }
        int index = ThreadLocalRandom.current().nextInt(unwatched.size());
        return unwatched.get(index);
    }
}
