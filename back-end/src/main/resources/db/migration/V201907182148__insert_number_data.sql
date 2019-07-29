CREATE PROCEDURE insert_data(IN code VARCHAR(10), IN artificial BOOLEAN)
AS
$$
BEGIN
    INSERT INTO number VALUES (nextval('number_id_seq'), code, artificial);
END;
$$
    LANGUAGE plpgsql;

DO
$$
    BEGIN
        PERFORM insert_data('E100', false);
        PERFORM insert_data('E100(ii)', false);
        PERFORM insert_data('E101', false);
        PERFORM insert_data('E101(ii)', false);
        PERFORM insert_data('E102', true);
        PERFORM insert_data('E103', false);
        PERFORM insert_data('E104', true);
        PERFORM insert_data('E105', true);
        PERFORM insert_data('E106', false);
        PERFORM insert_data('E107', true);
        PERFORM insert_data('E110', true);
        PERFORM insert_data('E111', true);
        PERFORM insert_data('E120', false);
        PERFORM insert_data('E121', true);
        PERFORM insert_data('E122', true);
        PERFORM insert_data('E123', true);
        PERFORM insert_data('E124', true);
        PERFORM insert_data('E125', true);
        PERFORM insert_data('E126', true);
        PERFORM insert_data('E127', true);
        PERFORM insert_data('E128', true);
        PERFORM insert_data('E129', true);
        PERFORM insert_data('E130', true);
        PERFORM insert_data('E131', true);
        PERFORM insert_data('E132', true);
        PERFORM insert_data('E133', true);
        PERFORM insert_data('E140', false);
        PERFORM insert_data('E141', true);
        PERFORM insert_data('E142', true);
        PERFORM insert_data('E143', true);
        PERFORM insert_data('E150a', false);
        PERFORM insert_data('E150b', false);
        PERFORM insert_data('E150c', false);
        PERFORM insert_data('E150d', false);
        PERFORM insert_data('E151', true);
        PERFORM insert_data('E152', true);
        PERFORM insert_data('E153', false);
        PERFORM insert_data('E154', true);
        PERFORM insert_data('E155', true);
        PERFORM insert_data('E160a', false);
        PERFORM insert_data('E160b', false);
        PERFORM insert_data('E160c', false);
        PERFORM insert_data('E160d', false);
        PERFORM insert_data('E160e', false);
        PERFORM insert_data('E160f', false);
        PERFORM insert_data('E161a', false);
        PERFORM insert_data('E161b', false);
        PERFORM insert_data('E161c', false);
        PERFORM insert_data('E161d', false);
        PERFORM insert_data('E161e', false);
        PERFORM insert_data('E161f', false);
        PERFORM insert_data('E161g', false);
        PERFORM insert_data('E161h', false);
        PERFORM insert_data('E161i', true);
        PERFORM insert_data('E161j', true);
        PERFORM insert_data('E162', false);
        PERFORM insert_data('E163', false);
        PERFORM insert_data('E164', false);
        PERFORM insert_data('E170', false);
        PERFORM insert_data('E171', false);
        PERFORM insert_data('E172', false);
        PERFORM insert_data('E173', false);
        PERFORM insert_data('E174', false);
        PERFORM insert_data('E175', false);
        PERFORM insert_data('E180', true);
        PERFORM insert_data('E181', false);
        PERFORM insert_data('E182', false);
    END
$$;

DROP PROCEDURE insert_data;
