use bib;

INSERT INTO LIVRO(livro_nome, livro_isbn, livro_edicao, livro_data_publicacao, livro_autor) VALUES
('A Batalha do Apocalipse', '978-2-12-345680-3', '1','2012-04-01' , 'Eduardo Spohr'),
('Pegasus e o Fogo do Olimpo', '912-2-13-567432-0', '1', '2012-04-06' , 'Kate O\'Hearn'),
('Pegasus e a Batalha pelo Olimpo', '563-9-22-894743-5', '2', '2012-04-22' , 'Kate O\'Hearn'),
('Pegasus e as Origens do Olimpo', '654-9-22-789631-4', '3', '2012-04-24' , 'Kate O\'Hearn');

INSERT INTO BIBLIOTECARIO(bibliotecario_nome, bibliotecario_cpf, bibliotecario_login, bibliotecario_senha, bibliotecario_email) VALUES
('Pedro Erick Nicolas Dias', '171.224.293-85', 'pedro', sha1('123'), 'joaoback47@gmail.com'),
('Luzia Marcela Martins', '700.106.748-29', 'luzia', sha1('123'), 'joaoback47@gmail.com'),
('Antonio Nathan Jesus', '211.704.977-05', 'antonio', sha1('123'), 'joaoback47@gmail.com'),
('Miguel Bryan dos Santos', '189.647.320-22', 'miguel', sha1('123'), 'joaoback47@gmail.com'),
('Patricia Almeida dos Santos', '222.654.232-11', 'patricia', sha1('123'), 'joaoback47@gmail.com'),
('Heloise Julia Clarice Farias', '069.083.126-90', 'heloise', sha1('123'), 'joaoback47@gmail.com');


INSERT INTO EMPRESTIMO(emprestimo_data_entrega, emprestimo_data_devolucao, emprestimo_bibliotecario_id) VALUES
('2019-11-22', '2019-12-06', 1),
('2019-04-20', '2019-06-21', 4),
('2019-07-04', '2019-07-29', 3);

INSERT INTO LIVRO_EMPRESTIMO(livro_emprestimo_livro_id, livro_emprestimo_emprestimo_id) VALUES
(1,1),
(1,2),
(2,3);





