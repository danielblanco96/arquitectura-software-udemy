create schema if not exists order_service;

CREATE TABLE IF NOT EXISTS order_service.user
(
    id                  SERIAL PRIMARY KEY,
    full_name           VARCHAR NOT NULL,
    address_first_line  VARCHAR NOT NULL,
    address_second_line VARCHAR,
    address_country     VARCHAR,
    address_post_code   VARCHAR
);

CREATE TABLE IF NOT EXISTS order_service.order
(
    id                  SERIAL PRIMARY KEY,
    total_price         INT,
    order_date          TIMESTAMP WITHOUT TIME ZONE default NOW(),
    address_first_line  VARCHAR NOT NULL,
    address_second_line VARCHAR,
    address_country     VARCHAR,
    address_post_code   VARCHAR,
    user_id             BIGINT  NOT NULL,
    FOREIGN KEY (user_id) REFERENCES order_service.user (id)
);

CREATE TABLE IF NOT EXISTS order_service.order_line
(
    id               SERIAL PRIMARY KEY,
    product_id       BIGINT  NOT NULL,
    product_name     VARCHAR NOT NULL,
    product_price    INT     NOT NULL,
    quantity         INT     NOT NULL,
    line_total_price INT     NOT NULL,
    order_id         BIGINT  NOT NULL,
    FOREIGN KEY (order_id) REFERENCES order_service.order (id)
);