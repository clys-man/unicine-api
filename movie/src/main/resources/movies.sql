-- Populando a tabela 'movie'
INSERT INTO movie (duration, director, language, rating, release_date, synopsis, title) VALUES
                                                                                            (120, 'Christopher Nolan', 'English', 'PG-13', '2023-07-21', 'A mind-bending journey through time and space.', 'Inception'),
                                                                                            (150, 'Quentin Tarantino', 'English', 'R', '2023-09-15', 'A tale of revenge and redemption.', 'Pulp Fiction'),
                                                                                            (135, 'Steven Spielberg', 'English', 'PG', '2023-04-12', 'An epic adventure of a young archaeologist.', 'Indiana Jones: Raiders of the Lost Ark');

-- Populando a tabela 'room'
INSERT INTO room (capacity, number, location, type) VALUES
                                                        (100, 1, 'Main Building', 'Standard'),
                                                        (80, 2, 'Main Building', 'VIP'),
                                                        (120, 3, 'Annex Building', 'Standard');

-- Populando a tabela 'session'
INSERT INTO session (ticket_price, date_time, movie_id, room_id) VALUES
                                                                     (10.50, '2024-06-01 18:00:00', 1, 1),
                                                                     (10.50, '2024-06-01 20:30:00', 1, 2),
                                                                     (9.00, '2024-06-02 19:00:00', 2, 1),
                                                                     (9.00, '2024-06-02 21:30:00', 2, 2),
                                                                     (11.00, '2024-06-03 17:00:00', 3, 3),
                                                                     (11.00, '2024-06-03 20:00:00', 3, 1);
