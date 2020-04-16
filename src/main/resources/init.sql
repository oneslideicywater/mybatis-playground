CREATE TABLE users
(
    id int(11) NOT NULL AUTO_INCREMENT,
    name varchar(100) NOT NULL,
    salary float(10) DEFAULT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE Address
(
  id int primary key auto_increment,
  street varchar(100) not null ,
  details varchar(100) not null ,
  userid int(11),
  foreign key(userid) references users(id) on update cascade
);