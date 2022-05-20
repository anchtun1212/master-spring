CREATE TABLE IF NOT EXISTS contact_msg (
		contact_id serial4  PRIMARY KEY,
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
		name varchar(100) NOT NULL,
		level varchar(20) NOT NULL,
		created_at TIMESTAMP NOT NULL,
		created_by varchar(50) NOT NULL,
		updated_at TIMESTAMP DEFAULT NULL,
		updated_by varchar(50) DEFAULT NULL
		);