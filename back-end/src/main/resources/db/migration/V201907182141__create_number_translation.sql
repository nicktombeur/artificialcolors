CREATE TABLE number_translation
(
    id          SERIAL NOT NULL,
    number_id   INTEGER NOT NULL,
    language    VARCHAR(5) NOT NULL,
    is_default  BOOLEAN NOT NULL,
    name        VARCHAR(255) NOT NULL,
    PRIMARY KEY (id, number_id)
);