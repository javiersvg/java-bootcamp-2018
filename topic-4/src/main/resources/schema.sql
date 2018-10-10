create database high_school;
create table high_school.student (id INT, first_name VARCHAR(20), last_name VARCHAR(20), date_of_birth DATE, PRIMARY KEY (id));
create table high_school.teacher (id INT, first_name VARCHAR(20), last_name VARCHAR(20), date_of_birth DATE, PRIMARY KEY (id));
create table high_school.course (id INT, course_name VARCHAR(40), teacher_id INT, week_hours INT, course_start DATE, PRIMARY KEY (id), FOREIGN KEY (teacher_id) REFERENCES high_school.teacher(id) ON DELETE CASCADE);
create table high_school.schedule (course_id INT, week_day VARCHAR(20), start_time TIME, end_time TIME, FOREIGN KEY (course_id) REFERENCES high_school.course(id) ON DELETE CASCADE);
create table high_school.registration (student_id INT, course_id INT, first_note FLOAT, second_note FLOAT, third_note FLOAT, FOREIGN KEY (student_id) REFERENCES high_school.student(id) ON DELETE CASCADE, FOREIGN KEY (course_id) REFERENCES high_school.course(id) ON DELETE CASCADE);
create user high_school_admin identified by 'high_school_admin_password';
grant SELECT, INSERT, UPDATE, DELETE on high_school.* to 'high_school_admin';