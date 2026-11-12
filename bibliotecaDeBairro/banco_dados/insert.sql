INSERT INTO item (codigo, titulo, tipo, autor, edicao, disponivel) VALUES
('LIV-101', 'Dom Casmurro', 'livro', 'Machado de Assis', '1a Edicao', TRUE),
('LIV-102', 'Arquitetura Limpa', 'livro', 'Robert C. Martin', '1a Edicao', FALSE),
('LIV-103', 'Entendendo Algoritmos', 'livro', 'Aditya Y. Bhargava', '2a Edicao', TRUE),
('REV-201', 'Superinteressante', 'revista', 'Editora Abril', 'Edicao 450', TRUE),
('REV-202', 'National Geographic Brasil', 'revista', 'National Geographic', 'Edicao 260', TRUE);

--Alunos e Professor
INSERT INTO usuario (nome, tipo, limite_itens) VALUES
('Enzo Gabriel Oliveira', 'aluno', 3),
('Camila Ferreira Santos', 'aluno', 3),
('Marcos Vinicius Almeida', 'professor', 5);

INSERT INTO emprestimo (item_id, usuario_id, data_retirada, data_devolucao_prevista, data_devolucao, valor_multa) VALUES

(1, 1, '2026-09-01', '2026-09-15', '2026-09-20', 2.50),
(2, 3, '2026-10-05', '2026-10-19', NULL, 0.00),
(4, 1, '2026-10-01', '2026-10-08', '2026-10-12', 4.00);
