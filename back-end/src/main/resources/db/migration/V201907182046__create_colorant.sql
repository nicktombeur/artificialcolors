CREATE TABLE colorant
(
    id         SERIAL PRIMARY KEY,
    code       VARCHAR(10) NOT NULL,
    artificial BOOLEAN NOT NULL
);
