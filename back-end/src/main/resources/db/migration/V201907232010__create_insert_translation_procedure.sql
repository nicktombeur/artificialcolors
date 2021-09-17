DO
$INSERT_TRANSLATION$
    BEGIN
        CREATE PROCEDURE insert_translation(colorant_code VARCHAR(10), language VARCHAR(5), name VARCHAR(255))
        AS
        $$
        DECLARE
            colorant_id INTEGER := (SELECT id
                                  FROM colorant
                                  where code = colorant_code);
        BEGIN
            INSERT INTO colorant_translation
            VALUES (nextval('colorant_translation_id_seq'), colorant_id, language, name);
        END;
        $$
            LANGUAGE plpgsql;
    END;
$INSERT_TRANSLATION$;
