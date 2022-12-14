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
 p_name varchar(50),
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
