package com.watchlist.dto;

import java.util.List;

public record AddTitleRequest(
        String name,
        String category,
        Integer lengthMinutes,
        String provider,
        List<Long> watchlistIds
) {
}
