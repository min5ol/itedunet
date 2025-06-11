use world;

select count(*) from city;
select * from city limit 5;

create table city_popul(
	city_name char(35),
    population int
);

insert into city_popul select Name, Population from city; -- 다른 테이블의 데이터를 한번에 입력하는 구문