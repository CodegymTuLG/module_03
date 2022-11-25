-- Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất.
use quanlysinhvien;
select * from subject s where credit = (select max(credit) from subject);
-- Hiển thị các thông tin môn học có điểm thi lớn nhất.
select s.* from subject s 
join mark m on m.SubId = s.SubId
where m.mark = (select max(mark) from mark);
-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần
select s.*, ifnull(avg(m.mark),'không có điểm') as 'avg mark' from student s left join mark m on m.StudentId = s.StudentId group by s.StudentId;


