drop database if exists test;
create database test character set utf8 collate utf8_general_ci;

DROP TABLE IF EXISTS animal;
create table animal
(
  id int auto_increment
    primary key,
  animal_name varchar(45) null,
  animal_desc varchar(45) null,
  constraint id_UNIQUE
  unique (id)

)
  ENGINE = innoDB
  DEFAULT CHARACTER SET = utf8
;

DROP TABLE IF EXISTS users;
create table users
(
  id int auto_increment
    primary key,
  username varchar(45) null,
  password varchar(45) null,
  constraint id_UNIQUE
  unique (id)
)
  ENGINE = innoDB
  DEFAULT CHARACTER SET = utf8
;
