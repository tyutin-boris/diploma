CREATE TABLE global_settings (
	id BIGSERIAL NOT NULL,
	code varchar(255) NOT NULL UNIQUE,
	value boolean NOT NULL,
	PRIMARY KEY (id));

INSERT INTO global_settings
    VALUES (1,'MULTIUSER_MODE', true),
           (2,'POST_PREMODERATION', false),
           (3,'STATISTICS_IS_PUBLIC', false);
