<?php

    include('autoload.php');

   // include('header.php');

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
    $livro2 = (new Livro())->utilizandoOID(2)
                          ->comONome('sadasdas')
                          ->cadastradoComOISBN('asdasdas')
                          ->naEdicao('1232dasdasd1312')
                          ->publicadoEm(date('Y-m-d'))
                          ->criadoPeloAutor('Joao');

    $listalivros[] = $livro;
    $listalivros[] = $livro1;
    $listalivros[] = $livro2;

    echo '<br>';

    $usuario = (new Usuario())->utilizandoOID(1)
                          ->comONome('Joao')
                          ->cadastradoComOLogin('123')
                          ->cadastradoComASenha('12321312')
                          ->utilizandoOCpf('121321321');

    echo $usuario->toString();

    
    echo '<br>';


    $lista_livros = [$livro, $livro1];
    $emprestimo = (new Emprestimo())->utilizandoOID(1)
                          ->naADataDeEntrega(date('Y-m-d'))
                          ->naDataDeDevolucao(date('Y-m-d'))
                          ->cadastradoComOUsuario($usuario)
                          ->comAListaDeLivros($listalivros);

    echo $emprestimo->toString();    


?>