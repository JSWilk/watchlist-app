package com.watchlist.repository;

import com.watchlist.entity.ListEntry;
import com.watchlist.entity.ListEntryId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListEntryRepository extends JpaRepository<ListEntry, ListEntryId> {
}
