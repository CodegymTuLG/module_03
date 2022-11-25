drop database furamaproject;
create database furamaproject;
use furamaproject;
create table position_master(position_id int auto_increment auto_increment primary key, 
position varchar(45));
create table level_master(level_id int auto_increment primary key, 
`level` varchar(45));
create table workpart_master(workpart_id int auto_increment primary key, 
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
workpart_id int,
foreign key(position_id) references position_master(position_id),
foreign key(level_id) references level_master(level_id),
foreign key(workpart_id) references workpart_master(workpart_id)
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
SET FOREIGN_KEY_CHECKS=0;
-- insert data into sub table
insert into position_master(position) value (N'Quản Lý'),(N'Nhân Viên');
insert into level_master(level) value (N'Trung Cấp'),(N'Cao Đẳng'),(N'Đại Học' ),(N'Sau Đại Học');
insert into workpart_master(workpart) value(N'Sale-Marketing'),(N'Hành chính'),(N'Phục vụ'),(N'Quản lý');
insert into customertype_master(type) value (N'Diamond'),(N'Platinium'),(N'Gold'),(N'Silver'),(N'Member');
insert into servicetype_master (type) value(N'Villa'),(N'House'),(N'Room');
insert into renttype_master(type) value (N'hour'),(N'day'),(N'mounth'),(N'year');
-- set data for service table
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
values
(N'Karaoke', 10000, 'giờ', 'tiện nghi, hiện tại'),
(N'Thuê xe máy', 10000, 'chiếc', 'hỏng 1 xe'),
(N'Thuê xe đạp', 20000, 'chiếc', 'tốt'),
(N'Buffet buổi sáng', 15000, 'suất', 'đầy đủ đồ ăn, tráng miệng'),
(N'Buffet buổi trưa', 90000, 'suất', 'đầy đủ đồ ăn, tráng miệng'),
(N'Buffet buổi tối', 16000, 'suất', 'đầy đủ đồ ăn, tráng miệng');
-- insert data into contract_detail table
insert into contract_detail(count,contract_id,accompaniedservice_id)
values
(5,2,4),
(8,2,5),
(15,2,6),
(1,3,1),
(11,3,2),
(1,1,3),
(2,1,2),
(2,12,2);
-- insert data into contract table
insert into contract(startdate, enddate, deposit, employee_id, customer_id, service_id)
values
('2020-12-08','2020-12-08',0,3,1,3),
('2020-07-14','2020-07-21',200000,7,3,1),
('2021-03-15','2021-03-17',50000,3,4,2),
('2021-01-14','2021-01-18',100000,7,5,5),
('2021-07-14','2021-07-15',0,7,2,6),
('2021-06-01','2021-06-03',0,7,7,6),
('2021-09-02','2021-09-05',100000,7,4,4),
('2021-06-17','2021-06-18',150000,3,4,1),
('2020-11-19','2020-11-19',0,3,4,3),
('2021-04-12','2021-04-14',0,10,3,5),
('2021-04-25','2021-04-25',0,2,2,1),
('2021-05-25','2021-05-27',0,7,10,1);
-- insert data into customer table
insert into customer_info(name, birthday, sex, cardid, phonenumber, email, address, customertype_id)
values
('Nguyễn Thị Hào','1970-11-07',0,'643431213','0945423362','thihao07@gmail.com','23 Nguyễn Hoàng, Đà Nẵng',5),
('Phạm Xuân Diệu','1992-08-08',1,'865342123','0954333333','xuandieu92@gmail.com','K77/22 Thái Phiên, Quảng Trị',3),
('Trương Đình Nghệ','1990-02-27',1,'488645199','0373213122','nghenhan2702@gmail.com','K323/12 Ông Ích Khiêm, Vinh',1),
('Dương Văn Quan','1981-07-08',1,'543432111','0490039241','duongquan@gmail.com','K453/12 Lê Lợi, Đà Nẵng',1),
('Hoàng Trần Nhi Nhi','1995-12-09',0,'795453345','0312345678','nhinhi123@gmail.com','224 Lý Thái Tổ, Gia Lai',4),
('Tôn Nữ Mộc Châu','2005-12-06',0,'732434215','0988888844','tonnuchau@gmail.com','37 Yên Thế, Đà Nẵng',4),
('Nguyễn Mỹ Kim','1984-04-08',0,'856453123','0912345698','kimcuong84@gmail.com','K123/45 Lê Lợi, Hồ Chí Minh',1),
('Nguyễn Thị Hào','1999-04-08',0,'965656433','0763212345','haohao99@gmail.com','55 Nguyễn Văn Linh, Kon Tum',3),
('Trần Đại Danh','1994-07-01',1,'432341235','0643343433','danhhai99@gmail.com','24 Lý Thường Kiệt, Quảng Ngãi',1),
('Nguyễn Tâm Đắc','1989-07-01',1,'344343432','0987654321','dactam@gmail.com','22 Ngô Quyền, Đà Nẵng',2);
-- insert data into customer table
insert into employee_info(name, birthday, cardid, salary, phonenumber, email, address, position_id, level_id, workpart_id)
values
('Nguyễn Văn An','1970-11-07','456231786',10000000,'0901234121','annguyen@gmail.com','295 Nguyễn Tất Thành, Đà Nẵng',1,3,1),
('Lê Văn Bình','1997-04-09','654231234',7000000,'0934212314','binhlv@gmail.com','22 Yên Bái, Đà Nẵng',1,2,2),
('Hồ Thị Yến','1995-12-12','999231723',14000000,'0412352315','thiyen@gmail.com','K234/11 Điện Biên Phủ, Gia Lai',1,3,2),
('Võ Công Toản','1980-04-04','123231365',17000000,'0374443232','toan0404@gmail.com','77 Hoàng Diệu, Quảng Trị',1,4,4),
('Nguyễn Bỉnh Phát','1999-12-09','454363232',6000000,'0902341231','phatphat@gmail.com','43 Yên Bái, Đà Nẵng',2,1,1),
('Khúc Nguyễn An Nghi','2000-11-08','964542311',7000000,'0978653213','annghi20@gmail.com','294 Nguyễn Tất Thành, Đà Nẵng',2,2,3),
('Nguyễn Hữu Hà','1993-01-01','534323231',8000000,'0941234553','nhh0101@gmail.com','4 Nguyễn Chí Thanh, Huế',2,3,2),
('Nguyễn Hà Đông','1989-09-03','234414123',9000000,'0642123111','donghanguyen@gmail.com','111 Hùng Vương, Hà Nội',2,4,4),
('Tòng Hoang','1982-09-03','256781231',6000000,'0245144444','hoangtong@gmail.com','213 Hàm Nghi, Đà Nẵng',2,4,4),
('Nguyễn Công Đạo','1994-01-08','755434343',8000000,'0988767111','nguyencongdao12@gmail.com','6 Hoà Khánh, Đồng Nai',2,3,2);
