-- users definition

-- Drop table

-- DROP TABLE users;

CREATE TABLE users (
	id serial4 NOT NULL,
	email varchar(255) NOT NULL,
	"password" varchar(30) NOT NULL,
	first_name varchar(30) NOT NULL,
	last_name varchar(30) NOT NULL,
	profile_pic varchar(1000) NULL,
	username varchar(25) NOT NULL,
	professional_url varchar(1000) NULL,
	"location" varchar(50) NULL,
	name_pronunciation varchar(30) NULL,
	CONSTRAINT users_pkey PRIMARY KEY (id)
);

-- posts definition

-- Drop table

-- DROP TABLE posts;

CREATE TABLE posts (
	id serial4 NOT NULL,
	"text" varchar(255) NULL,
	image_url varchar(1000) NULL,
	comments_id int4 NULL,
	author_id int4 NOT NULL,
	like_count int4 NULL DEFAULT 0,
	CONSTRAINT posts_pkey PRIMARY KEY (id)
);

-- follower definition

-- Drop table

-- DROP TABLE follower;

CREATE TABLE follower (
	follower_id int4 NOT NULL,
	following_id int4 NOT NULL,
	CONSTRAINT follower_pkey PRIMARY KEY (follower_id, following_id)
);


-- follower foreign keys

ALTER TABLE follower ADD CONSTRAINT follower_follower_id_fkey FOREIGN KEY (follower_id) REFERENCES users(id);
ALTER TABLE follower ADD CONSTRAINT follower_following_id_fkey FOREIGN KEY (following_id) REFERENCES users(id);

-- hobbies definition

-- Drop table

-- DROP TABLE hobbies;

CREATE TABLE hobbies (
	id serial4 NOT NULL,
	user_id int4 NULL,
	hobby_1 varchar(20) NULL,
	hobby_2 varchar(20) NULL,
	hobby_3 varchar(20) NULL,
	CONSTRAINT hobbies_pkey PRIMARY KEY (id)
);


-- hobbies foreign keys

ALTER TABLE hobbies ADD CONSTRAINT hobbies_user_id_fkey FOREIGN KEY (user_id) REFERENCES users(id);

-- likes definition

-- Drop table

-- DROP TABLE likes;

CREATE TABLE likes (
	id serial4 NOT NULL,
	user_id int4 NOT NULL,
	post_id int4 NOT NULL,
	CONSTRAINT likes_pkey PRIMARY KEY (id)
);


-- likes foreign keys

ALTER TABLE likes ADD CONSTRAINT likes_post_id_fkey FOREIGN KEY (post_id) REFERENCES posts(id);
ALTER TABLE likes ADD CONSTRAINT likes_user_id_fkey FOREIGN KEY (user_id) REFERENCES users(id);

-- notification definition

-- Drop table

-- DROP TABLE notification;

CREATE TABLE notification (
	id serial4 NOT NULL,
	notification_body varchar(255) NOT NULL,
	user_id int4 NOT NULL,
	notification_type varchar(10) NOT NULL,
	"timestamp" timestamp NULL,
	status varchar(10) NOT NULL,
	CONSTRAINT notification_pkey PRIMARY KEY (id)
);


-- notification foreign keys

ALTER TABLE notification ADD CONSTRAINT notification_user_id_fkey FOREIGN KEY (user_id) REFERENCES users(id);


-- posts foreign keys

ALTER TABLE posts ADD CONSTRAINT posts_author_id_fkey FOREIGN KEY (author_id) REFERENCES users(id);
ALTER TABLE posts ADD CONSTRAINT posts_comments_id_fkey FOREIGN KEY (comments_id) REFERENCES posts(id);
ALTER TABLE posts ADD CONSTRAINT posts_comments_id_fkey1 FOREIGN KEY (comments_id) REFERENCES posts(id);

