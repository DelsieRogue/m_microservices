--liquibase formatted sql

--changeset ildan:add_users_in_users_table
insert into users (email, first_name, last_name, password, role, status)
values ('admin@mail.ru', 'admin', 'adminov', '$2a$12$l20gytc8WUSsprr.lIb9PesOFpU8/lj.tkdEHhmgPZnMFGqlTgrZa', 'ADMIN', 'ACTIVE'),
       ('user@mail.ru', 'user', 'userov', '$2a$12$afl.c0.qb6l9kwVcq0m2eeDT5fl3nNzynSXcz4FQY2m9xqQxWcxgq', 'USER', 'ACTIVE');

-- rollback delete from users where email='admin@mail.ru' or email='user@mail.ru'