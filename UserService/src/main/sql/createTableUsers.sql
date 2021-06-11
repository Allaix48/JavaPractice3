CREATE TABLE users
(
	userid			SERIAL PRIMARY KEY,

	username		VARCHAR(16) UNIQUE NOT NULL,
	password		VARCHAR(32) NOT NULL,

	subscribes		INTEGER[] DEFAULT '{}',
	followers		INTEGER[] DEFAULT '{}',
    birthday	    DATE,

    fullname	    TEXT,
    sex			    SMALLINT DEFAULT 0,

    country		    TEXT,
    city		    TEXT,
    school		    TEXT,
    university	    TEXT
);