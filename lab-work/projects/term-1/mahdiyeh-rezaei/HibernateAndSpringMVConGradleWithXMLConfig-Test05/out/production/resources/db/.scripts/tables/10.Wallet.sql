begin
    execute immediate 'drop table wallet';
    dbms_output.put_line('Table wallet dropped');
exception
    when others then dbms_output.put_line('Table wallet id not exist');
end;
/
begin
    execute immediate 'drop sequence wallet_seq';
    dbms_output.put_line('Sequence wallet_seq dropped')
exception
    when others then dbms_output.put_line('Sequence wallet_seq id not exist');
end
/
create table wallet(
    id              number(10)      not null,
    collor          varchar(255),
    wallet_name     varchar(255),
    constraint      wallet_pk_id     primary key (id)
)

create sequence wallet_seq
    minvalue 1 maxvalue 999999999999999999 cycle
    start with 1 increment by 1 cache 100;

/