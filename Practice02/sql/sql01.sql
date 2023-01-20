show databases;

use student;

create table gradeTable (
	id int primary key auto_increment,
	ml tinyint not null,
	eng tinyint not null,
	math tinyint not null,
	check ((ml >= 0 and ml <= 100) and (eng >= 0 and eng <=100) and (math >= 0 and math <= 100))
);