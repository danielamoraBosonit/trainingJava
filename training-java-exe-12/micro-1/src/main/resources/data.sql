DROP TABLE IF EXISTS working_calendar;
DROP SEQUENCE IF EXISTS working_calendar_sequence;
CREATE SEQUENCE working_calendar_sequence;

DROP TABLE IF EXISTS employee;
DROP SEQUENCE IF EXISTS employee_sequence;
CREATE SEQUENCE employee_sequence;

CREATE TABLE IF NOT EXISTS employee (
    id INTEGER default NEXT VALUE FOR employee_sequence primary key,
    name VARCHAR(100),
    surnames VARCHAR(100),
    birth_date TIMESTAMP,
    department VARCHAR(50),
    category VARCHAR(50),
    online boolean,
    last_status TIMESTAMP
);

CREATE TABLE IF NOT EXISTS working_calendar (
    id INTEGER default NEXT VALUE FOR working_calendar_sequence primary key,
    start_date TIMESTAMP,
    end_date TIMESTAMP,
    priority INTEGER,
    employee_id INTEGER,
    city_id INTEGER,
    FOREIGN KEY (employee_id) REFERENCES employee (id)
);


INSERT INTO employee (name, surnames, birth_date, department, category, online) VALUES
    ('Carlos', 'Jimenez Garcia', '1984-09-18', 'Desarrollo', 'Senior', false),
    ('Ana', 'Ruiz Lopez', '1991-01-02', 'QA', 'Midior', false),
    ('Pedro', 'Fernandez Gomez', '1979-04-07', 'Desarrollo', 'Senior', false),
    ('Laura', 'Gonzalo Martin', '1999-05-15', 'UX/UI', 'Senior', false),
    ('Juan', 'Torres Navarro', '2002-10-27', 'Desarrollo', 'Junior', false);


INSERT INTO working_calendar (employee_id, start_date, end_date, priority, city_id) VALUES
    (1, '2023-01-01 00:00:00', '2023-06-30 23:59:59', 10, 1),
    (1, '2023-07-01 00:00:00', '2023-12-31 23:59:59', 10, 2),
    (2, '2023-01-01 00:00:00', '2023-12-31 23:59:59', 10, 3),
    (2, '2023-08-01 00:00:00', '2023-08-31 23:59:59', 8, 4),
    (4, '2023-01-01 00:00:00', '2023-12-31 23:59:59', 1, 5);
