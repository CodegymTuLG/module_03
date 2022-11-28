use furamaproject;
-- 21.	Tạo khung nhìn có tên là v_nhan_vien để lấy được thông tin của tất cả các nhân viên có địa chỉ là “Hải Châu” và đã từng lập hợp đồng cho một hoặc nhiều khách hàng bất kì với ngày lập hợp đồng là “12/12/2019”.
create view w_employee as
select ei.* from employee_info ei
join contract c on ei.employee_id = c.employee_id
 where c.startdate = '2019-12-12'
 and ei.address like '%Hải Châu%';
-- 22.	Thông qua khung nhìn v_nhan_vien thực hiện cập nhật địa chỉ thành “Liên Chiểu” đối với tất cả các nhân viên được nhìn thấy bởi khung nhìn này.
update w_employee set address = replace(address,'Hải Châu','Liên Chiểu');
-- 23.	Tạo Stored Procedure sp_xoa_khach_hang dùng để xóa thông tin của một khách hàng nào đó với ma_khach_hang được truyền vào như là 1 tham số của sp_xoa_khach_hang.
drop procedure sp_delete_customer;
delimiter //
create procedure sp_delete_customer(IN id_delete int)
begin
delete from product where customer_id =  id_delete;
end//
delimiter ;
-- 24.	Tạo Stored Procedure sp_them_moi_hop_dong dùng để thêm mới vào bảng hop_dong với yêu cầu sp_them_moi_hop_dong phải thực hiện kiểm tra tính hợp lệ của dữ liệu bổ sung, 
-- với nguyên tắc không được trùng khóa chính và đảm bảo toàn vẹn tham chiếu đến các bảng liên quan.
drop procedure sp_add_contract;
delimiter //
create procedure sp_add_contract(IN 
sp_startdate date,
sp_enddate date,
sp_deposit varchar(45),
sp_employee_id int,
sp_customer_id int,
sp_service_id int)
begin
insert into contract(startdate, enddate, deposit, employee_id, customer_id, service_id)
values
(sp_startdate, sp_enddate, sp_deposit,
if(sp_employee_id not in (select employee_id from employee_info),(select 'employee_id not exits' as 'message error'), sp_employee_id), 
if(sp_customer_id not in (select customer_id from customer_info),(select 'customer_id not exits' as 'message error'), sp_customer_id), 
if(sp_service_id not in (select service_id from service),(select 'service_id not exits' as 'message error'), sp_service_id));
end//
delimiter ;

call sp_add_contract(
'2022-11-11', 
'2022-11-11', 
'ádasd', 
4,
50,
5);
-- 25.	Tạo Trigger có tên tr_xoa_hop_dong khi xóa bản ghi trong bảng hop_dong thì hiển thị tổng số lượng bản ghi còn lại có trong bảng hop_dong ra giao diện console của database.
drop table log;
drop trigger tr_delete_contract;
create table log(id int auto_increment primary key, 
table_action varchar(45), 
action varchar(45),
message varchar(200),
time datetime);
delimiter //
create trigger tr_delete_contract
after delete on contract
for each row
begin
       insert into log(table_action,action,message,time)
value('contract', 'delete', 'contract table have '+(select count(contract_id) from contract)+' records after delete',now());
end//
delimiter ;
-- 26.	Tạo Trigger có tên tr_cap_nhat_hop_dong khi cập nhật ngày kết thúc hợp đồng, cần kiểm tra xem thời gian cập nhật có phù hợp hay không, với quy tắc sau: 
-- Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày.
-- Nếu dữ liệu hợp lệ thì cho phép cập nhật, nếu dữ liệu không hợp lệ thì in ra thông báo “Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày” trên console của database.
drop trigger tr_update_contract_write_log
delimiter //
create trigger tr_update_contract_write_log
before update on contract
for each row
begin
if datediff(new.enddate,old.startdate) < 2
    then
       insert into log(table_action, action, message, time)
       value('contract', 'update', 'Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày',now());
       update contract set enddate = old.enddate where contract_id = old.contract_id;
       end if;  
end//
delimiter ;

-- 27.	Tạo Function thực hiện yêu cầu sau:
-- a.	Tạo Function func_dem_dich_vu: Đếm các dịch vụ đã được sử dụng với tổng tiền là > 2.000.000 VNĐ.
drop function f_count_service
DELIMITER //
create function f_count_service()
returns int
deterministic
begin
declare result int;
 set result = (select count(*) from accompaniedservice_master am join contract_detail cd on cd.accompaniedservice_id = am.accompaniedservice_id
where cd.count*am.price > 200000);
return result;
end //
DELIMITER ;
select f_count_service();
-- b.	Tạo Function func_tinh_thoi_gian_hop_dong: Tính khoảng thời gian dài nhất tính từ lúc bắt đầu làm hợp đồng đến lúc kết thúc hợp đồng mà khách hàng đã thực hiện thuê dịch vụ 
-- (lưu ý chỉ xét các khoảng thời gian dựa vào từng lần làm hợp đồng thuê dịch vụ, không xét trên toàn bộ các lần làm hợp đồng). Mã của khách hàng được truyền vào như là 1 tham số của function này.
drop function f_count_service
DELIMITER //
create function f_count_service(id int)
returns int
deterministic
begin
declare result int;
	if id in (select customer_id from customer_info) then
	set result = (select max(datediff(c.enddate,c.startdate)) from customer_info ci
	join contract c on c.customer_id = ci.customer_id
	where ci.customer_id = id group by ci.customer_id);
	end if;
    return result;
end //
DELIMITER ;
-- 28.	Tạo Stored Procedure sp_xoa_dich_vu_va_hd_room để tìm các dịch vụ được thuê bởi khách hàng với loại dịch vụ là “Room” từ đầu năm 2015 đến hết năm 2019 để xóa thông tin của các dịch vụ đó 
-- (tức là xóa các bảng ghi trong bảng dich_vu) và xóa những hop_dong sử dụng dịch vụ liên quan (tức là phải xóa những bản gi trong bảng hop_dong) và những bản liên quan khác.
drop procedure sp_delete_contract_service_room;
delimiter //
create procedure sp_delete_contract_service_room()
begin
delete from contract where service_id in (select service_id from service where name like '%Room%') and (year(enddate) between 2015 and 2019);
delete from service where name like '%Room%';
end//
delimiter ;
call sp_delete_contract_service_room();
