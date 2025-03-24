DROP TABLE IF EXISTS public.statistics_historic;

DROP SEQUENCE IF EXISTS public.statistics_historic_sequence;

CREATE SEQUENCE public.statistics_historic_sequence INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1;

CREATE TABLE IF NOT EXISTS public.statistics_historic (
    id bigint NOT NULL,
    product_id bigint,
    total_units INTEGER,
    total_amount DECIMAL,
    statistics_date TIMESTAMP,
    CONSTRAINT statistics_historic_pkey PRIMARY KEY (id)
);
