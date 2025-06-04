create  database test999;
use test999;
create table ttt(
	id char(10),
	pw char(4),
	name varchar(20),
    age int
);

insert into ttt values ("aaa","1234","jang minsol",27);
insert into ttt(id,pw,name,aidge) values("bbb","1234","jang jieun",21);

select id,pw,name,age from ttt;