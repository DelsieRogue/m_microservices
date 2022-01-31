--liquibase formatted sql

--changeset ildan:add_products_in_goods_table
insert into goods (name, description, price)
values ('Notebook', 'Macbook', 150000),
       ('PC mouse', 'Magic Mouse', 10000),
       ('Headphones', 'AirPods', 15000),
       ('Phone', 'IPhone1000', 70000);

-- rollback delete from goods where name='Notebook' or name='PC mouse' or name='Headphones' or name='Phone'