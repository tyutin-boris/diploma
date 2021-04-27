CREATE TABLE posts (
	id int8 NOT NULL,
	is_active boolean NOT NULL,
	moderation_id int8,
	moderation_status int4 NOT NULL,
	time timestamp NOT NULL,
	title varchar(255) NOT NULL,
	user_id int8 NOT NULL,
	view_count int4 NOT NULL,
	PRIMARY KEY (id));