INSERT INTO course(id, name, created_date, last_updated_date, is_deleted) 
VALUES
	(10001, 'JPA in 50 steps', sysdate(), sysdate(), false),
	(10002, 'Spring in 50 steps', sysdate(), sysdate(), false),
	(10003, 'Spring Boot in 100 steps', sysdate(), sysdate(), false),
	(10004, 'Spring Microservices in 77 steps', sysdate(), sysdate(), false);


INSERT INTO student(id, name)
VALUES
	(20001, 'Danish'),
	(20002, 'Beenish'),
	(20003, 'Sehrish');
	

INSERT INTO passport(id, number)
VALUES
	(40001, 'E123456'),
	(40002, 'N123456'),
	(40003, 'L123456');
	

INSERT INTO review(id, rating, description, course_id)
VALUES
	(50001, '5', 'Great Course', 10001),
	(50002, '4', 'Wonderful Course', 10001),
	(50003, '5', 'Awesome Course', 10003);
	
INSERT INTO student_course(student_id, course_id)
VALUES
	(20001, 10001),
	(20002, 10001),
	(20003, 10001),
	(20001, 10003);