--liquibase formatted sql

--changeset ildan:create_table_goods
create table goods
(
    id serial primary key not null,
    name       varchar(100)  not null unique,
    description  varchar(250),
    price float not null
);

-- rollback drop table goods;