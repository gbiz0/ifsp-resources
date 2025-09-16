-- create database dw3;
create table if not exists cursos (
    cursoid bigserial constraint pk_cursos primary key,
    codigo varchar(50) unique,
    descricao varchar(60),
    ativo boolean,
    deleted boolean default false
);

insert into cursos values
    (default, 'BSI', 'Bacharelado em Sistemas de Informação', true),
    (default, 'DIREITO', 'Bacharelado em Direito', true),
    (default, 'LETRAS', 'Licenciatura em Letras', true),
    (default, 'ADM', 'Bacharelado em Administração', false)
on conflict do nothing;


create table if not exists alunos (
    alunoid bigserial constraint pk_alunos primary key,
    prontuario varchar(10) unique,
    nome varchar(50),
    endereco varchar(60),
    rendafamiliar numeric(8,2),
    datanascimento date,
    cursoid bigint constraint fk_aluno_curso references cursos,
    deleted boolean default false
);

insert into alunos values
    (default, 'pront1', 'José das Neves', 'Rua A, Votuporanga', 6891.60, '2000-01-31',
        (select cursoid from cursos where codigo = 'BSI')),
    (default, 'pront2', 'Maria Silveira', 'Rua B, São José do Rio Preto', 7372.41, '2002-03-12',
        (select cursoid from cursos where codigo = 'DIREITO'))
on conflict do nothing;


create table if not exists usuarios (
    usuarioid bigserial constraint pk_usuarios primary key,
    username varchar(10) unique,
    password text,
    deleted boolean default false
);

create extension if not exists pgcrypto;

insert into usuarios values
    (default, 'admin', crypt('admin', gen_salt('bf'))), -- senha criptografada com bcrypt
    (default, 'qwe', crypt('qwe', gen_salt('bf')))     -- senha criptografada com bcrypt
on conflict do nothing;


create table if not exists clientes (
    clienteid bigserial constraint pk_clientes primary key,
    codigo varchar(50) unique,
    nome varchar(60),
    endereco varchar(50),
    ativo boolean,
    deleted boolean default false
);

insert into clientes values
    (default, 'CLI01', 'João da Silva', 'Rua A1', true),
    (default, 'CLI02', 'Marcia Almeida', 'Rua B2', true)
on conflict do nothing;


create table if not exists pedidos (
    pedidoid bigserial constraint pk_pedidos primary key,
    numero bigint unique,
    data date,
    valortotal numeric(9,2),
    clienteid bigint constraint fk_pedido_cliente references clientes,
    deleted boolean default false
);

insert into pedidos values
    (default, 234, '2020-01-31', 6891.60, (select clienteid from clientes where codigo = 'CLI01'))
on conflict do nothing;
