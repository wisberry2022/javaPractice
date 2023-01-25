use webdb;

create table if not exists usertype (
	id tinyint primary key auto_increment,
	type varchar(20) NOT NULL
);

insert into usertype(type) values('admin');
insert into usertype(type) values('guest');
insert into usertype(type) values('special');


create table if not exists userinfo (
	user_id varchar(25) primary key,
	pwd varchar(25) not null,
	email varchar(40) not null unique,
	signup date not null,
	typeid tinyint not null,
	foreign key (typeid) references usertype(id)
);

commit;
