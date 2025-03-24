
ALTER TABLE public.product_price ADD COLUMN creation_date TIMESTAMP;

ALTER TABLE public.statistics ADD COLUMN creation_date TIMESTAMP;

ALTER TABLE public.statistics_historic ADD COLUMN creation_date TIMESTAMP;
