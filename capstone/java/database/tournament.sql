BEGIN TRANSACTION;

DROP TABLE IF EXISTS tournaments, tournament_user, matches, invites;
DROP SEQUENCE IF EXISTS seq_tournament_id, seq_match_id, seq_invite_id;

CREATE SEQUENCE seq_tournament_id
INCREMENT BY 1
START WITH 1001
NO MAXVALUE;

CREATE TABLE tournaments(
	tournament_id int NOT NULL DEFAULT nextval('seq_tournament_id'),
	organizer_id int NOT NULL,
	name VARCHAR(100) NOT NULL,
	num_of_participants int NOT NULL,
	type VARCHAR(50),
	from_date DATE NOT NULL,
	to_date DATE NOT NULL,
	game VARCHAR(50),
	img_url VARCHAR(400),
	description VARCHAR(200),

	CONSTRAINT pk_tournament_id PRIMARY KEY (tournament_id),
	CONSTRAINT fk_organizer_id FOREIGN KEY (organizer_id) REFERENCES users(user_id)
);

CREATE SEQUENCE seq_match_id
INCREMENT BY 1
START WITH 2001
NO MAXVALUE;

CREATE TABLE matches(
	match_id int NOT NULL DEFAULT nextval ('seq_match_id'),
	tournament_id int NOT NULL,
	home_player VARCHAR(30),
	away_player VARCHAR(30),
	winner VARCHAR(30),
	round int NOT NULL,
	
	CONSTRAINT pk_match_id PRIMARY KEY (match_id)

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
	invite_id int NOT NULL DEFAULT nextval('seq_invite_id'),
	tournament_id int NOT NULL,
	organizer_id int NOT NULL,
	player_id int NOT NULL,
	status VARCHAR(20) NOT NULL,
	type VARCHAR(20) NOT NULL,
	
	CONSTRAINT pk_invite_id PRIMARY KEY (invite_id),
	CONSTRAINT fk_tournament_id FOREIGN KEY (tournament_id) REFERENCES tournaments(tournament_id),
	CONSTRAINT fk_organizer_id FOREIGN KEY (organizer_id) REFERENCES users(user_id),
	CONSTRAINT fk_player_id FOREIGN KEY (player_id) REFERENCES users(user_id)
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
('JollyOwl7', '$2a$10$o0lCPznuaJf3PmAO9IPUtu1BWaWmCMWxIjU8kYNwP5VwLX6HM7P8K', 'ROLE_USER'),
('WrongCow', '$2a$10$o0lCPznuaJf3PmAO9IPUtu1BWaWmCMWxIjU8kYNwP5VwLX6HM7P8K', 'ROLE_USER'),
('LOWERCASEGUY', '$2a$10$o0lCPznuaJf3PmAO9IPUtu1BWaWmCMWxIjU8kYNwP5VwLX6HM7P8K', 'ROLE_USER'),
('Titan99', '$2a$10$o0lCPznuaJf3PmAO9IPUtu1BWaWmCMWxIjU8kYNwP5VwLX6HM7P8K', 'ROLE_USER'),
('TacocaT', '$2a$10$o0lCPznuaJf3PmAO9IPUtu1BWaWmCMWxIjU8kYNwP5VwLX6HM7P8K', 'ROLE_USER'),
('EvilBirdie', '$2a$10$o0lCPznuaJf3PmAO9IPUtu1BWaWmCMWxIjU8kYNwP5VwLX6HM7P8K', 'ROLE_USER'),
('BehindYou', '$2a$10$o0lCPznuaJf3PmAO9IPUtu1BWaWmCMWxIjU8kYNwP5VwLX6HM7P8K', 'ROLE_USER'),
('RainSparkle^-^', '$2a$10$o0lCPznuaJf3PmAO9IPUtu1BWaWmCMWxIjU8kYNwP5VwLX6HM7P8K', 'ROLE_USER'),
('NoThisIsPatrick', '$2a$10$o0lCPznuaJf3PmAO9IPUtu1BWaWmCMWxIjU8kYNwP5VwLX6HM7P8K', 'ROLE_USER'),
('JarJarBlinkz', '$2a$10$o0lCPznuaJf3PmAO9IPUtu1BWaWmCMWxIjU8kYNwP5VwLX6HM7P8K', 'ROLE_USER'),
('XxAquaHeroxX', '$2a$10$o0lCPznuaJf3PmAO9IPUtu1BWaWmCMWxIjU8kYNwP5VwLX6HM7P8K', 'ROLE_USER'),
('WeirdBug', '$2a$10$o0lCPznuaJf3PmAO9IPUtu1BWaWmCMWxIjU8kYNwP5VwLX6HM7P8K', 'ROLE_USER'),
('StrangeFlash77', '$2a$10$o0lCPznuaJf3PmAO9IPUtu1BWaWmCMWxIjU8kYNwP5VwLX6HM7P8K', 'ROLE_USER'),
('DoctorPecan', '$2a$10$o0lCPznuaJf3PmAO9IPUtu1BWaWmCMWxIjU8kYNwP5VwLX6HM7P8K', 'ROLE_USER'),
('LunchPiggy', '$2a$10$o0lCPznuaJf3PmAO9IPUtu1BWaWmCMWxIjU8kYNwP5VwLX6HM7P8K', 'ROLE_USER'),
('KungFuBarbie', '$2a$10$o0lCPznuaJf3PmAO9IPUtu1BWaWmCMWxIjU8kYNwP5VwLX6HM7P8K', 'ROLE_USER'),
('DietTurtle', '$2a$10$o0lCPznuaJf3PmAO9IPUtu1BWaWmCMWxIjU8kYNwP5VwLX6HM7P8K', 'ROLE_USER'),
('CappyBlappy', '$2a$10$o0lCPznuaJf3PmAO9IPUtu1BWaWmCMWxIjU8kYNwP5VwLX6HM7P8K', 'ROLE_USER'),
('360NoScope', '$2a$10$o0lCPznuaJf3PmAO9IPUtu1BWaWmCMWxIjU8kYNwP5VwLX6HM7P8K', 'ROLE_USER');


INSERT INTO tournaments (organizer_id, name, num_of_participants, type, from_date, to_date, game, img_url)
VALUES (3, 'LCS Championship', 12, 'Single', '2022-09-01', '2022-09-02', 'League of Legends', 'https://images.contentstack.io/v3/assets/bltad9188aa9a70543a/bltf13665b20f0246fc/5e704ff93ed79e6484b30d66/LCSxGPxMC_Announcement_MediaKeyArt_1600x900.jpg?width=3200&height=1800'),
(4, 'NBA Championship', 12, 'Single', '2022-09-30', '2022-10-01', 'Basketball', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSPn44KOMB35Kf4ZkT4eFHL3ej_lBl9GTIksA&usqp=CAU'),
(5, 'NFL Championship', 20, 'Single', '2022-10-10', '2022-10-20', 'Football', 'https://www.gannett-cdn.com/presto/2020/11/23/PCHH/4f90c673-ff62-4e66-8605-ce8ae2e9cb10-635787293743493871-453653643.jpg?width=1200&disable=upscale&format=pjpg&auto=webp'),
(6, 'Sack Racing XTREME', 8, 'Single', '2022-11-01', '2022-11-02', 'Sack Racing', 'https://i.ytimg.com/vi/A7XYZ__HL6Q/maxresdefault.jpg'),
(7, 'Darts of Doom', 12, 'Single', '2022-09-01', '2022-11-02', 'Nerf Gun Battle', 'https://vinepair.com/wp-content/uploads/2017/03/darts-social.jpg'),
(8, 'Beyblade Battle Royal', 8, 'Single', '2022-10-20', '2022-10-20', 'Beyblades', 'https://verbnow.com/wp-content/uploads/2021/04/toys-like-beyblade-Apr262021-1-1.jpg'),
(9, 'COD Championship Challenge', 16, 'Single', '2022-10-31', '2022-11-02', 'Call Of Duty', 'https://bnetproduct-a.akamaihd.net//40/e1ad45153cfc2017906f72e637877b2d-WZ_Camaraderie_Refresh_Keyart_Textless-Bnet-Shop_Card_Feature-960x540.jpg'),
(10, 'Lawn Darts League', 6, 'Single', '2022-11-15', '2022-11-16', 'Lawn Darts', 'https://helios-i.mashable.com/imagery/articles/01qeKWK5hPNoVO54D1GXgyk/hero-image.fill.size_1200x1200.v1623370634.jpg'),
(11, 'Amatuer Fire Spinning Contest', 10, 'Single', '2022-10-10', '2022-10-20', 'Fire Spinning', 'https://images.squarespace-cdn.com/content/v1/55425191e4b01b6210bd4781/1496349775732-462HGSO6QUY5XR1UERQQ/Fire+Poi+Photography'),
(12, 'Pumpkin Pie Eating Contest', 4, 'Single', '2022-10-30', '2022-10-30', 'Eating', 'https://pumpkinfest.miramarevents.com/images/photos/activities/pie-eating-contestants-closeup-2-2017-lg.jpg'),
(13, 'The Great Jack-O-Lantern Carve Off', 8, 'Single', '2022-09-01', '2022-11-02', 'Pumpkin Carving', 'https://food.unl.edu/newsletters/images/jack-o-lantern_0.jpg'),
(14, 'TE Super Smash Bros Invitational', 64, 'Single', '2022-10-07', '2022-10-08', 'SSB Melee', 'https://www.gameinformer.com/s3/files/styles/body_default/s3/legacy-images/imagefeed/How%20Super%20Smash%20Bros.%20Melee%20Has%20Stood%20The%20Test%20Of%20Time/smashbrosmelee_5F00_610.jpg'),
(15, 'CSGO Regional Finals', 16, 'Single', '2022-12-10', '2022-12-12', 'Counter Strike', 'https://www.dictionary.com/e/wp-content/uploads/2018/07/CS-GO3.jpg'),
(16, 'Big Bad Bingo Blowout', 24, 'Single', '2022-09-01', '2022-11-02', 'Bingo', 'https://image1.masterfile.com/getImage/NjczLTAyMTM5MDM3ZW4uMDAwMDAwMDA=AMnaCZ/673-02139037en_Masterfile.jpg'),
(17, 'Solitaire', 4, 'Single', '2022-12-20', '2022-12-20', 'Solitaire', 'https://nationaltoday.com/wp-content/uploads/2021/05/Solitaire.jpg'),
(18, 'Chess International Finals', 20, 'Single', '2022-11-11', '2022-11-12', 'Chess', 'https://media.wired.com/photos/5f592bfb643fbe1f6e6807ec/191:100/w_2400,h_1256,c_limit/business_chess_1200074974.jpg');

INSERT INTO tournament_user (user_id, tournament_id)
VALUES (3,1001), (4,1001), (5,1001), (6,1001), (7,1001), (8,1001), (9,1001), (10,1001), (11,1001), (12,1001), (12,1001), (14,1001),
(15,1002), (16,1002), (17,1002), (18,1002), (19,1002), (20,1002), (21,1002), (22,1002), (23,1002), (24,1002), (25,1002), (26,1002),
(31,1005), (30,1005), (29,1005), (28,1005), (27,1005), (26,1005), (25,1005), (24,1005),
(1,1014), (2,1014), (3,1014), (4,1014), (5,1014), (6,1014), (7,1014), (8,1014), (9,1014), (10,1014), (11,1014), (12,1014), (13,1014), (14,1014), (15,1014), (17,1014), (18,1014), (19,1014), (20,1014), (21,1014); 


COMMIT;