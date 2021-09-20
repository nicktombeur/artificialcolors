DO
$INSERT_TRANSLATION$
    BEGIN
        CREATE PROCEDURE insert_translation(p_code colorant.code% TYPE,
                                            p_language colorant_translation.language% TYPE,
                                            p_name colorant_translation.name% TYPE) AS
        $$
        DECLARE
            v_colorant_id INTEGER := (SELECT id
                                      FROM colorant
                                      where code = p_code);
        BEGIN
            INSERT INTO colorant_translation
            VALUES (nextval('colorant_translation_id_seq'), v_colorant_id, p_language, p_name);
        END;
        $$
            LANGUAGE plpgsql;
    END;
$INSERT_TRANSLATION$;
