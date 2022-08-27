drop table if exists user_roles;
CREATE table if not exists  user_roles (
id SERIAL  PRIMARY KEY,
user_role varchar(30)  not null
);

drop table if exists users;
CREATE table if not exists  users (
id SERIAL  PRIMARY KEY,
username varchar(30)  not null,
password varchar(30)  not null,
first_name varchar(100)  not null,
last_name varchar(100)  not null,
email varchar(150)  not null,
CONSTRAINT users_username_key UNIQUE (username),
 role_id integer references user_roles(id)
);

drop table if exists reimbursement_status;
CREATE table if not exists  reimbursement_status (
id SERIAL  PRIMARY KEY,
reimb_status varchar(30) NULL
);

drop table if exists reimbursement_type;
CREATE table if not exists  reimbursement_type (
id SERIAL  PRIMARY KEY,
reimb_type varchar(30) NULL
);

drop table if exists reimbursement;
CREATE table if not exists  reimbursement (
id SERIAL  PRIMARY KEY,
amount decimal  DEFAULT 0,
submitted timestamp NULL DEFAULT CURRENT_TIMESTAMP,
resolved timestamp NULL,
description varchar(250)  null,
receipt varchar(250)  null,
author_id integer references users(id),
resolver_id integer references users(id),
reim_status_id integer references reimbursement_status(id),
reimb_type_id integer references reimbursement_type(id)
);
