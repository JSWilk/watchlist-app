package com.watchlist.entity;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ListEntryId implements Serializable {

    private Long watchlistId;
    private Long titleId;

    public ListEntryId() {
    }

    public ListEntryId(Long watchlistId, Long titleId) {
        this.watchlistId = watchlistId;
        this.titleId = titleId;
    }

    public Long getWatchlistId() {
        return watchlistId;
    }

    public void setWatchlistId(Long watchlistId) {
        this.watchlistId = watchlistId;
    }

    public Long getTitleId() {
        return titleId;
    }

    public void setTitleId(Long titleId) {
        this.titleId = titleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ListEntryId)) return false;
        ListEntryId that = (ListEntryId) o;
        return Objects.equals(watchlistId, that.watchlistId) && Objects.equals(titleId, that.titleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(watchlistId, titleId);
    }
}
