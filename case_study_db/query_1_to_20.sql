use furamaproject;
-- 2.   Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 kí tự.
select  * from employee_info where (name like 'h%' or name like 't%' or name like 'k%') and character_length(name) <= 15;
-- 3.	Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
select  * from customer_info where (datediff(curtime(),birthday)/365.25 between 18 and 50) and (address like '%Đà Nẵng' or address like '%Quảng Trị');
-- 4.	Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.
select a.customer_id, a.name, count(c.customer_id) as count from customer_info a join customertype_master b on a.customertype_id = b.customertype_id 
join contract c on a.customer_id = c.customer_id
where type = 'Diamond'
group by c.customer_id
order by count asc;
-- 5.	Hiển thị ma_khach_hang, ho_ten, ten_loai_khach, ma_hop_dong, ten_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tong_tien 
-- (Với tổng tiền được tính theo công thức như sau: Chi Phí Thuê + Số Lượng * Giá, với Số Lượng và Giá là từ bảng dich_vu_di_kem, hop_dong_chi_tiet) cho tất cả các khách hàng đã từng đặt phòng. 
-- (những khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).
select a.customer_id, a.name, b.type , c.contract_id, d.name, c.startdate, c.enddate, ifnull(sum(if(c.enddate=c.startdate,1,datediff(c.enddate,c.startdate))*d.rentprice)+sum(f.price* e.count),sum(if(c.enddate=c.startdate,1,datediff(c.enddate,c.startdate))*d.rentprice)) as total  from customer_info a join customertype_master b on a.customertype_id = b.customertype_id 
left join contract c on a.customer_id = c.customer_id
left join service d on c.service_id = d.service_id
left join contract_detail e on c.contract_id = e.contract_id
left join accompaniedservice_master f on e.accompaniedservice_id = f.accompaniedservice_id
group by c.contract_id
order by a.customer_id;
-- 6.	Hiển thị ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, ten_loai_dich_vu của tất cả các loại dịch vụ chưa từng được khách hàng thực hiện đặt trong quý 1 của năm 2021 (Quý 1 là tháng 1, 2, 3).
select a.service_id, a.name, a.area, a.rentprice, b.type  from service a join servicetype_master b on a.servicetype_id = b.servicetype_id where service_id not in
(select service_id from contract where year(startdate) = 2021 and month(startdate) between 1 and 3);
-- 7.	Hiển thị thông tin ma_dich_vu, ten_dich_vu, dien_tich, so_nguoi_toi_da, chi_phi_thue, ten_loai_dich_vu của tất cả các 
-- loại dịch vụ đã từng được khách hàng đặt phòng trong năm 2020 nhưng chưa từng được khách hàng đặt phòng trong năm 2021.
select s.service_id, s.name, s.area, s.maxperson, s.rentprice, st.type from service s join servicetype_master st on s.servicetype_id = st.servicetype_id where s.service_id in(
select c.service_id from contract c where c.service_id not in (select c.service_id from contract c where year(startdate) = 2021) and year(startdate) = 2020);
-- 8.	Hiển thị thông tin ho_ten khách hàng có trong hệ thống, với yêu cầu ho_ten không trùng nhau.
-- Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên.
select ci.name from customer_info ci group by ci.name;

select ci.name from customer_info ci group by ci.name;

select ci.name from customer_info ci group by ci.name;
-- 9.	Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong năm 2021 thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.
select year(startdate) as year, month(startdate) as month, count(contract_id) as 'count contract' from contract group by month(startdate) order by year, month;
-- 10.	Hiển thị thông tin tương ứng với từng hợp đồng thì đã sử dụng bao nhiêu dịch vụ đi kèm.
-- Kết quả hiển thị bao gồm ma_hop_dong, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, so_luong_dich_vu_di_kem (được tính dựa trên việc sum so_luong ở dich_vu_di_kem).
select c.contract_id, c.startdate, c.enddate, c.deposit, ifnull(sum(count),0) as 'count accompanied service' from contract c left join contract_detail cd on cd.contract_id = c.contract_id group by c.contract_id;
-- 11.	Hiển thị thông tin các dịch vụ đi kèm đã được sử dụng bởi những khách hàng có ten_loai_khach là “Diamond” và có dia_chi ở “Vinh” hoặc “Quảng Ngãi”.
select am.* from accompaniedservice_master am where accompaniedservice_id  in (
select cd.accompaniedservice_id from contract_detail cd 
join accompaniedservice_master am on cd.accompaniedservice_id = am.accompaniedservice_id
join contract c on c.contract_id = cd.contract_id 
join customer_info ci on ci.customer_id = c.customer_id
join customertype_master cm on ci.customertype_id = cm.customertype_id
where cm.type ='Diamond' and (address like '%Vinh' or address like '%Quảng Ngãi'));
-- 12.	Hiển thị thông tin ma_hop_dong, ho_ten (nhân viên), ho_ten (khách hàng), so_dien_thoai (khách hàng), ten_dich_vu,so_luong_dich_vu_di_kem
-- (được tính dựa trên việc sum so_luong ở dich_vu_di_kem), tien_dat_coc của tất cả các dịch vụ đã từng được 
-- khách hàng đặt vào 3 tháng cuối năm 2020 nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2021.
select c.contract_id, ei.name, ci.name, ci.phonenumber, c.deposit from contract c 
join  customer_info ci on ci.customer_id = c.customer_id
join  employee_info ei on c.employee_id = ei.employee_id
where c.contract_id in
(select contract_id from contract c where 
contract_id in 
(select contract_id from contract where year(startdate) = 2020 and month(startdate) >= 10) 
and 
contract_id not in  
(select contract_id from contract where (year(startdate) = 2021 and month(startdate) <= 6)));
-- 13.	Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng. (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).
drop view w_count;
create view w_count as
select am.accompaniedservice_id, am.accompaniedservice, sum(cd.count) as times from accompaniedservice_master am 
join contract_detail cd on am.accompaniedservice_id = cd.accompaniedservice_id 
group by cd.accompaniedservice_id;
select accompaniedservice_id, accompaniedservice, times from w_count
where times = (select max(times) from w_count);

select am.accompaniedservice_id, am.accompaniedservice, sum(cd.count) as times from accompaniedservice_master am 
join contract_detail cd on am.accompaniedservice_id = cd.accompaniedservice_id 
group by cd.accompaniedservice_id
having times =(
select sum(cd.count) as times from accompaniedservice_master am 
join contract_detail cd on am.accompaniedservice_id = cd.accompaniedservice_id 
group by cd.accompaniedservice_id
order by times desc
limit 1);
-- 14.	Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất. 
-- Thông tin hiển thị bao gồm ma_hop_dong, ten_loai_dich_vu, ten_dich_vu_di_kem, so_lan_su_dung (được tính dựa trên việc count các ma_dich_vu_di_kem).
select c.contract_id, sm.type, am.accompaniedservice, cd.count from contract c 
join servicetype_master sm on sm.servicetype_id = c.service_id
join contract_detail cd on cd.contract_id = c.contract_id
join accompaniedservice_master am on am.accompaniedservice_id = cd.accompaniedservice_id 
where cd.count = 1;
-- 15.	Hiển thi thông tin của tất cả nhân viên bao gồm ma_nhan_vien, ho_ten, ten_trinh_do, ten_bo_phan, so_dien_thoai, dia_chi mới chỉ lập được tối đa 3 hợp đồng từ năm 2020 đến 2021.
select ei.employee_id, ei.name, lm.level, wm.workpart, ei.phonenumber, ei.address from  employee_info ei 
join level_master lm on lm.level_id = ei.level_id
join workpart_master wm on wm.workpart_id = ei.workpart_id
join contract c on c.employee_id = ei.employee_id
where year(startdate) in (2020,2021)
group by ei.employee_id 
having count(ei.employee_id) <= 3;
-- 16.	Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2019 đến năm 2021.
delete from employee_info where employee_id not in (
select ei.employee_id from employee_info ei join contract c on c.employee_id = ei.employee_id
where year(startdate) between 1019 and 2021
group by ei.employee_id
);
-- 17.	Cập nhật thông tin những khách hàng có ten_loai_khach từ Platinum lên Diamond, chỉ cập nhật những khách hàng đã từng đặt phòng với Tổng Tiền thanh toán trong năm 2021 là lớn hơn 10.000.000 VNĐ.
drop view w_customer_amount;
create view w_customer_amount as
select a.customer_id, a.name as customer_name, b.type , c.contract_id, d.name as service_name, c.startdate, c.enddate, ifnull(sum(if(c.enddate=c.startdate,1,datediff(c.enddate,c.startdate))*d.rentprice)+sum(f.price* e.count),sum(if(c.enddate=c.startdate,1,datediff(c.enddate,c.startdate))*d.rentprice)) as total  from customer_info a join customertype_master b on a.customertype_id = b.customertype_id 
left join contract c on a.customer_id = c.customer_id
left join service d on c.service_id = d.service_id
left join contract_detail e on c.contract_id = e.contract_id
left join accompaniedservice_master f on e.accompaniedservice_id = f.accompaniedservice_id
group by c.contract_id
order by a.customer_id;
update customer_info set customertype_id = 1
where customertype_id = 2 
and customertype_id in (select customer_id from w_customer_amount where total > 1000000);
drop view w_customer_amount;
-- 18.	Xóa những khách hàng có hợp đồng trước năm 2021 (chú ý ràng buộc giữa các bảng).
set FOREIGN_KEY_CHECKS=0;
delete from customer_info where customer_id in(
select ci.customer_id from customer_info ci join
contract c on ci.customer_id = c.customer_id where year(startdate) <2021);
SET FOREIGN_KEY_CHECKS=1;
-- 19.	Cập nhật giá cho các dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2020 lên gấp đôi.
update accompaniedservice_master set price = price*2
where accompaniedservice_id in (select am.accompaniedservice_id from accompaniedservice_master am 
join contract_detail cd on am.accompaniedservice_id = cd.accompaniedservice_id 
join contract c on c.contract_id = cd.contract_id
where year(c.startdate) = 2020
group by cd.accompaniedservice_id
having sum(cd.count) >= 10);
-- 20.	Hiển thị thông tin của tất cả các nhân viên và khách hàng có trong hệ thống, thông tin hiển thị bao gồm id (ma_nhan_vien, ma_khach_hang), ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi.
select employee_id as id, name, email, phonenumber, birthday, address from employee_info
union 
select ((select max(employee_id) from employee_info)+customer_id) as id, name, ci.email, ci.phonenumber, ci.birthday, ci.address from customer_info ci;