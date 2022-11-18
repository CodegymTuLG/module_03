
select * from student where studentname like 'h%';
select * from class where month(startdate) = 12;
select * from `subject` where credit between 3 and 5;
update student set classid = 2 where studentname = 'hung';
select a.StudentName, c.SubName, b.Mark from student a
join mark b on a.studentid = b.studentid 
join subject c on b.subid = c.subid
order by b.mark desc, a.StudentName asc
