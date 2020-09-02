begin
    execute immediate 'drop table UserT_Bank';
    dbms_output.put_line('Table UserT_Bank dropped');
exception
    when others then dbms_output.put_line('Table UserT_Bank id not exist');
end;
/
begin
    execute immediate 'drop sequence UserT_Bank';
    dbms_output.put_line('Sequence UserT_Bank_sql dropped')
exception
    when others then dbms_output.put_line('Sequence UserT_Bank_sql id not exist');
end
/
create table UserT_Bank(
    user_id                  number(10)      not null,
    banks_id   number(10)      not null
)

