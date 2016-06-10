drop table address;
create table address (
	address_id int not null auto_increment,
	street varchar(500) default NULL,
	postalCode int default 0,
	city varchar(500) default NULL,
	primary key(address_id)
);

drop table appointment;
create table appointment (
	appointment_id int not null auto_increment,
	startDate varchar(500) default '0000-00-00 00:00:00',
	endDate varchar(500) default '0000-00-00 00:00:00',
	location varchar(500) default NULL,
	primary key(appointment_id)
);

drop table doctor;
create table doctor (
	doctor_id int not null auto_increment,
	defaultLocation varchar(500) default NULL,
	primary key(doctor_id)
);

drop table location;
create table location (
	location_id int not null auto_increment,
	name varchar(500) default NULL,
	address varchar(500) default NULL,
	primary key(location_id)
);

drop table medicine;
create table medicine (
	medicine_id int not null auto_increment,
	name varchar(500) default NULL,
	manufacturer varchar(500) default NULL,
	doseUnit varchar(500) default NULL,
	sideEffect varchar(500) default NULL,
	primary key(medicine_id)
);

drop table patient;
create table patient (
	patient_id int not null auto_increment,
	threatment varchar(500) default NULL,
	primary key(patient_id)
);

drop table person;
create table person (
	person_id int not null auto_increment,
	firstName varchar(500) default NULL,
	lastName varchar(500) default NULL,
	address varchar(500) default NULL,
	username varchar(500) default NULL,
	password varchar(500) default NULL,
	primary key(person_id)
);

drop table prescription;
create table prescription (
	prescription_id int not null auto_increment,
	medicine varchar(500) default NULL,
	dose int default 0,
	taking varchar(500) default NULL,
	primary key(prescription_id)
);

drop table sideEffect;
create table sideEffect (
	siteEffect_id int not null auto_increment,
	name varchar(500) default NULL,
	description varchar(500) default NULL,
	primary key(siteEffect_id)
);

drop table treatment;
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

INSERT INTO address (address_id, street, postalCode, city) VALUES 
(1, 'Kranweg', 2000, 'Bern'),
(2, 'Hubstrasse', 3000, 'Zürich');
INSERT INTO appointment (appointment_id, startDate, endDate, location) VALUES 
(1, '2015-05-06 14:25:00', '2015-05-07 10:15:00', '{1}'),
(2, '2013-08-11 16:47:00', '2013-08-11 11:25:00', '{2}');
INSERT INTO doctor (doctor_id, defaultLocation) VALUES 
(1, '{1}');
INSERT INTO location (location_id, name, address) VALUES 
(1, 'Hubbabubba', '{1}'),
(2, 'Gerstensuppe', '{2}');
INSERT INTO medicine (medicine_id, name, manufacturer, doseUnit, sideEffect) VALUES 
(1, 'Viagra', 'Pfizer', 'Tablette', '{1}'),
(2, 'Aspirin', 'Bayer', 'Zäpfchen', '{2,3}');
INSERT INTO patient (patient_id, threatment) VALUES 
(1, '{1}'),
(2, '{2}');
INSERT INTO person (person_id, firstName, lastName, address, username, password) VALUES 
(1, 'Kriton', 'Tomani', '{1}', 'sexygirl69', '12345'),
(2, 'Guido', 'Bucher', '{2}', 'bruno', '12345');
INSERT INTO prescription (prescription_id, medicine, dose, taking) VALUES 
(1, '{1}', '1', '{1:"2016-06-14 12:46:00",2:"2016-06-15 23:00:00"}'),
(2, '{2}', '50', '{1:"2016-06-13 01:23:00",2:"2016-06-15 10:56:00"}');
INSERT INTO sideEffect (siteEffect_id, name, description) VALUES 
(1, 'Husten', 'Leichtes Husten am linken Arm'),
(2, 'Haarausfall', 'Haarausfall im Genitalbereich'),
(3, 'Aufgeschlagenes Knie', 'Blutende Wunde am linken Knie');
INSERT INTO treatment (treatment_id, name, prescription, startDate, endDate, appointments, description) VALUES 
(1, 'Gerötetes Ohrläppchen', '{1}', '2015-05-06 16:09:00', '2056-04-08 20:14:00', '{1}', 'Unatürliches Rot am Ohrläppchen wegen zuviel Bewegung.'),
(2, 'Bierbauch', '{2}', '2013-08-11 07:06:00', '2013-08-11 12:53:00', '{2}', 'Gewichtsabnahme nach Biermangel');