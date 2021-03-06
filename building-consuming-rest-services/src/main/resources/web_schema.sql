CREATE TABLE IF NOT EXISTS contact_msg (
		contact_id serial4 NOT NULL PRIMARY KEY,
		name varchar(100) NOT NULL,
		mobile_num varchar(10) NOT NULL,
		email varchar(100) NOT NULL,
		subject varchar(100) NOT NULL,
		status varchar(10) NOT NULL,
		created_at TIMESTAMP NOT NULL,
		created_by varchar(50) NOT NULL,
		updated_at TIMESTAMP DEFAULT NULL,
		updated_by varchar(50) DEFAULT NULL
		);
CREATE TABLE IF NOT EXISTS skill (
	    skill_id serial4 NOT NULL PRIMARY KEY,
		name varchar(100) NOT NULL,
		level varchar(20) NOT NULL,
		created_at TIMESTAMP NOT NULL,
		created_by varchar(50) NOT NULL,
		updated_at TIMESTAMP DEFAULT NULL,
		updated_by varchar(50) DEFAULT NULL
		);
CREATE TABLE IF NOT EXISTS roles (
	    role_id serial4 NOT NULL PRIMARY KEY,
		role_name varchar(100) NOT NULL,
		created_at TIMESTAMP NOT NULL,
		created_by varchar(50) NOT NULL,
		updated_at TIMESTAMP DEFAULT NULL,
		updated_by varchar(50) DEFAULT NULL
		);	
CREATE TABLE IF NOT EXISTS address (
	    address_id serial4 NOT NULL PRIMARY KEY,
		address1 varchar(300) NOT NULL,
		address2 varchar(300) NOT NULL,
		city varchar(50) NOT NULL,
		state varchar(50) NOT NULL,
		zip_code varchar(5) NOT NULL,
		created_at TIMESTAMP NOT NULL,
		created_by varchar(50) NOT NULL,
		updated_at TIMESTAMP DEFAULT NULL,
		updated_by varchar(50) DEFAULT NULL
		);		
CREATE TABLE IF NOT EXISTS person (
	    person_id serial4 NOT NULL PRIMARY KEY,
		name varchar(100) NOT NULL,
		mobile_num varchar(10) NOT NULL,
		email varchar(100) NOT NULL,
		password varchar(100) NOT NULL,
		role_id serial4 NOT NULL,
		address_id serial4 NOT NULL,
		created_at TIMESTAMP NOT NULL,
		created_by varchar(50) NOT NULL,
		updated_at TIMESTAMP DEFAULT NULL,
		updated_by varchar(50) DEFAULT NULL,
		foreign key(role_id) references roles(role_id),
		foreign key(address_id) references address(address_id)
		);		
ALTER TABLE public.person ALTER COLUMN address_id DROP NOT NULL;

CREATE TABLE IF NOT EXISTS classroom (
	    classroom_id serial4 NOT NULL PRIMARY KEY,
		name varchar(100) NOT NULL,
		created_at TIMESTAMP NOT NULL,
		created_by varchar(50) NOT NULL,
		updated_at TIMESTAMP DEFAULT NULL,
		updated_by varchar(50) DEFAULT NULL
		);	

alter table person add column  classroom_id int null;
alter table person add constraint fk_person_classroom_id foreign key (classroom_id) references classroom(classroom_id);

CREATE TABLE IF NOT EXISTS course (
	    course_id serial4 NOT NULL PRIMARY KEY,
		name varchar(100) NOT NULL,
		created_at TIMESTAMP NOT NULL,
		created_by varchar(50) NOT NULL,
		updated_at TIMESTAMP DEFAULT NULL,
		updated_by varchar(50) DEFAULT NULL
		);
		
	
CREATE TABLE IF NOT EXISTS person_courses (
	    person_id int NOT NULL,
		course_id int NOT NULL,
		foreign key(person_id) references person(person_id),
		foreign key(course_id) references course(course_id),
		primary key(person_id, course_id)
		);	