CREATE TABLE likes (
	id BIGSERIAL NOT NULL,
	user_id int8 references users (id) NOT NULL,
	post_id int8 references posts (id) NOT NULL,
	time timestamp NOT NULL,
	PRIMARY KEY (id));

INSERT INTO likes
    VALUES (0, 0, 1, '2021-05-03T08:42:48.122766800'),
           (1, 0, 24, '2021-05-03T08:42:48.122766800'),
           (2, 1, 24, '2021-05-03T08:42:48.122766800'),
           (4, 0, 25, '2021-05-03T08:42:48.122766800'),
           (5, 1, 25, '2021-05-03T08:42:48.122766800'),
           (6, 2, 25, '2021-05-03T08:42:48.122766800');
