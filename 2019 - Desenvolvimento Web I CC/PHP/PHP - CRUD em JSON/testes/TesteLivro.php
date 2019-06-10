<?php
    include('autoload.php');
    include('header.php');
    $livro = (new Livro())->utilizandoOID(1)
                          ->comONome('Joao')
                          ->cadastradoComOISBN('123')
                          ->naEdicao('12321312')
                          ->publicadoEm(date('Y-m-d'))
                          ->criadoPeloAutor('Joao');
    $livro1 = (new Livro())->utilizandoOID(2)
                          ->comONome('sadasdas')
                          ->cadastradoComOISBN('asdasdas')
                          ->naEdicao('1232dasdasd1312')
                          ->publicadoEm(date('Y-m-d'))
                          ->criadoPeloAutor('Joao');
    $livro2 = (new Livro())->utilizandoOID(3)
                          ->comONome('sadasdas')
                          ->cadastradoComOISBN('asdasdas')
                          ->naEdicao('1232dasdasd1312')
                          ->publicadoEm(date('Y-m-d'))
                          ->criadoPeloAutor('Joao');
    $livroDAO = new LivroDAO();
    $livroBO = new LivroBO($livroDAO);
    $livroBO->inserir($livro);
    $livroBO->inserir($livro1);
    $livroBO->inserir($livro2);
    echo 'ANTES <br>';              
    echo json_encode($livroBO->listarLivros());
    $livro3 = (new Livro())->utilizandoOID(2)
                          ->comONome('5676576575')
                          ->cadastradoComOISBN('23432432423')
                          ->naEdicao('34543543654')
                          ->publicadoEm(date('Y-m-d'))
                          ->criadoPeloAutor('3243265867987987');
    $livroBO->alterar($livro3);
    $livro4 = (new Livro())->utilizandoOID(1)
                          ->comONome('5676576575')
                          ->cadastradoComOISBN('23432432423')
                          ->naEdicao('34543543654')
                          ->publicadoEm(date('Y-m-d'))
                          ->criadoPeloAutor('3243265867987987');
    
    $livroBO->excluir($livro4);
    echo '<br> <br> DEPOIS <br>';
    echo json_encode($livroBO->listarLivros());
    include('footer.php');
?>