CREATE TABLE comments (
	id int8 NOT NULL, 
	paren_id int8, 
	post_id int8 NOT NULL, 
	text varchar(255) NOT NULL, 
	time timestamp NOT NULL, 
	user_id int8 NOT NULL, 
	PRIMARY KEY (id));