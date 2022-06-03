create table member(

id int(45) not null auto_increment primary key,
email varchar(100) unique,
name varchar(45),
password varchar(45)
);

alter table member add role int(2);