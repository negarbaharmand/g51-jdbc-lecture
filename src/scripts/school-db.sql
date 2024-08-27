create database school_db;
use school_db;

-- Create student table
create table student(
student_id int primary key auto_increment,
first_name varchar(50),
last_name varchar(50),
age int,
email varchar(100),
create_date datetime default now()
);

select * from student;
select * from student where student_id = 1;

-- Insert sample data to the student table

insert into student(first_name, last_name, age, email) values
('John', 'Doe', 20, 'john.doe@example.com'),
('Alice', 'Smith', 22, 'alice.smith@example.com'),
('Bob', 'Johnson', 21, 'bob.johnson@example.com'),
('Emily', 'Davis', 23, 'emily.davis@example.com');

create table course(
course_id int primary key auto_increment,
course_name varchar(100)
);

insert into course (course_name) values
('Mathematics'),
('History'),
('Computer science');

 -- 1 1 2   2 1 2   3 2 1  4 2 1.  (2,1)
 create table students_courses(
 student_id int,
 course_id int,
 primary key(student_id, course_id),
 foreign key (student_id) references student(student_id),
 foreign key (course_id) references course(course_id)
 );

 insert into students_courses (student_id, course_id) values
 (1,1),
 (1,3),
 (2,3),
 (3,1),
 (4,3);


 select * from students_courses;













