
CREATE TABLE users (
	id SERIAL  PRIMARY KEY,
	username varchar(30) NULL,
	"password" varchar(100) NULL,
	fname varchar(30) NULL,
	lname varchar(30) NULL,
	email varchar(100) NULL,
	status integer NULL
);

CREATE TABLE "comments" (
	comment_id SERIAL  PRIMARY KEY,
	anime_id integer NULL,
	"comment" varchar(255) NULL,
	author integer references users(id)
);
 

CREATE TABLE lists (
	id SERIAL  PRIMARY KEY,
	anime_id integer NULL,
 	user_rating integer NULL,
	status varchar(30) NULL,
    user_id integer references users(id)
);

