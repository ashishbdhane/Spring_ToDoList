create database todo_db

use todo_db


CREATE TABLE user_details(
	user_id INT IDENTITY,
	name VARCHAR(20) NOT NULL,
	mobile_no VARCHAR(10) NOT NULL,
	email TEXT NOT NULL,
	password VARCHAR(20) NOT NULL,
	CONSTRAINT user_id_pk PRIMARY KEY(user_id),
)


CREATE TABLE task_details(
	task_id INT IDENTITY,
	user_id INT NOT NULL,
	title TEXT NOT NULL,
	description TEXT,
	status VARCHAR(12) NOT NULL,
	CONSTRAINT task_user_fk FOREIGN KEY(user_id) REFERENCES user_details(user_id),
	CONSTRAINT check_status CHECK(status in ('PENDING', 'COMPLETED', 'INPROGRESS')),
)
