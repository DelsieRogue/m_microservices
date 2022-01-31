--liquibase formatted sql

--changeset ildan:create_table_users
create table users
(
    id serial primary key not null,
    email       varchar(50)  not null unique,
    first_name  varchar(50)  not null,
    last_name   varchar(70)  not null,
    password    varchar(255) not null,
    role        varchar(30)  default 'USER' not null,
    status      varchar(30) default 'ACTIVE' not null
);

-- rollback drop table users;