CREATE TABLE IF NOT EXISTS player (
    id SERIAL PRIMARY KEY,
    name VARCHAR(36) NOT NULL,
    age INTEGER,
    club VARCHAR(36) NOT NULL,
    nationality VARCHAR(36) NOT NULL
);