CREATE TABLE captcha_codes (
	id BIGSERIAL NOT NULL,
	code varchar(255) NOT NULL, 
	secret_code varchar(255) NOT NULL, 
	time timestamp NOT NULL, 
	PRIMARY KEY (id));

INSERT INTO captcha_codes
VALUES (1, '0000', '0000', '2021-05-03T08:42:48.122766800');