-- DDL 명령어 모음(오브젝트를 생성,수정,삭제,읽어옴)
drop database shop_db;
create database shop_db;
use shop_db;

drop table member;
create table member(
	member_id varchar(8) not null primary key,
    member_name char(5) not null,
    member_addr varchar(20) null
);

create table product(
	product_name char(4) primary key,
    cost int not null,
    make_date date,
    company char(5),
    amount int not null
);

-- DML 테이블의 내용을 생성,수정,삭제,읽기 
INSERT INTO `shop_db`.`member` (`member_id`, `member_name`, `member_addr`) VALUES ('tess', '나훈아', '경기 부천시 중동');
INSERT INTO `shop_db`.`member` (`member_id`, `member_name`, `member_addr`) VALUES ('hero', '임영웅', '서울 은평구 중산동');
INSERT INTO `shop_db`.`member` (`member_id`, `member_name`, `member_addr`) VALUES ('iyou', '아이유', '인천 남구 주안동');
INSERT INTO `shop_db`.`member` (`member_id`, `member_name`, `member_addr`) VALUES ('jyp', '박진영', '경기 고양시 장항동');

INSERT INTO `shop_db`.`product` (`product_name`, `cost`, `make_date`, `company`, `amount`) VALUES ('바나나', '1500', '2021-07-01', '델몬트', '17');
INSERT INTO `shop_db`.`product` (`product_name`, `cost`, `make_date`, `company`, `amount`) VALUES ('카스', '2500', '2022-03-01', 'OB', '3');
INSERT INTO `shop_db`.`product` (`product_name`, `cost`, `make_date`, `company`, `amount`) VALUES ('삼각김밥', '800', '2023-09-01', 'CJ', '22');

select * from member;
select member_id from member;
select member_id, member_name from member;
select member_id, member_name, member_addr from member;

select * from member where member_id='hero';
select * from member where member_name='아이유';

create index idx_member_name on member(member_name);

create view member_view as select member_id, member_name from member;
select * from member_view;