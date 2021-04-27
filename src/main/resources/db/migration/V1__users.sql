CREATE sequence hibernate_sequence start 1 increment 1;

CREATE TABLE users (
	id int8 NOT NULL,
	code varchar(255),
	email varchar(255) NOT NULL,
	is_moderator boolean NOT NULL,
	name varchar(255) NOT NULL,
	password varchar(255) NOT NULL,
	photo varchar(255),
	reg_time timestamp NOT NULL,
	PRIMARY KEY (id));