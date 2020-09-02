begin
    execute immediate 'drop table usert_usertypet';
    dbms_output.put_line('Table usert_usertypet dropped');
exception
    when others then dbms_output.put_line('Table usert_usertypet id not exist');
end;
/
begin
    execute immediate 'drop sequence usert_loginhistory';
    dbms_output.put_line('Sequence usert_usertypet_sql dropped')
exception
    when others then dbms_output.put_line('Sequence usert_usertypet_sql id not exist');
end
/
create table usert_usertypet(
    usert_id                  number(10)      not null,
    usertype_id   number(10)      not null
)

