DROP TABLE IF EXISTS public.product_price;
DROP TABLE IF EXISTS public.statistics;
DROP TABLE IF EXISTS public.product;

DROP SEQUENCE IF EXISTS public.product_price_sequence;
DROP SEQUENCE IF EXISTS public.statistics_sequence;
DROP SEQUENCE IF EXISTS public.product_sequence;

CREATE SEQUENCE public.product_sequence INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1;
CREATE SEQUENCE public.product_price_sequence INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1;


CREATE TABLE IF NOT EXISTS public.product (
    id bigint NOT NULL DEFAULT nextval('product_sequence'),
    description VARCHAR(255) NOT NULL,
    creation_date TIMESTAMP NOT NULL,
    packaging VARCHAR(25),
    units_box INTEGER,
    CONSTRAINT product_pkey PRIMARY KEY (id)
);


CREATE TABLE IF NOT EXISTS public.product_price (
    id bigint NOT NULL DEFAULT nextval('product_price_sequence'),
    brand_id INTEGER,
    start_date TIMESTAMP,
    end_date TIMESTAMP,
    price_list INTEGER,
    product_id bigint,
    priority INTEGER,
    price DECIMAL,
    curr VARCHAR(3),
    CONSTRAINT product_price_pkey PRIMARY KEY (id),
    CONSTRAINT product_price_product_fkey FOREIGN KEY (product_id)
        REFERENCES product (id) MATCH SIMPLE
);


CREATE TABLE IF NOT EXISTS public.statistics (
    id bigint NOT NULL,
    product_id bigint,
    total_units INTEGER,
    total_amount DECIMAL,
    CONSTRAINT statistics_pkey PRIMARY KEY (id),
    CONSTRAINT statistics_product_fkey FOREIGN KEY (product_id)
        REFERENCES product (id) MATCH SIMPLE
);
