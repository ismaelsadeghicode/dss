begin
    execute immediate 'drop table UserT_Smsverification';
    dbms_output.put_line('Table UserT_Smsverification dropped');
exception
    when others then dbms_output.put_line('Table UserT_Smsverification id not exist');
end;
/
begin
    execute immediate 'drop sequence UserT_Smsverification';
    dbms_output.put_line('Sequence UserT_Smsverification_sql dropped')
exception
    when others then dbms_output.put_line('Sequence UserT_Smsverification_sql id not exist');
end
/
create table UserT_Smsverification(
    user_id                  number(10)      not null,
    usertype_id   number(10)      not null
)

