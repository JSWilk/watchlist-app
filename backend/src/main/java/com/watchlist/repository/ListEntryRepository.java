package com.watchlist.repository;

import com.watchlist.entity.ListEntry;
import com.watchlist.entity.ListEntryId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ListEntryRepository extends JpaRepository<ListEntry, ListEntryId> {

    List<ListEntry> findByWatchlist_IdAndTitle_WatchedFalse(Long watchlistId);
}
