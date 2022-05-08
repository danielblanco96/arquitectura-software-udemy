INSERT INTO user_service.user(id, full_name, date_of_birth, last_login)
VALUES (1, 'Daniel Blanco', '1996-01-01', NOW())
ON CONFLICT DO NOTHING;

INSERT INTO user_service.user(id, full_name, date_of_birth, last_login)
VALUES (2, 'John Doe', '1996-01-01', NOW())
ON CONFLICT DO NOTHING;

INSERT INTO user_service.address(id, first_line, second_line, country, post_code, user_id,
                                 is_default)
VALUES (1, 'This is the first line of the address #1', 'second line', 'Spain', '11111', 1, true)
ON CONFLICT DO NOTHING;

INSERT INTO user_service.address(id, first_line, second_line, country, post_code, user_id,
                                 is_default)
VALUES (2, 'This is the first line of the address #2', 'second line', 'Spain', '11111', 1, false)
ON CONFLICT DO NOTHING;