CREATE PROCEDURE insert_translation(number_code VARCHAR(10), language VARCHAR(5), name VARCHAR(255),
                                    is_default BOOLEAN DEFAULT FALSE)
AS
$$
DECLARE
    number_id INTEGER := (SELECT id
                          FROM number
                          where code = number_code);
BEGIN
    INSERT INTO number_translation VALUES (nextval('number_translation_id_seq'), number_id, language, is_default, name);
END;
$$
    LANGUAGE plpgsql;
