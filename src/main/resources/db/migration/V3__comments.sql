CREATE TABLE comments (
	id BIGSERIAL NOT NULL,
	paren_id int8, 
	post_id int8 references posts (id) NOT NULL,
	text varchar(255) NOT NULL, 
	time timestamp NOT NULL, 
	user_id int8 references users (id) NOT NULL,
	PRIMARY KEY (id));

INSERT INTO comments (id, post_id, text, time, user_id)
    VALUES (0, 25, 'comment', '2021-05-03T08:42:48.122766800', 0),
           (1, 25, 'comment', '2021-05-03T08:42:48.122766800', 1),
           (2, 25, 'comment', '2021-05-03T08:42:48.122766800', 2),
           (3, 24, 'comment', '2021-05-03T08:42:48.122766800', 0),
           (4, 24, 'comment', '2021-05-03T08:42:48.122766800', 0),
           (5, 24, 'comment', '2021-05-03T08:42:48.122766800', 0),
           (6, 24, 'comment', '2021-05-03T08:42:48.122766800', 0),
           (7, 2, 'comment', '2021-05-03T08:42:48.122766800', 2),
           (8, 1, 'comment', '2021-05-03T08:42:48.122766800', 1);