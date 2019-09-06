insert into course(id, name, created_date, last_updated_date) 
	values (10001, 'JPA in 50 days', sysdate(), sysdate());
insert into course(id, name,created_date, last_updated_date) 
	values (10002, 'Spring in 50 days', sysdate(), sysdate());
insert into course(id, name,created_date, last_updated_date) 
	values (10003, 'Spring Boot in 100 days', sysdate(), sysdate());
insert into course(id, name,created_date, last_updated_date) 
	values (10004, 'Dummy1', sysdate(), sysdate());
insert into course(id, name,created_date, last_updated_date) 
	values (10005, 'Dummy2', sysdate(), sysdate());
insert into course(id, name,created_date, last_updated_date) 
	values (10006, 'Dummy3', sysdate(), sysdate());
insert into course(id, name,created_date, last_updated_date) 
	values (10007, 'Dummy4', sysdate(), sysdate());
insert into course(id, name,created_date, last_updated_date) 
	values (10008, 'Dummy5', sysdate(), sysdate());

insert into passport(id, number)
	values (40001,'E123456');
insert into passport(id, number)
	values (40002,'N123457');
insert into passport(id, number)
	values (40003,'L123890');
	
insert into student(id, name, passport_id)
	values (20001,'Hrishi', 40001);
insert into student(id, name,passport_id)
	values (20002,'Abhilash',40002);
insert into student(id, name,passport_id)
	values (20003,'Charlie',40003);
	

	
insert into review(id,rating,description,course_id)
	values (50001,5,'Great Course',10001);
insert into review(id, rating,description,course_id)
	values (50002,4,'Wonderful Course',10001);
insert into review(id, rating, description,course_id)
	values (50003,5,'Awesome Course',10003);
	
	
insert into student_course (student_id, course_id)
	values(20001,10001);
insert into student_course (student_id, course_id)
	values(20002,10001);
insert into student_course (student_id, course_id)
	values(20003,10001);
insert into student_course (student_id, course_id)
	values(20001,10003);