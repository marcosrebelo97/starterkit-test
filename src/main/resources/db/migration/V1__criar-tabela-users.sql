create table tb_users (
    id bigserial not null,
    name varchar(50),
    age integer,
    email varchar(50) unique,
    city varchar(50),
    cep integer,
    primary key (id)
);