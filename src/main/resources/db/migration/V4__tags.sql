CREATE TABLE tags (
	id BIGSERIAL NOT NULL,
	name varchar(255) NOT NULL,
	PRIMARY KEY (id));

INSERT INTO tags
    VALUES (0,'Java'),
           (1,'Spring'),
           (2,'Hibernate'),
           (3,'Hadoop');