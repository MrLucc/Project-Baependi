CREATE TABLE tb_categoria(
	id_categoria BIGINT PRIMARY KEY AUTO_INCREMENT,
    artes VARCHAR(255),
    moda VARCHAR(255),
    casa VARCHAR(255)
);

CREATE TABLE tb_produto(
	id_produto BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255),
    preco FLOAT(5,2),
    descricao VARCHAR(255),
    produtor VARCHAR(255),
    fk_categoria BIGINT AUTO_INCREMENT,
	fk_usuario VARCHAR(255),
    FOREIGN KEY (fk_categoria) REFERENCES tb_categoria (id_categoria),
    FOREIGN KEY (fk_usuario) REFERENCES tb_usuario (cpf)
);

CREATE TABLE tb_usuario(
	cpf VARCHAR(255) PRIMARY KEY,
    nome_completo VARCHAR(255),
    email VARCHAR(255),
    senha VARCHAR(255)
);