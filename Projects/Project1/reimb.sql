create table if not exists ERS_REIMBURSMENT (
reimb_id serial UNIQUE int,
reimb_amount float,
reimb_submitted timestamp,
reimb_resolved timestamp,
reimb_description varchar(250),
reimb_author int,
reimb_resolver int,
reimb_status_id int,
reimb_type_id,
primary key (reimb_id),
constraint ers_users_fk_auth
	foreign key (reimb_author)


);

create table if not exists ERS_USERS (
ers_users_id serial unique int,
ers_username varchar (50),
ers_password varchar (50),
user_first_name varchar (100),
user_last_name varchar (100),
user_email varchar(150),
user_role_id int

);

create table if not exists ERS_USER_ROLES (
ers_user_role_id int,
user_role varchar(10)

);

create table if not exists ERS_REIMBURSMENT_TYPE(
reimb_type_id int,
reimb_type varchar(10),

);

create table if not exists ERS_REIMBURSTMENT_STATUS(
reimb_status_id int,
reimb_status varchar(10)

);