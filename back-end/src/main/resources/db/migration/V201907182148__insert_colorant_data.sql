DO
$INSERT_DATA$
    BEGIN
        CREATE PROCEDURE insert_data(IN p_code colorant.code% TYPE, IN p_artificial colorant.artificial% TYPE) AS
        $CREATE_PROCEDURE$
        BEGIN
            INSERT INTO colorant
            VALUES (nextval('colorant_id_seq'), p_code, p_artificial);
        END;
        $CREATE_PROCEDURE$
            LANGUAGE plpgsql;

        CALL insert_data('E100', false);
        CALL insert_data('E100(ii)', false);
        CALL insert_data('E101', false);
        CALL insert_data('E101(ii)', false);
        CALL insert_data('E102', true);
        CALL insert_data('E103', false);
        CALL insert_data('E104', true);
        CALL insert_data('E105', true);
        CALL insert_data('E106', false);
        CALL insert_data('E107', true);
        CALL insert_data('E110', true);
        CALL insert_data('E111', true);
        CALL insert_data('E120', false);
        CALL insert_data('E121', true);
        CALL insert_data('E122', true);
        CALL insert_data('E123', true);
        CALL insert_data('E124', true);
        CALL insert_data('E125', true);
        CALL insert_data('E126', true);
        CALL insert_data('E127', true);
        CALL insert_data('E128', true);
        CALL insert_data('E129', true);
        CALL insert_data('E130', true);
        CALL insert_data('E131', true);
        CALL insert_data('E132', true);
        CALL insert_data('E133', true);
        CALL insert_data('E140', false);
        CALL insert_data('E141', true);
        CALL insert_data('E142', true);
        CALL insert_data('E143', true);
        CALL insert_data('E150a', false);
        CALL insert_data('E150b', false);
        CALL insert_data('E150c', false);
        CALL insert_data('E150d', false);
        CALL insert_data('E151', true);
        CALL insert_data('E152', true);
        CALL insert_data('E153', false);
        CALL insert_data('E154', true);
        CALL insert_data('E155', true);
        CALL insert_data('E160a', false);
        CALL insert_data('E160b', false);
        CALL insert_data('E160c', false);
        CALL insert_data('E160d', false);
        CALL insert_data('E160e', false);
        CALL insert_data('E160f', false);
        CALL insert_data('E161a', false);
        CALL insert_data('E161b', false);
        CALL insert_data('E161c', false);
        CALL insert_data('E161d', false);
        CALL insert_data('E161e', false);
        CALL insert_data('E161f', false);
        CALL insert_data('E161g', false);
        CALL insert_data('E161h', false);
        CALL insert_data('E161i', true);
        CALL insert_data('E161j', true);
        CALL insert_data('E162', false);
        CALL insert_data('E163', false);
        CALL insert_data('E164', false);
        CALL insert_data('E170', false);
        CALL insert_data('E171', false);
        CALL insert_data('E172', false);
        CALL insert_data('E173', false);
        CALL insert_data('E174', false);
        CALL insert_data('E175', false);
        CALL insert_data('E180', true);
        CALL insert_data('E181', false);
        CALL insert_data('E182', false);

        DROP PROCEDURE IF EXISTS insert_data(code colorant.code%TYPE, artificial colorant.artificial%TYPE);
    END;
$INSERT_DATA$;
