BEGIN TRANSACTION;

DROP TABLE IF EXISTS tournaments, tournament_user, matches, invites;
DROP SEQUENCE IF EXISTS seq_tournament_id, seq_match_id, seq_invite_id;

CREATE SEQUENCE seq_tournament_id
INCREMENT BY 1
START WITH 1001
NO MAXVALUE;

CREATE TABLE tournaments(
	tournament_id SERIAL NOT NULL,
	organizer_id int NOT NULL,
	name VARCHAR(100) NOT NULL,
	num_of_participants int NOT NULL,
	type VARCHAR(50),
	from_date DATE NOT NULL,
	to_date DATE NOT NULL,
	game VARCHAR(50),
	img_url VARCHAR(200),

	CONSTRAINT pk_tournament_id PRIMARY KEY (tournament_id),
	CONSTRAINT fk_organizer_id FOREIGN KEY (organizer_id) REFERENCES users(user_id)
);

CREATE SEQUENCE seq_match_id
INCREMENT BY 1
START WITH 2001
NO MAXVALUE;

CREATE TABLE matches(
	match_id SERIAL NOT NULL,
	tournament_id int NOT NULL,
	home_id int NOT NULL,
	away_id int NOT NULL,
	winner VARCHAR(4),
	
	CONSTRAINT pk_match_id PRIMARY KEY (match_id),
	CONSTRAINT fk_home_id FOREIGN KEY (home_id) REFERENCES users(user_id),
	CONSTRAINT fk_away_id FOREIGN KEY (away_id) REFERENCES users(user_id)
);

CREATE TABLE tournament_user(
	user_id int NOT NULL,
	tournament_id int NOT NULL,
	
	CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES users(user_id),
	CONSTRAINT fk_tournament_id FOREIGN KEY (tournament_id) REFERENCES tournaments(tournament_id)
);

CREATE SEQUENCE seq_invite_id
INCREMENT BY 1
START WITH 10001
NO MAXVALUE;

CREATE TABLE invites(
	invite_id SERIAL NOT NULL,
	tournament_id int NOT NULL,
	sender_id int NOT NULL,
	receiver_id int NOT NULL,
	status VARCHAR(20) NOT NULL,
	
	CONSTRAINT pk_invite_id PRIMARY KEY (invite_id),
	CONSTRAINT fk_tournament_id FOREIGN KEY (tournament_id) REFERENCES tournaments(tournament_id),
	CONSTRAINT fk_sender_id FOREIGN KEY (sender_id) REFERENCES users(user_id),
	CONSTRAINT fk_receiver_id FOREIGN KEY (receiver_id) REFERENCES users(user_id)
);

INSERT INTO users (username, password_hash, role)
VALUES ('userone', '$2a$10$o0lCPznuaJf3PmAO9IPUtu1BWaWmCMWxIjU8kYNwP5VwLX6HM7P8K', 'ROLE_USER'),
('usertwo', '$2a$10$o0lCPznuaJf3PmAO9IPUtu1BWaWmCMWxIjU8kYNwP5VwLX6HM7P8K', 'ROLE_USER'),
('userthree', '$2a$10$o0lCPznuaJf3PmAO9IPUtu1BWaWmCMWxIjU8kYNwP5VwLX6HM7P8K', 'ROLE_USER'),
('userfour', '$2a$10$o0lCPznuaJf3PmAO9IPUtu1BWaWmCMWxIjU8kYNwP5VwLX6HM7P8K', 'ROLE_USER'),
('userfive', '$2a$10$o0lCPznuaJf3PmAO9IPUtu1BWaWmCMWxIjU8kYNwP5VwLX6HM7P8K', 'ROLE_USER'),
('usersix', '$2a$10$o0lCPznuaJf3PmAO9IPUtu1BWaWmCMWxIjU8kYNwP5VwLX6HM7P8K', 'ROLE_USER'),
('userseven', '$2a$10$o0lCPznuaJf3PmAO9IPUtu1BWaWmCMWxIjU8kYNwP5VwLX6HM7P8K', 'ROLE_USER'),
('usereight', '$2a$10$o0lCPznuaJf3PmAO9IPUtu1BWaWmCMWxIjU8kYNwP5VwLX6HM7P8K', 'ROLE_USER'),
('usernine', '$2a$10$o0lCPznuaJf3PmAO9IPUtu1BWaWmCMWxIjU8kYNwP5VwLX6HM7P8K', 'ROLE_USER'),
('userten', '$2a$10$o0lCPznuaJf3PmAO9IPUtu1BWaWmCMWxIjU8kYNwP5VwLX6HM7P8K', 'ROLE_USER'),
('usereleven', '$2a$10$o0lCPznuaJf3PmAO9IPUtu1BWaWmCMWxIjU8kYNwP5VwLX6HM7P8K', 'ROLE_USER'),
('usertwelve', '$2a$10$o0lCPznuaJf3PmAO9IPUtu1BWaWmCMWxIjU8kYNwP5VwLX6HM7P8K', 'ROLE_USER'),
('userthirten', '$2a$10$o0lCPznuaJf3PmAO9IPUtu1BWaWmCMWxIjU8kYNwP5VwLX6HM7P8K', 'ROLE_USER'),
('userfourteen', '$2a$10$o0lCPznuaJf3PmAO9IPUtu1BWaWmCMWxIjU8kYNwP5VwLX6HM7P8K', 'ROLE_USER'),
('userfifteen', '$2a$10$o0lCPznuaJf3PmAO9IPUtu1BWaWmCMWxIjU8kYNwP5VwLX6HM7P8K', 'ROLE_USER'),
('usersixteen', '$2a$10$o0lCPznuaJf3PmAO9IPUtu1BWaWmCMWxIjU8kYNwP5VwLX6HM7P8K', 'ROLE_USER'),
('userseventeen', '$2a$10$o0lCPznuaJf3PmAO9IPUtu1BWaWmCMWxIjU8kYNwP5VwLX6HM7P8K', 'ROLE_USER'),
('usereighteen', '$2a$10$o0lCPznuaJf3PmAO9IPUtu1BWaWmCMWxIjU8kYNwP5VwLX6HM7P8K', 'ROLE_USER'),
('usernineteen', '$2a$10$o0lCPznuaJf3PmAO9IPUtu1BWaWmCMWxIjU8kYNwP5VwLX6HM7P8K', 'ROLE_USER'),
('usertwenty', '$2a$10$o0lCPznuaJf3PmAO9IPUtu1BWaWmCMWxIjU8kYNwP5VwLX6HM7P8K', 'ROLE_USER');

INSERT INTO tournaments (organizer_id, name, num_of_participants, type, from_date, to_date, game)
VALUES (3, 'LCS Championship', 12, 'Single', '2022-09-01', '2022-09-02', 'Golf'),
(4, 'NBA Championship', 12, 'Single', '2022-09-30', '2022-10-01', 'Wordle'),
(5, 'NFL Championship', 20, 'Single', '2022-10-10', '2022-10-20', 'Pool'),
(6, 'Sack Racing XTREME', 8, 'Single', '2022-11-01', '2022-11-02', 'Baduk'),
(7, 'Darts of Doom', 2, 'Single', '2022-09-01', '2022-11-02', 'Chess');


COMMIT;