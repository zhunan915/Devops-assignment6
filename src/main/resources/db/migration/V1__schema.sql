CREATE TABLE IF NOT EXISTS books
(
    id         BIGINT         NOT NULL AUTO_INCREMENT UNIQUE PRIMARY KEY,
    name       VARCHAR(255)   NOT NULL,
    author     VARCHAR(255)   NOT NULL,
    price      DECIMAL(10, 2) NOT NULL,
    total_page INT            NOT NULL
);