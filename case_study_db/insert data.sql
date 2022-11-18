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

-- insert data into sub table
insert into position_master(position) value (N'Quản Lý'),(N'Nhân Viên');
insert into level_master(level) value (N'Trung Cấp'),(N'Cao Đẳng'),(N'Đại Học' ),(N'Sau Đại Học');
insert into wordpart_master(workpart) value(N'Sale-Marketing'),(N'Hành chính'),(N'Phục vụ'),(N'Quản lý');
insert into customertype_master(type) value (N'Diamond'),(N'Platinium'),(N'Gold'),(N'Silver'),(N'Member');
insert into servicetype_master (type) value(N'Villa'),(N'House'),(N'Room');
insert into renttype_master(type) value (N'hour'),(N'day'),(N'mounth'),(N'year');
-- set data for service table
SET FOREIGN_KEY_CHECKS=0;
insert into service(name, area, rentprice, maxperson, standar, other_service_description, pool_area, floor, free_service,renttype_id,servicetype_id)
value (N'Villa Beach Front',25000,1000000,10,N'vip',N'Có hồ bơi',500,4,null,3,1);
insert into service(name, area, rentprice, maxperson, standar, other_service_description, pool_area, floor, free_service,renttype_id,servicetype_id)
value (N'House Princess 01',14000,5000000,10,N'vip',N'Có thêm bếp nướng',null,3,null,2,2);
insert into service(name, area, rentprice, maxperson, standar, other_service_description, pool_area, floor, free_service,renttype_id,servicetype_id)
value (N'Room Twin 01',5000,1000000,2,N'normal',N'Có tivi',null,null,N'1 Xe máy, 1 Xe đạp',4,3);
insert into service(name, area, rentprice, maxperson, standar, other_service_description, pool_area, floor, free_service,renttype_id,servicetype_id)
value (N'Villa No Beach Front',22000,9000000,8,N'normal',N'Có hồ bơi',300,3,null,3,1);
insert into service(name, area, rentprice, maxperson, standar, other_service_description, pool_area, floor, free_service,renttype_id,servicetype_id)
value (N'House Princess 02',10000,4000000,5,N'normal',N'Có thêm bếp nướng',null,2,null,3,2);
insert into service(name, area, rentprice, maxperson, standar, other_service_description, pool_area, floor, free_service,renttype_id,servicetype_id)
value (N'Room Twin 02',3000,900000,2,N'normal',N'Có tivi',null,null,'1 Xe máy',4,3);
-- set data for accompaniedservice table
insert into accompaniedservice_master(accompaniedservice, price, unit, status)
value 
(N'Karaoke', 10000, 'giờ', 'tiện nghi, hiện tại'),
(N'Thuê xe máy', 10000, 'chiếc', 'hỏng 1 xe'),
(N'Thuê xe đạp', 20000, 'chiếc', 'tốt'),
(N'Buffet buổi sáng', 15000, 'suất', 'đầy đủ đồ ăn, tráng miệng'),
(N'Buffet buổi trưa', 90000, 'suất', 'đầy đủ đồ ăn, tráng miệng'),
(N'Buffet buổi tối', 16000, 'suất', 'đầy đủ đồ ăn, tráng miệng');
-- insert data into contract_detail table
insert into contract_detail(count,contract_id,accompaniedservice_id)
value
(5,2,4),
(8,2,5),
(15,2,6),
(1,3,1),
(11,3,2),
(1,1,3),
(2,1,2),
(2,12,2);










