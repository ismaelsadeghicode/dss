begin
    execute immediate 'drop table Smsverification';
    dbms_output.put_line('Table Smsverification dropped');
exception
    when others then dbms_output.put_line('Table Smsverification id not exist');
end;
/
begin
    execute immediate 'drop sequence Smsverification_seq';
    dbms_output.put_line('Sequence Smsverification_seq dropped')
exception
    when others then dbms_output.put_line('Sequence Smsverification_seq id not exist');
end
/
create table Smsverification(
    id              number(10)      not null,
    code          varchar(255),
    end_time     timestamp,
    start_time     timestamp ,
    constraint      Smsverification_pk_id     primary key (id)
)

create sequence Smsverification_seq
    minvalue 1 maxvalue 999999999999999999 cycle
    start with 1 increment by 1 cache 100;

/