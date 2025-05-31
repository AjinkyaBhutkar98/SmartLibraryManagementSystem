CREATE TABLE IF NOT EXISTS users (
  id int NOT NULL AUTO_INCREMENT,
  name varchar(100) NOT NULL,
  email varchar(20) DEFAULT NULL,
  password varchar(100) NOT NULL,
  city varchar(10) DEFAULT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY name (name),
  UNIQUE KEY email (email)
);

CREATE TABLE IF NOT EXISTS books(
id int auto_increment primary key,
title varchar(255) not null,
about text,
author varchar(255),
language varchar(255),
price_per_day int default 0,
available boolean default true
);

CREATE TABLE IF NOT EXISTS issue_books(
id int auto_increment primary key,
book_id int not null,
user_id int not null,
book_issue_date date not null,
price int not null,
book_submit_date date not null,
is_return boolean default false,
foreign key (book_id) references books(id),
foreign key (user_id) references users(id)


);