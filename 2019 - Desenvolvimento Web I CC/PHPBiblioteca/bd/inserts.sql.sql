use bib;

INSERT INTO LIVRO(livro_nome, livro_isbn, livro_edicao, livro_data_publicacao, livro_autor) VALUES
('A Batalha do Apocalipse', '1321321321', '1', NOW(), 'Eduardo Spohr'),
('Pegasus e o Fogo do Olimpo', '42323432', '1', NOW(), 'Kate O\'Hearn'),
('Pegasus e a Batalha pelo Olimpo', '5435345', '1', NOW(), 'Kate O\'Hearn');

INSERT INTO BIBLIOTECARIO(bibliotecario_nome, bibliotecario_cpf, bibliotecario_login, bibliotecario_senha) VALUES
('Lucas da Silva', '123213312321', 'lucas', '123'),
('Vitor da Silva', '123213312321', 'vitor', '123'),
('44 da Silva', '44', '342423', '123');


INSERT INTO EMPRESTIMO(emprestimo_data_entrega, emprestimo_data_devolucao, emprestimo_bibliotecario_id) VALUES
(NOW(), NOW(), 1),
(NOW(), NOW(), 2),
(NOW(), NOW(), 3);

INSERT INTO LIVRO_EMPRESTIMO(livro_emprestimo_livro_id, livro_emprestimo_emprestimo_id) VALUES
(1,1),
(1,2),
(2,3);





