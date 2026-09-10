CREATE TABLE IF NOT EXISTS watchlists (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS watchlist_entries (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    length_minutes INTEGER,
    watched BOOLEAN NOT NULL DEFAULT FALSE,
    watchlist_id BIGINT NOT NULL REFERENCES watchlists(id) ON DELETE CASCADE
);

CREATE INDEX IF NOT EXISTS idx_watchlist_entries_watchlist_id ON watchlist_entries(watchlist_id);
