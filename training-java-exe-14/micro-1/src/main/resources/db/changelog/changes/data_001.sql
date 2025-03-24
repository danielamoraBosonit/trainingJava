
INSERT INTO employee (name, surnames, birth_date, department, category, online, email, password, role) VALUES
    ('Carlos', 'Jimenez Garcia', '1984-09-18', 'Desarrollo', 'Senior', false, 'carlosjimenez@training.com', '$2a$10$Urlhrmb7uOznbcnTuuzkiO0FzKLgYZZwaERTKgJfMa0yRWit76GE6', 'ADMIN'),
    ('Ana', 'Ruiz Lopez', '1991-01-02', 'QA', 'Midior', false, 'anaruiz@training.com', '$2a$10$Urlhrmb7uOznbcnTuuzkiO0FzKLgYZZwaERTKgJfMa0yRWit76GE6', 'USER'),
    ('Pedro', 'Fernandez Gomez', '1979-04-07', 'Desarrollo', 'Senior', false, 'pedrofernandez@training.com', '$2a$10$Urlhrmb7uOznbcnTuuzkiO0FzKLgYZZwaERTKgJfMa0yRWit76GE6', 'USER'),
    ('Laura', 'Gonzalo Martin', '1999-05-15', 'UX/UI', 'Senior', false, 'lauragonzalo@training.com', '$2a$10$Urlhrmb7uOznbcnTuuzkiO0FzKLgYZZwaERTKgJfMa0yRWit76GE6', 'USER'),
    ('Juan', 'Torres Navarro', '2002-10-27', 'Desarrollo', 'Junior', false, 'juantorres@training.com', '$2a$10$Urlhrmb7uOznbcnTuuzkiO0FzKLgYZZwaERTKgJfMa0yRWit76GE6', 'USER');


INSERT INTO working_calendar (employee_id, start_date, end_date, priority, city_id) VALUES
    (1, '2023-01-01 00:00:00', '2023-06-30 23:59:59', 10, 1),
    (1, '2023-07-01 00:00:00', '2023-12-31 23:59:59', 10, 2),
    (2, '2023-01-01 00:00:00', '2023-12-31 23:59:59', 10, 3),
    (2, '2023-08-01 00:00:00', '2023-08-31 23:59:59', 8, 4),
    (4, '2023-01-01 00:00:00', '2023-12-31 23:59:59', 1, 5);
