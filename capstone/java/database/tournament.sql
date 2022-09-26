BEGIN TRANSACTION;

DROP TABLE IF EXISTS tournaments, tournament_user, match_table;
DROP SEQUENCE IF EXISTS seq_tournament_id, seq_match_id;

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

COMMIT;