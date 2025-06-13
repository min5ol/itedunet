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