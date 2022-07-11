create table if not exists ERS_REIMBURSMENT (
reimb_id serial primary key,
reimb_amount float,
reimb_submitted timestamp,
reimb_resolved timestamp,
reimb_description varchar(250),
reimb_author int references ERS_USERS(ers_users_id),
reimb_resolver int references ERS_USERS(ers_users_id),
reimb_status_id int references ERS_REIMBURSTMENT_STATUS(reimb_status_id),
reimb_type_id int references ERS_REIMBURSMENT_TYPE(reimb_type_id)
);

create table if not exists ERS_USERS (
ers_users_id serial primary key,
ers_username varchar (50) UNIQUE,
ers_password varchar (50),
user_first_name varchar (100),
user_last_name varchar (100),
user_email varchar(150) UNIQUE,
user_role_id int references ERS_USER_ROLES(ers_user_role_id)
);

create table if not exists ERS_USER_ROLES (
ers_user_role_id serial primary key,
user_role varchar(10)
);

create table if not exists ERS_REIMBURSMENT_TYPE(
reimb_type_id serial primary key,
reimb_type varchar(10),
);

create table if not exists ERS_REIMBURSTMENT_STATUS(
reimb_status_id serial primary key,
reimb_status varchar(10)
);