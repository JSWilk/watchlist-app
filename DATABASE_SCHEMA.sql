CREATE TABLE title(
    id                    SERIAL        PRIMARY KEY,
    name                  VARCHAR(100)  NOT NULL,
    category              VARCHAR(50)   NOT NULL,
    length_minutes        INT,
    provider              VARCHAR(50),
    watched               BOOLEAN       DEFAULT false
);
CREATE UNIQUE INDEX idx_title_unique_name_category
ON title (LOWER(name), category);

CREATE TABLE lists(
    id     SERIAL         PRIMARY KEY,
    name   VARCHAR(100)   NOT NULL
);

CREATE TABLE list_entries(
    list_id               INT REFERENCES lists(id) ON DELETE CASCADE,
    title_id              INT REFERENCES title(id) ON DELETE CASCADE,
    PRIMARY KEY (list_id, title_id)
);