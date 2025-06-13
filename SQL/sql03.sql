use market_db;
drop procedure if exists user_proc1;
delimiter $$
create procedure user_proc1(
	in userName varchar(10)
)
begin
	select * from member where mem_name = userName;
end $$
delimiter ;

call user_proc1('에이핑크');

set global log_bin_trust_function_creators = 1;

drop function if exists calcYearFunc;
delimiter $$
create function calmemberYearFunc(dYear int)
	returns int
begin
	declare runYear int;
    set runYear = year(curdate()) - dYear;
    return runYear;
end $$
delimiter ;

select calYearFunc(2010) as '활동 햇수';

select calYearFunc(2007) into @debut2007;
select calYearFunc(2013) into @debut2013;
select @debut2007-@debut2013 as '2007과 2013 차이';

select mem_id, mem_name, calYearFunc(year(debut_date)) as '활동 햇수' from member;

DELIMITER $$

CREATE PROCEDURE cursor_proc()
BEGIN
    DECLARE memNumber INT;
    DECLARE cnt INT DEFAULT 0;
    DECLARE totNumber INT DEFAULT 0;
    DECLARE endOfRow BOOLEAN DEFAULT FALSE;
    
    DECLARE memberCursor CURSOR FOR
        SELECT mem_number FROM member;
    
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET endOfRow = TRUE;
    
    OPEN memberCursor;
    
    cursor_loop: LOOP
        FETCH memberCursor INTO memNumber;
        
        IF endOfRow THEN
            LEAVE cursor_loop;
        END IF;
        
        SET cnt = cnt + 1;
        SET totNumber = totNumber + memNumber;
    END LOOP cursor_loop;
    
    SELECT (totNumber / cnt) AS '회원의 평균 인원 수';
    
    CLOSE memberCursor;
END $$

DELIMITER ;


select mem_number from member;

create table if not exists trigger_table (id int, txt varchar(10));
insert into trigger_table values(1, '레드벨벳');
insert into trigger_table values(2, '잇지');
insert into trigger_table values(3, '블랙핑크');

delimiter $$
create trigger myTrigger
	after delete
    on trigger_table
    for each row
begin
	set @msg = '가수 그룹이 삭제됨' ;
end $$
delimiter ;

set @msg = '';
insert into trigger_table values(4, '마마무');
select @msg;
update trigger_table set txt = '블핑' where id = 3;
select @msg;

delete from trigger_table where id = 4;
select @msg;

create table singer (select mem_id, mem_name, mem_number, addr from member);

create table backup_singer(
	mem_id char(8) not null,
    mem_name varchar(10) not null,
    mem_number int not null,
    addr char(2) not null,
    modType char(2),
    modDate date,
    modUser varchar(30)
);

delimiter $$
create trigger singer_updateTrg
	after update
	on singer
    for each row
begin
	insert into backup_singer values(OLD.mem_id, OLD.mem_name, OLD.mem_number, OLD.addr, '수정', curdate(), current_user());
end $$
delimiter ;

delimiter $$
create trigger singer_deleteTrg
	after delete
	on singer
    for each row
begin
	insert into backup_singer values(OLD.mem_id, OLD.mem_name, OLD.mem_number, OLD.addr, '삭제', curdate(), current_user());
end $$
delimiter ;

update singer set addr = '영국' where mem_id = 'BLK';
delete from singer where mem_number >= 7;

select * from backup_singer;