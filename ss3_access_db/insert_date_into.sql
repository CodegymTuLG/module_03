drop database ss2_bt2;
create database if not exists ss2_bt2;
use ss2_bt2;
create table customer (
c_id int primary key auto_increment,
c_name varchar(50),
c_age int
);
create table `order`(
o_id int primary key auto_increment,
c_id int,
o_date date,
o_totalprice double,
foreign key(c_id) references customer(c_id)
);
create table product(
 p_id int primary key auto_increment,
 p_name int,
 p_price float
);
create table orderdetail(
 o_id int,
 p_id int,
 od_qty int,
 primary key(o_id,p_id),
 foreign key(o_id) references `order`(o_id),
 foreign key(p_id) references product(p_id)
);
use ss2_bt2;
insert into customer(c_name, c_age) values 
('Minh Quan',10),
('Ngoc Anh',20),
('Hong Ha',50);
insert into `order`(c_id, o_date,o_totalprice) values 
(1,'2006-3-21',null),
(1,'2006-3-23',null),
(1,'2006-3-16',null);
insert into product(p_name, p_price) values 
('May Giat',3),
('Tu Lanh',5),
('Dieu Hoa',7),
('Quat',1),
('Bep Dien',2);
insert into orderdetail(o_id,p_id, od_qty) values 
(1,1,3),
(1,3,7),
(1,4,2),
(2,1,1),
(3,1,8),
(2,5,4),
(2,3,3);
