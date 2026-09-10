package com.watchlist.repository;

import com.watchlist.entity.WatchlistEntry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WatchlistEntryRepository extends JpaRepository<WatchlistEntry, Long> {

    List<WatchlistEntry> findByWatchlistIdAndWatchedFalse(Long watchlistId);
}
