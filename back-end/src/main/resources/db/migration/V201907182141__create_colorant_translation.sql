CREATE TABLE colorant_translation
(
    id          SERIAL NOT NULL,
    colorant_id   INTEGER NOT NULL,
    language    VARCHAR(5) NOT NULL,
    name        VARCHAR(255) NOT NULL,
    PRIMARY KEY (id, colorant_id)
);