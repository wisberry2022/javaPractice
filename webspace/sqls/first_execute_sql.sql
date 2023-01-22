create table if not exists userinfo (
	user_id varchar(25) primary key,
	pwd varchar(25) not null,
	email varchar(40) not null unique,
	signup date not null
);


--create table if not exists usertype (
--	id tinyint primary key auto_increment,
--	type varchar(20) not null
--);
--
--insert into usertype values(0, "admin");
--insert into usertype values(1, "guest");
