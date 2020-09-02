begin
    execute immediate 'drop table bank';
    dbms_output.put_line('Table bank dropped');
exception
    when others then dbms_output.put_line('Table bank id not exist');
end;
/
begin
    execute immediate 'drop sequence bank_seq';
    dbms_output.put_line('Sequence bank_seq dropped')
exception
    when others then dbms_output.put_line('Sequence bank_seq id not exist');
end
/
create table bank(
    id              number(10)      not null,
    accountno          varchar(255),
    cardno     varchar(255),
    isactive     bit ,
    name         nvarchar(255),
    constraint      bank_pk_id     primary key (id)
)

create sequence bank_seq
    minvalue 1 maxvalue 999999999999999999 cycle
    start with 1 increment by 1 cache 100;

/