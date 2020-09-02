begin
    execute immediate 'drop table UsertypeT';
    dbms_output.put_line('Table UsertypeT dropped');
exception
    when others then dbms_output.put_line('Table UsertypeT id not exist');
end;
/
begin
    execute immediate 'drop sequence loginhistory_seq';
    dbms_output.put_line('Sequence UsertypeT_sql dropped')
exception
    when others then dbms_output.put_line('Sequence UsertypeT_sql id not exist');
end
/
create table UsertypeT(
    id              number(10)      not null,
    isactive          bit,
    name     varchar(255),
    constraint      UsertypeT_pk_id     primary key (id)
)

create sequence UsertypeT_sql
    minvalue 1 maxvalue 999999999999999999 cycle
    start with 1 increment by 1 cache 100;

/