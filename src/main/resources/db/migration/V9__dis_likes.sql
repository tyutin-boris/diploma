CREATE TABLE dis_likes (
	id BIGSERIAL NOT NULL,
	user_id int8 references users (id) NOT NULL,
	post_id int8 references posts (id) NOT NULL,
	time timestamp NOT NULL,
	PRIMARY KEY (id));

INSERT INTO dis_likes
    VALUES (0, 1, 1, '2021-05-03T08:42:48.122766800'),
           (1, 2, 24, '2021-05-03T08:42:48.122766800'),
           (2, 0, 22, '2021-05-03T08:42:48.122766800'),
           (3, 2, 24, '2021-05-03T08:42:48.122766800'),
           (4, 2, 23, '2021-05-03T08:42:48.122766800'),
           (5, 0, 23, '2021-05-03T08:42:48.122766800'),
           (6, 2, 23, '2021-05-03T08:42:48.122766800'),
           (7, 1, 25, '2021-05-03T08:42:48.122766800');