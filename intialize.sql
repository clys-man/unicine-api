INSERT INTO movie (director, duration, language, rating, release_date, synopsis, title)
VALUES ('Director 1', 120, 'English', 'PG-13', '2022-01-01', 'Synopsis 1', 'Title 1'),
       ('Director 2', 90, 'Spanish', 'R', '2022-02-01', 'Synopsis 2', 'Title 2');

INSERT INTO room (capacity, location, number, type)
VALUES (100, 'Location 1', 1, 'Type 1'),
       (200, 'Location 2', 2, 'Type 2');

INSERT INTO acent (number, status, room_id)
VALUES (1, 'Available', 1),
       (2, 'Available', 1),
       (3, 'Available', 2),
       (4, 'Available', 2);

INSERT INTO sale (code, date_time, total_price)
VALUES ('Code 1', '2022-01-01 10:00:00', 10.0),
       ('Code 2', '2022-02-01 10:00:00', 20.0);

INSERT INTO session (date_time, ticket_price, movie_id, room_id)
VALUES ('2022-01-01 10:00:00', 10.0, 1, 1),
       ('2022-02-01 10:00:00', 20.0, 2, 2);

INSERT INTO ticket (code, date_time, ticket_price, acent_id, sale_id, session_id)
VALUES ('Ticket 1', '2022-01-01 10:00:00', 10.0, 1, 1, 1),
       ('Ticket 2', '2022-02-01 10:00:00', 20.0, 2, 2, 2);