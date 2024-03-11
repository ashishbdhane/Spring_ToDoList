create database todo_db

use todo_db



CREATE TABLE user_details(
	user_id INT IDENTITY,
	name VARCHAR(20) NOT NULL,
	mobile_no VARCHAR(10) NOT NULL,
	email VARCHAR(20) NOT NULL,
	password TEXT NOT NULL,
	CONSTRAINT user_id_pk PRIMARY KEY(user_id),
	CONSTRAINT email_unique UNIQUE(email),
)

CREATE TABLE task_details(
	task_id INT IDENTITY,
	user_id INT NOT NULL,
	title TEXT NOT NULL,
	description TEXT,
	status VARCHAR(12) NOT NULL,
	CONSTRAINT task_id_pk PRIMARY KEY(task_id),
	CONSTRAINT task_user_fk FOREIGN KEY(user_id) REFERENCES user_details(user_id),
	CONSTRAINT check_status CHECK(status in ('PENDING', 'COMPLETED', 'INPROGRESS')),
)


INSERT INTO user_details (name,mobile_no,email,password)  values('User 1','12331','abc@gmail.com','123');
SELECT * from user_details where user_id = 1;

INSERT INTO task_details(user_id,title,description,status) values (1,'first task','I want to do this by 2 am tmrw','PENDING')
UPDATE task_details SET title = ?, description = ?, status = ? where task_id = ?
DELETE from task_details where task_id = ?
SELECT * from task_details where user_id = ?
