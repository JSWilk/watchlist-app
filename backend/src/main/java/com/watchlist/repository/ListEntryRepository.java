package com.watchlist.repository;

import com.watchlist.entity.ListEntry;
import com.watchlist.entity.ListEntryId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ListEntryRepository extends JpaRepository<ListEntry, ListEntryId> {

    List<ListEntry> findByWatchlist_IdAndTitle_WatchedFalse(Long watchlistId);

    Optional<ListEntry> findByWatchlist_IdAndTitle_Id(Long watchlistId, Long titleId);
}
