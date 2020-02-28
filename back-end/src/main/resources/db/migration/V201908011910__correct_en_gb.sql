DO
$$
    BEGIN
        CREATE PROCEDURE update_name(p_name number_translation.name%TYPE, p_code number.code%TYPE)
        AS
        $UPDATE_NAME$
        BEGIN
            UPDATE number_translation
            SET name = p_name
            WHERE number_id = (SELECT id FROM number WHERE code = p_code)
              AND language = 'en-GB';
        END;
        $UPDATE_NAME$
            LANGUAGE plpgsql;

        CALL update_name('Turmeric', 'E100(ii)');
        CALL update_name('Riboflavin- 5-Sodium Phosphate', 'E101(ii)');

        DROP PROCEDURE update_name(number_translation.name%TYPE, number.code%TYPE);
    END
$$;