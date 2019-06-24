
USE VENDASIMPLES;

INSERT INTO MARCA(descricao) VALUES
('Samsung'),
('Agrale'),
('LG'),
('Xiaomi'),
('Apple'),
('Microsoft');

INSERT INTO PRODUTO(descricao, valor, estoque, codigodebarra, imagem, marca_idmarca) VALUES
('Shampoo', 50.00, 50, 'asoijdaisouhdasiuoh', 'asoijdaisouhdasiuoh', 1),
('Martelo', 50.00, 50, 'asoijdaisouhdasiuoh', 'asoijdaisouhdasiuoh', 2),
('CD', 50.00, 50, 'asoijdaisouhdasiuoh','asoijdaisouhdasiuoh', 2),
('Bola de Volei', 50.00, 50, 'asoijdaisouhdasiuoh','asoijdaisouhdasiuoh', 1),
('Bola de Futebol', 50.00, 50,'asoijdaisouhdasiuoh', 'asoijdaisouhdasiuoh', 2),
('Chaveiro', 50.00, 50, 'asoijdaisouhdasiuoh','asoijdaisouhdasiuoh', 3),
('Carrinho de Controle Remoto', 50.00, 50, 'asoijdaisouhdasiuoh','asoijdaisouhdasiuoh', 4);

INSERT INTO CLIENTE (nome, cpf, rg, fone, email, usuario, senha, endereco, numero, bairro, cidade, estado) VALUES

('João Back', '1232141231', '123131', '1231321', 'sadoijsao@gmail.com', 'usu123', '123', '1231321', 80, '1232131', '1231', 'SC'),
('Rodrigo da Silva', '1232141231', '123131', '1231321', 'sadoijsao@gmail.com', 'usu123', '123', '1231321', 80, '1232131', '1231', 'SC'),
('Mathias Schulz', '1232141231', '123131', '1231321', 'sadoijsao@gmail.com', 'usu123', '123', '1231321', 80, '1232131', '1231', 'SC'),
('Gabriel Lima', '1232141231', '123131', '1231321', 'sadoijsao@gmail.com', 'usu123', '123', '1231321', 80, '1232131', '1231', 'SC'),
('Caio Pereira', '1232141231', '123131', '1231321', 'sadoijsao@gmail.com', 'usu123', '123', '1231321', 80, '1232131', '1231', 'SC'),
('Fernando Moraes', '1232141231', '123131', '1231321', 'sadoijsao@gmail.com', 'usu123', '123', '1231321', 80, '1232131', '1231', 'SC');

INSERT INTO VENDEDOR(nome,usuario,senha) VALUES
('Pedregulho Maneco', '12321312', '1232131'),
('Zé Cachaça', '12321312', '1232131'),
('Isso é um teste', '12321312', '1232131');

INSERT INTO VENDA(data, dataVencimento, dataPagamento, cliente_idcliente, vendedor_idvendedor) VALUES
('29/10/2011', '29/10/2011', '29/10/2011', 1, 2),
('29/11/2011', '29/11/2011', '29/12/2011', 4, 1),
('23/10/2011', '23/10/2011', '23/10/2011', 2, 1),
('13/10/2011', '13/10/2011', '13/10/2011', 6, 2),
('12/10/2011', '12/10/2011', '12/10/2011', 5, 3);

INSERT INTO PRODUTO_HAS_VENDA(produto_idproduto, venda_idvenda, quantidadeProduto) VALUES
(2, 3, 250),
(1, 1, 100),
(5, 4, 150),
(4, 3, 50),
(3, 2, 500);





