DROP TABLE IF EXISTS working_calendar;
DROP SEQUENCE IF EXISTS working_calendar_sequence;

CREATE SEQUENCE working_calendar_sequence;

CREATE TABLE IF NOT EXISTS working_calendar (
    id INTEGER default NEXT VALUE FOR working_calendar_sequence primary key,
    start_date TIMESTAMP,
    end_date TIMESTAMP,
    priority INTEGER,
    employee_id INTEGER,
    city_id INTEGER
);

INSERT INTO working_calendar (employee_id, start_date, end_date, priority, city_id) VALUES
    (1, '2023-01-01 00:00:00', '2023-06-30 23:59:59', 10, 1),
    (1, '2023-07-01 00:00:00', '2023-12-31 23:59:59', 10, 2),
    (2, '2023-01-01 00:00:00', '2023-12-31 23:59:59', 10, 3),
    (2, '2023-08-01 00:00:00', '2023-08-31 23:59:59', 8, 4),
    (4, '2023-01-01 00:00:00', '2023-12-31 23:59:59', 1, 5);
