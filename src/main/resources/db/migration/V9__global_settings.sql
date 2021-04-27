CREATE TABLE global_settings (
	id int8 NOT NULL, 
	code int4 NOT NULL, 
	name varchar(255) NOT NULL,
	value boolean NOT NULL,
	PRIMARY KEY (id));