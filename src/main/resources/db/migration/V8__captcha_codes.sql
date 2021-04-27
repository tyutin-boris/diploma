CREATE TABLE captcha_codes (
	id int8 NOT NULL, 
	code varchar(255) NOT NULL, 
	secret_code varchar(255) NOT NULL, 
	time timestamp NOT NULL, 
	PRIMARY KEY (id));