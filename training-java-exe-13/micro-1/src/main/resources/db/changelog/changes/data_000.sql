DROP TABLE IF EXISTS public.working_calendar;
DROP TABLE IF EXISTS public.employee_sequence;

DROP SEQUENCE IF EXISTS public.working_calendar_sequence;
DROP SEQUENCE IF EXISTS public.employee_sequence;

CREATE SEQUENCE public.working_calendar_sequence INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1;
CREATE SEQUENCE public.employee_sequence INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1;


CREATE TABLE IF NOT EXISTS public.employee (
    id INTEGER NOT NULL DEFAULT nextval('employee_sequence'),
    name VARCHAR(100),
    surnames VARCHAR(100),
    birth_date TIMESTAMP,
    department VARCHAR(50),
    category VARCHAR(50),
    online boolean,
    last_status TIMESTAMP,
    CONSTRAINT employee_pkey PRIMARY KEY (id)
);


CREATE TABLE IF NOT EXISTS public.working_calendar (
    id INTEGER NOT NULL DEFAULT nextval('working_calendar_sequence'),
    start_date TIMESTAMP,
    end_date TIMESTAMP,
    priority INTEGER,
    employee_id INTEGER,
    city_id INTEGER,
    CONSTRAINT working_calendar_pkey PRIMARY KEY (id),
    CONSTRAINT working_calendar_employee_fkey FOREIGN KEY (employee_id)
        REFERENCES employee (id) MATCH SIMPLE
);
