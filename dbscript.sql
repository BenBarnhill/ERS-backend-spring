CREATE DATABASE project2;

\c project2;

CREATE TABLE admin_details(admin_id int GENERATED ALWAYS AS IDENTITY, 
admin_password varchar(20), 
admin_first_name varchar(20), 
admin_last_name varchar(20), 
admin_contact bigint, 
admin_email varchar(30), 
admin_address varchar(50), 
admin_role varchar(20), 
PRIMARY KEY(admin_id));

INSERT INTO admin_details VALUES(DEFAULT, 
'password', 
'Boss', 
'Baby', 
4536789654, 
'bossbaby@gmail.com', 
'123 Coolsville USA', 
'admin');

CREATE TABLE employee_details(emp_id int GENERATED ALWAYS AS IDENTITY, 
emp_password varchar(20), 
emp_first_name varchar(20), 
emp_last_name varchar(20), 
emp_contact bigint, 
emp_email varchar(30), 
emp_address varchar(50), 
emp_admin int, 
emp_role varchar(20), 
PRIMARY KEY(emp_id), 
CONSTRAINT fk_adminId FOREIGN KEY(emp_admin) REFERENCES admin_details(admin_id) ON DELETE NO ACTION); 

INSERT INTO employee_details(DEFAULT, 
'password', 
'Bob', 
'Smith', 
1234567890, 
'bobsmith@gmail.com', 
'432 Main Street USA', 
1, 
'employee');

CREATE TABLE reimbursements_pending(pend_id int GENERATED ALWAYS AS IDENTITY, 
pend_request int, 
pend_amount double precision, 
pend_reason varchar(30), 
pend_request_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP, 
pend_resolve_time varchar(20), 
pend_response int, 
pend_status varchar(20), 
PRIMARY KEY(pend_id), 
CONSTRAINT fk_empId FOREIGN KEY(pend_request) REFERENCES employee_details(emp_id) ON DELETE NO ACTION, 
CONSTRAINT fk_adminId FOREIGN KEY(pend_response) REFERENCES admin_details(admin_id) ON DELETE NO ACTION);

CREATE TABLE reimbursements_final(final_id int, 
final_request int, 
final_amount double precision, 
final_reason varchar(30), 
final_request_time varchar(30), 
final_resolve_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP, 
final_response int, 
final_status varchar(20), 
PRIMARY KEY(final_id), 
CONSTRAINT fk_empId FOREIGN KEY(final_request) REFERENCES employee_details(emp_id) ON DELETE NO ACTION, 
CONSTRAINT fk_adminId FOREIGN KEY(final_response) REFERENCES admin_details(admin_id) ON DELETE NO ACTION);

CREATE TABLE files(file_id int GENERATED ALWAYS AS IDENTITY, 
file_name varchar(100), 
file_type varchar(20), 
file_type bytea, 
PRIMARY KEY(file_id));