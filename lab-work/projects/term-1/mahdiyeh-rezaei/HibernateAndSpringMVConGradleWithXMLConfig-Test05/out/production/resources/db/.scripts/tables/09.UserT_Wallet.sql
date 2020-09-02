begin
    execute immediate 'drop table UserT_Wallet';
    dbms_output.put_line('Table UserT_Wallet dropped');
exception
    when others then dbms_output.put_line('Table UserT_Wallet id not exist');
end;
/
begin
    execute immediate 'drop sequence UserT_Wallet';
    dbms_output.put_line('Sequence UserT_Wallet_sql dropped')
exception
    when others then dbms_output.put_line('Sequence UserT_Wallet_sql id not exist');
end
/
create table UserT_Wallet(
    user_id                  number(10)      not null,
    wallets_id   number(10)      not null
)

