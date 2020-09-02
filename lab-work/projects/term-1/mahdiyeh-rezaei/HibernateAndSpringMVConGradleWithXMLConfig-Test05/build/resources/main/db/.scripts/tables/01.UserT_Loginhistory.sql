begin
    execute immediate 'drop table usert_loginhistory';
    dbms_output.put_line('Table usert_loginhistory dropped');
exception
    when others then dbms_output.put_line('Table usert_loginhistory id not exist');
end;
/
begin
    execute immediate 'drop sequence usert_loginhistory';
    dbms_output.put_line('Sequence usert_loginhistory_sql dropped')
exception
    when others then dbms_output.put_line('Sequence usert_loginhistory_sql id not exist');
end
/
create table usert_loginhistory(
    usert_id                  number(10)      not null,
    loginhistories_id   number(10)      not null
)

