<?php

    include('autoload.php');

    include('pag/header.php');

    // Usuario

    $usuario = (new Usuario())->utilizandoOID(1)
                              ->cadastradoComOLogin('123')
                              ->cadastradoComASenha('123')
                              ->comONome('123321321')
                              ->utilizandoOCpf('1212121');

    // Livros

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

    $listalivros = [$livro, $livro1, $livro2];


    $livro = (new Livro())->utilizandoOID(1)
    ->comONome('Joao')
    ->cadastradoComOISBN('123')
    ->naEdicao('sdzzzzzzzzzzzzzzzzzz')
    ->publicadoEm(date('Y-m-d'))
    ->criadoPeloAutor('12321');

    $livro1 = (new Livro())->utilizandoOID(2)
        ->comONome('sadasdas')
        ->cadastradoComOISBN('asdasdas')
        ->naEdicao('zzzzzzzzzzzzzzzzzzzzzz')
        ->publicadoEm(date('Y-m-d'))
        ->criadoPeloAutor('123213213');
    $livro2 = (new Livro())->utilizandoOID(3)
        ->comONome('sadasdas')
        ->cadastradoComOISBN('asdasdas')
        ->naEdicao('zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz')
        ->publicadoEm(date('Y-m-d'))
        ->criadoPeloAutor('321321321');

    $listalivros2 = [$livro, $livro1, $livro2]; 

    $emprestimo = (new Emprestimo())->utilizandoOID(1)
                          ->naADataDeEntrega(date('Y-m-d'))
                          ->naDataDeDevolucao(date('Y-m-d'))
                          ->cadastradoComOUsuario($usuario)
                          ->comAListaDeLivros($listalivros);

    $emprestimo1 = (new Emprestimo())->utilizandoOID(2)
                          ->naADataDeEntrega(date('Y-m-d'))
                          ->naDataDeDevolucao(date('Y-m-d'))
                          ->cadastradoComOUsuario($usuario)
                          ->comAListaDeLivros($listalivros);


    $emprestimo2 = (new Emprestimo())->utilizandoOID(3)
                          ->naADataDeEntrega(date('Y-m-d'))
                          ->naDataDeDevolucao(date('Y-m-d'))
                          ->cadastradoComOUsuario($usuario)
                          ->comAListaDeLivros($listalivros);

    $emprestimoDAO = new EmprestimoDAO();
    $emprestimoBO = new EmprestimoBO($emprestimoDAO);
    
    $emprestimoBO->inserir($emprestimo);
    $emprestimoBO->inserir($emprestimo1);
    $emprestimoBO->inserir($emprestimo2);

    echo 'ANTES <br>';              
    echo json_encode($emprestimoBO->listarEmprestimos());

    $emprestimo3 = (new Emprestimo())->utilizandoOID(3)
                          ->naADataDeEntrega(date('Y-m-d'))
                          ->naDataDeDevolucao(date('Y-m-d'))
                          ->cadastradoComOUsuario($usuario)
                          ->comAListaDeLivros($listalivros2);


    $emprestimoBO->alterar($emprestimo3);


    $emprestimo4 = (new Emprestimo())->utilizandoOID(1)
                          ->naADataDeEntrega(date('Y-m-d'))
                          ->naDataDeDevolucao(date('Y-m-d'))
                          ->cadastradoComOUsuario($usuario)
                          ->comAListaDeLivros($listalivros);
    
    $emprestimoBO->excluir($emprestimo4);

    echo '<br> <br> DEPOIS <br>';
    echo json_encode($emprestimoBO->listarEmprestimos());

    include('pag/footer.php');


?>