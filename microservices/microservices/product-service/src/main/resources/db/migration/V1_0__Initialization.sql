create schema if not exists product_service;

CREATE TABLE IF NOT EXISTS product_service.product
(
    id          SERIAL PRIMARY KEY,
    name        VARCHAR NOT NULL,
    description VARCHAR NOT NULL,
    price       int     NOT NULL,
    stock       int     NOT NULL
);
