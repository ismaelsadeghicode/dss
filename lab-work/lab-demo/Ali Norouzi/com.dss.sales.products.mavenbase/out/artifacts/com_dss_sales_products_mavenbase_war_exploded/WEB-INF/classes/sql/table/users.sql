begin
execute immediately 'drop table USER_T';
dbms_output.put_line('USER_T table has been dropped');
exception
        when others then dbms_output.put_line('USER_T table does not exist!');
end
    /
begin
execute immediately 'drop sequence user_t_seq'
    dbms_output.put_line('user_t_seq dropped');
exception
        when others then dbms_output.put_line('user_t_seq does not exist');
end
    /
create table USER_T
(
    username     varchar not null,
    password     varchar not null,
    id           int,
    phone_number varchar,
    wallet       int,
    male         boolean     null,
    female       boolean     null,
    constraint USER_T_id_pk primary key (id)
);
create sequence user_t_seq
    minvalue 10000 maxvalue 9999999999999 cycle
    start with 10000 increment by 1000 cache;
/