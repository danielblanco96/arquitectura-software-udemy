create schema if not exists user_service;

CREATE TABLE IF NOT EXISTS user_service.user
(
    id            SERIAL PRIMARY KEY,
    full_name     VARCHAR NOT NULL,
    date_of_birth DATE,
    last_login    TIMESTAMP
);

CREATE TABLE IF NOT EXISTS user_service.address
(
    id          SERIAL PRIMARY KEY,
    first_line  VARCHAR NOT NULL,
    second_line VARCHAR,
    country     VARCHAR,
    post_code   VARCHAR,
    is_default  boolean,
    user_id     BIGINT  NOT NULL,
    FOREIGN KEY (user_id) REFERENCES user_service.user (id)
);