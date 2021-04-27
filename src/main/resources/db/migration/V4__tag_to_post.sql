CREATE TABLE tag_to_post (
	id int8 NOT NULL, 
	post_id int8 NOT NULL, 
	tag_id int8 NOT NULL, 
	PRIMARY KEY (id));