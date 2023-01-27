CREATE TABLE department (
  id int,
  department varchar(255),
  line varchar(255),
  labor varchar(255),
  shift varchar(255)
);

CREATE TABLE user_detail (
  id int,
  username varchar(255),
  password varchar(255)
);

CREATE TABLE user_role (
  id int,
  username varchar(255),
  role varchar(255)
);