create table address (
	address_id int not null auto_increment,
	street varchar(500) default NULL,
	postalCode int default 0,
	city varchar(500) default NULL,
	primary key(address_id)
);
create table appointment (
	appointment_id int not null auto_increment,
	startDate varchar(500) default '0000-00-00 00:00:00',
	endDate varchar(500) default '0000-00-00 00:00:00',
	location varchar(500) default NULL,
	primary key(appointment_id)
);
create table doctor (
	doctor_id int not null auto_increment,
	defaultLocation varchar(500) default NULL,
	primary key(doctor_id)
);
create table location (
	location_id int not null auto_increment,
	name varchar(500) default NULL,
	address varchar(500) default NULL,
	primary key(location_id)
);
create table medicine (
	medicine_id int not null auto_increment,
	name varchar(500) default NULL,
	manufacturer varchar(500) default NULL,
	doseUnit varchar(500) default NULL,
	sideEffect varchar(500) default NULL,
	primary key(medicine_id)
);
create table patient (
	patient_id int not null auto_increment,
	threatment varchar(500) default NULL,
	primary key(patient_id)
);
create table person (
	person_id int not null auto_increment,
	firstName varchar(500) default NULL,
	lastName varchar(500) default NULL,
	address varchar(500) default NULL,
	username varchar(500) default NULL,
	password varchar(500) default NULL,
	primary key(person_id)
);
create table prescription (
	prescription_id int not null auto_increment,
	medicine varchar(500) default NULL,
	dose int default 0,
	taking varchar(500) default NULL,
	primary key(prescription_id)
);
create table sideEffect (
	siteEffect_id int not null auto_increment,
	name varchar(500) default NULL,
	description varchar(500) default NULL,
	primary key(siteEffect_id)
);
create table treatment (
	treatment_id int not null auto_increment,
	name varchar(500) default NULL,
	prescription varchar(500) default NULL,
	startDate varchar(500) default '0000-00-00 00:00:00',
	endDate varchar(500) default '0000-00-00 00:00:00',
	appointments varchar(500) default NULL,
	description varchar(500) default NULL,
	primary key(treatment_id)
);