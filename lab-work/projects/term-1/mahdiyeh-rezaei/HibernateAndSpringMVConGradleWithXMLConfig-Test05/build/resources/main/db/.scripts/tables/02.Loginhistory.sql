begin
    execute immediate 'drop table loginhistory';
    dbms_output.put_line('Table loginhistory dropped');
exception
    when others then dbms_output.put_line('Table loginhistory id not exist');
end;
/
begin
    execute immediate 'drop sequence loginhistory_seq';
    dbms_output.put_line('Sequence loginhistory_sql dropped')
exception
    when others then dbms_output.put_line('Sequence loginhistory_sql id not exist');
end
/
create table loginhistory(
    id              number(10)      not null,
    browser          varchar(255),
    ip     varchar(255),
    login_time      timestamp,
    logout_time       timestamp,
    constraint      loginhistory_pk_id     primary key (id)
)

create sequence loginhistory_seq
    minvalue 1 maxvalue 999999999999999999 cycle
    start with 1 increment by 1 cache 100;

/