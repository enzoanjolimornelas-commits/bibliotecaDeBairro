/*
    Exercício 2 - Modelagem e Dados SQL (PostgreSQL)
*/

CREATE TABLE item (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    codigo VARCHAR(30) NOT NULL UNIQUE,
    titulo VARCHAR(120) NOT NULL,
    tipo VARCHAR(20) NOT NULL,
    autor VARCHAR(80),
    edicao VARCHAR(40),
    disponivel BOOLEAN NOT NULL DEFAULT TRUE,

    CONSTRAINT chk_item_tipo
        CHECK (tipo IN ('livro', 'revista', 'LIVRO', 'REVISTA', 'DVD', 'dvd'))
);

CREATE TABLE usuario (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    tipo VARCHAR(20) NOT NULL,
    limite_itens INTEGER NOT NULL,

    CONSTRAINT chk_usuario_tipo
        CHECK (tipo IN ('aluno', 'professor', 'ALUNO', 'PROFESSOR'))
);

CREATE TABLE emprestimo (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    item_id BIGINT NOT NULL,
    usuario_id BIGINT NOT NULL,
    data_retirada DATE NOT NULL,
    data_devolucao_prevista DATE NOT NULL,
    data_devolucao DATE,
    valor_multa NUMERIC(10, 2) NOT NULL DEFAULT 0.00,

    CONSTRAINT fk_emprestimo_item
        FOREIGN KEY (item_id) REFERENCES item(id)
        ON DELETE RESTRICT,
    CONSTRAINT fk_emprestimo_usuario
        FOREIGN KEY (usuario_id) REFERENCES usuario(id)
        ON DELETE RESTRICT
);
