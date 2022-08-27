drop table if exists roles cascade;
CREATE table if not exists  roles (
id SERIAL  PRIMARY KEY,
role_name varchar(30)  not null
);
insert into roles (id, role_name) values  (1, 'employee');
insert into roles (id, role_name) values  (2, 'customer');
insert into roles (id, role_name) values  (3, 'manager');

drop table if exists users Cascade;
CREATE table if not exists  users (
id SERIAL  PRIMARY KEY,
username varchar(30)  not null,
password varchar(30)  not null,
status integer NULL DEFAULT 1,
role_id integer references roles(id)
);
insert into users (username, password, role_id) values  ('employee', '12345', 1);
insert into users (username, password, role_id) values  ('customer', '12345', 3);
insert into users (username, password, role_id) values  ('manager', '12345', 3);


drop table if exists products;
CREATE table if not exists  products (
id SERIAL  PRIMARY KEY,
product_name varchar(100)  not null,
price decimal DEFAULT 0,
paid_status integer NULL DEFAULT 0,
user_id integer references users(id)
);
insert into products (product_name, price) values  ('cards', 10);
insert into products (product_name, price) values  ('motercyle', 20);
insert into products (product_name, price) values  ('house', 200);


drop table if exists offers;
CREATE table if not exists  offers (
id SERIAL  PRIMARY KEY,
offer_price decimal  DEFAULT 0,
status integer DEFAULT 0,
product_id integer references products(id),
created_at timestamp NULL DEFAULT CURRENT_TIMESTAMP,
user_id integer references users(id)
);

insert into offers (offer_price, product_id, user_id) values  ('18.09', (select id from users where username = 'customer'), (select id from products p  where product_name  = 'cards'));

drop table if exists payment_connection  Cascade;
CREATE table if not exists  payment_connection (
id SERIAL  PRIMARY KEY,
transaction_no varchar(255) NULL,
offer_price decimal  DEFAULT 0,
payment_details varchar(255), 
active integer DEFAULT 0,
user_id integer references users(id),
product_id integer references products(id),
offers_id integer references offers(id)
);

drop table if exists payment; 
CREATE table if not exists  payment (
id SERIAL  PRIMARY KEY,
paid decimal  DEFAULT 0,
active integer DEFAULT 0,
primary_payment integer DEFAULT 0,
payment_connection_id integer references payment_connection(id),
created_at timestamp NULL DEFAULT CURRENT_TIMESTAMP
); 
 



 
