-- ta inja faghat in jadval estefade shode (postgresql)
create table person
(
    id       integer not null
        constraint person_pkey
            primary key,
    password varchar(255),
    username varchar(255)
        constraint uk_mjvhigut8lgjs8a6c1df6qt5u
            unique
);

alter table person
    owner to fqx