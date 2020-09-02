begin
    execute immediate 'drop table usert';
    dbms_output.put_line('Table usert dropped');
exception
    when others then dbms_output.put_line('Table usert id not exist');
end;
/
begin
    execute immediate 'drop sequence usert_seq';
    dbms_output.put_line('Sequence usert_sql dropped')
exception
    when others then dbms_output.put_line('Sequence usert_sql id not exist');
end
/
create table usert(
    id              numeric(10)      not null,
    avatar          varchar(255),
    creation_at     timestamp,
    first_name      varchar(50),
    isactive        bit,
    isdeleted       bit             default 0,
    last_name       varchar(50),
    national_code   varchar(10),
    password        varchar(16)     not null,
    phone_number    varchar(11),
    username        varchar(255)    not null,
    email           varchar(320),
    constraint      usert_pk_id     primary key (id)
)

create sequence usert_seq
    minvalue 1 maxvalue 999999999999999999 cycle
    start with 1 increment by 1 cache 100;

/