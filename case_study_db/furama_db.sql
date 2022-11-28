drop database furamaproject;
create database furamaproject;
use furamaproject;
create table position_master(position_id int auto_increment auto_increment primary key, 
position varchar(45));
create table level_master(level_id int auto_increment primary key, 
`level` varchar(45));
create table wordpart_master(wordpart_id int auto_increment primary key, 
workpart varchar(45));
create table employee_info(employee_id int auto_increment primary key, 
name varchar(45), 
birthday date, 
cardid varchar(25), 
salary double, 
phonenumber varchar(11), 
email varchar(45), 
address varchar(45), 
position_id int, 
level_id int, 
wordpart_id int,
foreign key(position_id) references position_master(position_id),
foreign key(level_id) references level_master(level_id),
foreign key(wordpart_id) references wordpart_master(wordpart_id)
);
create table customertype_master(customertype_id int auto_increment primary key, 
type varchar(45));
create table customer_info(customer_id int auto_increment primary key, 
customertype_id int, 
name varchar(45), 
birthday date, 
sex bit(1), 
cardid varchar(25),
phonenumber varchar(11), 
email varchar(45),
address varchar(45),
foreign key(customertype_id) references customertype_master(customertype_id)
);
create table renttype_master(renttype_id int auto_increment primary key, 
`type` varchar(45));
create table servicetype_master(servicetype_id int auto_increment primary key, 
`type` varchar(45));
create table service(service_id int auto_increment primary key, 
`name` varchar(45),
area int,
rentprice double,
maxperson int,
renttype_id int,
servicetype_id int,
standar varchar(45),
other_service_description varchar(45),
pool_area double,
floor int,
free_service text,
foreign key(renttype_id) references renttype_master(renttype_id),
foreign key(servicetype_id) references servicetype_master(servicetype_id)
);
create table contract(contract_id int auto_increment primary key, 
startdate date, 
enddate date, 
deposit varchar(45), 
payment varchar(45), 
employee_id int, 
customer_id int, 
service_id int,
foreign key(employee_id) references employee_info(employee_id),
foreign key(customer_id) references customer_info(customer_id),
foreign key(service_id) references service(service_id)
);
create table accompaniedservice_master(accompaniedservice_id int auto_increment primary key, 
accompaniedservice varchar(45), 
price double, 
unit varchar(10), 
`status` varchar(45));
create table contract_detail(id int auto_increment primary key,  
contract_id int, 
accompaniedservice_id int, 
count int,
foreign key(contract_id) references contract(contract_id),
foreign key(accompaniedservice_id) references accompaniedservice_master(accompaniedservice_id)
);
