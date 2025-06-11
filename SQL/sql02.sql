use world;

select count(*) from city;
select * from city limit 5;

create table city_popul(
	city_name char(35),
    population int
);

insert into city_popul select Name, Population from city; -- 다른 테이블의 데이터를 한번에 입력하는 구문

select * from city_popul;

update city_popul set city_name = '서울' where city_name = 'Seoul';
select * from city_popul where city_name = '서울';

update city_popul set city_name='뉴욕', population = 0 where city_name = 'New York';
select * from city_popul where city_name = '뉴욕';

update city_popul set population = population + 1 where city_name = '뉴욕';

delete from city_popul where city_name like 'New%';
delete from city_popul where city_name like 'New%' limit 5;

create table big_table1 (select * from world.city, sakila.country);
create table big_table2 (select * from world.city, sakila.country);
create table big_table3 (select * from world.city, sakila.country);
select count(*) from big_table1;

delete from big_table1;
drop table big_table2;
truncate table big_table3;

use market_db;
set @myVar1 = 5;
set @myVar2 = 4.25;

select @myVar1;
select @myVar1 + @myVar2;

set @txt = '가수 이름==> ';
set @height = 166;
select @txt, mem_name from member where height > @height;

select cast('2022$12$12' as date);
select cast('2022/12/12' as date);
select cast('2022%12%12' as date);
select cast('2022@12@12' as date);

select num, concat(cast(price as char), 'X', cast(amount as char), '=') '가격X수량', price*amount, '구매액' from buy;

drop table if exists buy, member;
create table member(
	mem_id char(8) primary key,
    mem_name varchar(10) not null,
    height tinyint unsigned null
);
create table buy(
	num int auto_increment primary key,
    user_id char(8) not null,
    prod_name char(6) not null,
    foreign key(user_id) references member(mem_id)
);

select * from member;
select * from buy;

insert into member values('a','kim',155);
insert into buy values(null,'b','beer');
insert into buy values(null,'a','beer');

insert into member values('BLK','블랙핑크',163);
insert into buy values(null,'BLK','지갑');
insert into buy values(null,'BLK','맥북');

drop table if exists buy;
create table buy(
	num int auto_increment primary key,
    mem_id char(8) not null,
    prod_name char(6) not null
);
alter table buy add constraint foreign key(mem_id) references member(mem_id) on update cascade on delete cascade;

update member set mem_id = 'PINK' where mem_id='BLK';

select M.mem_id, M.mem_name, B.prod_name from buy B inner join member M on B.mem_id = M.mem_id;

