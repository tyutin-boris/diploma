CREATE sequence hibernate_sequence start 1 increment 1;

CREATE TABLE users (
	id BIGSERIAL NOT NULL,
	is_moderator boolean NOT NULL,
	reg_time timestamp NOT NULL,
	name varchar(255) NOT NULL,
	email varchar(255) NOT NULL,
	password varchar(255) NOT NULL,
	code varchar(255),
	photo varchar(255),
	PRIMARY KEY (id));

INSERT INTO users (id, is_moderator, reg_time, name, email, password)
    VALUES (0, true, '2021-05-03T08:42:48.122766800', 'Boris', 'Boris@mail.com', '0000'),
           (1, false, '2021-05-03T08:42:48.122766800', 'Ivan', 'IvanIvanov@mail.com', '0000'),
           (2, false, '2021-05-03T08:42:48.122766800', 'Peter', 'Petrov@mail.com', '0000');
