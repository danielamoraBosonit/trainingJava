DROP TABLE IF EXISTS public.users;

DROP SEQUENCE IF EXISTS public.users_sequence;

CREATE SEQUENCE public.users_sequence INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1;

CREATE TABLE IF NOT EXISTS public.users (
    id bigint NOT NULL DEFAULT nextval('users_sequence'),
    user_name VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(25),
    CONSTRAINT users_pkey PRIMARY KEY (id),
    CONSTRAINT unique_user_name UNIQUE (user_name)
);

INSERT INTO public.users (id, user_name, password, role) VALUES
(1, 'training', '$2a$10$Urlhrmb7uOznbcnTuuzkiO0FzKLgYZZwaERTKgJfMa0yRWit76GE6', 'admin');