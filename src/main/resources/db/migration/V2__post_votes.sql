CREATE TABLE post_votes (
	id int8 NOT NULL,
	post_id int8 NOT NULL,
	time timestamp NOT NULL,
	user_id int8 NOT NULL,
	value boolean NOT NULL,
	PRIMARY KEY (id));