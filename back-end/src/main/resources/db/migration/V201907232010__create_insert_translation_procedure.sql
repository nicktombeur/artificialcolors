DO
$INSERT_TRANSLATION$
    BEGIN
        CREATE PROCEDURE insert_translation(p_code number.code%TYPE,
                                            p_language number_translation.language%TYPE,
                                            p_name number_translation.name%TYPE,
                                            p_is_default number_translation.is_default%TYPE DEFAULT FALSE)
        AS
        $$
        DECLARE
            v_number_id INTEGER := (SELECT id
                                    FROM number
                                    where code = p_code);
        BEGIN
            INSERT INTO number_translation
            VALUES (nextval('number_translation_id_seq'), v_number_id, p_language, p_is_default, p_name);
        END;
        $$
            LANGUAGE plpgsql;
    END;
$INSERT_TRANSLATION$;
