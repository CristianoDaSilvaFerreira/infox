-- Criando o banco de dados
CREATE DATABASE db_infox;

-- Escolhendo o Banco de Dados
USE db_infox;

-- Criando a tabela de usuários
CREATE TABLE tb_usuarios (
	id_user int primary key auto_increment,
    usuario varchar(50) not null,
    fone varchar(15),
    login varchar(15) not null unique,
    senha varchar(15) not null
);

-- Descrever a tabela
DESCRIBE tb_usuarios;

-- CRUD - Create
INSERT INTO tb_usuarios(usuario, fone, login, senha)
VALUES ('Administrado', '2682-2688', 'admin', 'admin');

-- CRUD - Read
SELECT * FROM tb_usuarios;

INSERT INTO tb_usuarios(usuario, fone, login, senha)
VALUES ('Crisitano Ferreira', '98376-5945', 'cristiano', 'admin');
INSERT INTO tb_usuarios(usuario, fone, login, senha)
VALUES ('Aline Mothe', '99336-8054', 'aline', 'atentende');
INSERT INTO tb_usuarios(usuario, fone, login, senha)
VALUES ('Teste', '98888-7777', 'teste', 'teste');

-- CRUD - Update
UPDATE tb_usuarios SET fone='2682-2682' WHERE id_user=1;

-- CRUD - Delete
DELETE FROM tb_usuarios WHERE id_user=4;

-- Criando a tabela de Clientes
CREATE TABLE tb_clientes (
	id_cliente int primary key auto_increment,
    nome_cliente varchar(50) not null,
    endereco_cliente varchar(150),
    telefone_cliente varchar(50) not null,
    email_cliente varchar(50)
);

DESCRIBE tb_clientes;

INSERT INTO tb_clientes(nome_cliente, endereco_cliente, telefone_cliente, email_cliente)
VALUES('Linus Torvalds', 'Rua Tux, 2055', '2655-2652', 'linus@linus.com');

SELECT * FROM tb_clientes;

-- Criando a tabela da ordem de serviço
CREATE TABLE tb_ordem_servico(
	ordem int primary key auto_increment,
    data_OS timestamp default current_timestamp,
    equipamento varchar(150) not null,
    defeito varchar(150) not null,
    servico varchar(150),
    tecnico varchar(30),
    valor decimal(10,2),
    id_cliente int not null,
    foreign key(id_cliente) references tb_clientes(id_cliente)
);

INSERT INTO tb_ordem_servico(equipamento, defeito, servico, tecnico, valor,id_cliente)
VALUES ('Notbook', 'Não liga', 'Troca da Fonte', 'Cristiano', 87.50, 1);

SELECT * FROM tb_ordem_servico;

-- Trazendo a informação de mais de uma tabela
SELECT
	ORDEM.ordem, equipamento, defeito, servico, valor,
    CLIENTE.nome_cliente, telefone_cliente
FROM tb_ordem_servico AS ORDEM
INNER JOIN tb_clientes AS CLIENTE
ON (ORDEM.id_cliente = CLIENTE.id_cliente);

SELECT * FROM tb_usuarios;

-- Adicionando o campo perfil ao usuário
ALTER TABLE tb_usuarios ADD COLUMN perfil VARCHAR(20) NOT NULL;

UPDATE tb_usuarios SET perfil='admin' WHERE id_user=1;
UPDATE tb_usuarios SET perfil='admin' WHERE id_user=2;
UPDATE tb_usuarios SET perfil='user' WHERE id_user=3;

DESCRIBE tb_usuarios;
