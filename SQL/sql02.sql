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

use market_db;

-- join
select buy.mem_id 'buy.mem_id', mem_name, prod_name, addr, concat(phone1, phone2) '연락처' from buy
   inner join member
    on buy.mem_id = member.mem_id;
    
select buy.mem_id, member.mem_name, buy.prod_name, member.addr, concat(member.phone1, "-", member.phone2) '연락처' from buy
   inner join member
   on buy.mem_id = member.mem_id;

select B.mem_id, M.mem_name, B.prod_name, M.addr, concat(M.phone1, "-", M.phone2) '연락처' from buy B
   inner join member M
   on B.mem_id = M.mem_id
    ORDER by mem_id;

select M.mem_id, M.mem_name, B.prod_name, M.addr from member M
   left outer join buy B
    on M.mem_id = B.mem_id
    order by M.mem_id;
    
-- -----------------------------------
use market_db;
create table student (
    id char(10) primary key,
    name char(10) 
);
insert student values("1","철수");
insert student values("2","영희");
insert student values("3","민수");

create table score (
    id char(10) ,
    point int
);
insert score values("1",50);
insert score values("2",80);
insert score values("4",99);
select * from student;
select * from score;

select student.id ,student.name ,score.point from student
  inner join score
  on student.id = score.id;
-- 양쪽에 다 존재해야 출력이된다.

-- -----------------------------------
create table student (
    id char(10) primary key,
    name char(10) 
);
insert student values("1","철수");
insert student values("2","영희");
insert student values("3","민수");

create table score (
    id char(10) ,
    point int
);
insert score values("1",50);
insert score values("2",80);
insert score values("4",99);
select * from student;
select * from score;

select * from student
  inner join score
  on student.id = score.id;
-- 양쪽에 다 존재해야 출력이된다.

select * from student
    left outer join score
    on student.id = score.id;
--  student의(왼쪽) 목록은 모두 출력되어야 한다

select * from student
    right outer join score
    on student.id = score.id;
-- score의(오른쪽) 테이블 목록은 모두 출력되어야 한다.

-- ----------------------------
create table emp_table(
   emp char(4),
    manager char(4),
    phone varchar(8)
);

insert into emp_table values("대표", NULL, '0000');
insert into emp_table values("영업이사", "대표", '1111');
insert into emp_table values("관리이사", "대표", '2222');
insert into emp_table values("정보이사", "대표", '3333');
insert into emp_table values("영업과장", "영업이사", '1111-1');
insert into emp_table values("경리부장", "관리이사", '2222-1');
insert into emp_table values("인사부장", "관리이사", '2222-2');
insert into emp_table values("개발팀장", "정보이사", '3333-1');
insert into emp_table values("개발주임", "정보이사", '3333-1-1');

select * from emp_table;

select A.emp '직원', B.emp '직속상관', B.phone '직속상관연락처' from emp_table A
   inner join emp_table B
    on A.manager = B.emp
   where A.emp = "경리부장";

-- procedure
drop procedure if exists ifProc3;
delimiter $$
create procedure ifProc3()
begin
   declare debutDate Date;   -- 데뷔일
    declare curDate Date;   -- 오늘
    declare days int;   -- 활동기간(일)
      
    select debut_date into debutDate
      from market_db.member
      where mem_id="APN";
            
   set curDate = current_date();
    set days = datediff(curDate, debutDate);
        
    if((days/365) >= 5) then
      select concat("데뷔한 지 ", days, "일 지났습니다. 핑순이들 ㅊㅋ");
   else
      select concat("데뷔한 지 ", days, "일 지났습니다. 핑순이들 ㅍㅇㅌ");
   end if;
end $$
delimiter ;   -- ; 전에 띄어쓰기 필수

call ifProc3();   

select B.mem_id, M.mem_name, sum(price*amount) "총구매액" 
   from buy B
    inner join member M
    on B.mem_id = M.mem_id
    group by B.mem_id
    order by sum(price*amount) desc;

select M.mem_id, M.mem_name, sum(price*amount) "총구매액",
   case
      when (sum(price*amount) >= 1500) then "최우수고객"
      when (sum(price*amount) >= 1000) then "우수고객"
      when (sum(price*amount) >= 1) then "일반고객"
      else "유령고객"
   end "고객 분류"
    
from buy B
	right outer join member M
    on B.mem_id = M.mem_id
    group by M.mem_id
    order by sum(price*amount) desc;
    
drop procedure if exists whileProc;
delimiter $$
create procedure whileProc()
begin
	declare i int;
    declare hap int;
    set i = 1;
    set hap = 0;
    
    while(i<=100) do
		set hap = hap + i;
        set i = i + 1;
	end while;
	select '1부터 100까지의 합 ==>', hap;
end $$
delimiter ;
call whileProc();

drop procedure if exists whileProc2;
delimiter $$
create procedure whileProc2()
begin
	declare i int;
    declare hap int;
    set i = 1;
    set hap = 0;
    
    myWhile:
    while(1 <= 100) do
		if(i%4 = 0) then
			set i = i + 1;
            iterate myWhile;
		end if;
        set hap = hap + i;
        if (hap > 1000) then
         leave myWhile;
		end if;
        set i = i + 1;
	end while;
    
    select '1부터 100까지의 합(4의 배수 제외), 1000 넘으면 종료 ==>', hap;
end $$
delimiter ;
call whileProc2();

use market_db;
prepare myQuery from 'select * from member where mem_id = "BLK"';
execute myQuery;
deallocate prepare myQuery;

create table gate_table (
id int auto_increment primary key, 
entry_time datetime
);

set @curDate = current_timestamp();

prepare myQuery from 'insert into gate_table values(null,?)';
execute myQuery using @curDate;
deallocate prepare myQuery;

select * from gate_table;

use market_db;
create view v_member
as
	select mem_id, mem_name, addr from member;
select * from v_member;

create view v_memberbuy
as
	select B.mem_id, M.mem_name, B.prod_name, M.addr,
					concat(M.phone1, M.phone2) '연락처'
		from buy B
			inner join member M
            on B.mem_id = M.mem_id;
            
select * from v_memberbuy;

update v_member set addr = '부산' where mem_id='BLK';
insert into v_member(mem_id, mem_name, addr) values('BTS','방탄소년단','경기');

create view v_height167
as
	select * from member where height >= 167;
select * from v_height167;