<?php

    include('autoload.php');

    include('header.php');

    $livro = (new Livro())->utilizandoOID(1)
                          ->comONome('Joao')
                          ->cadastradoComOISBN('123')
                          ->naEdicao('12321312')
                          ->publicadoEm(date('Y-m-d'))
                          ->criadoPeloAutor('Joao');

    echo $livro->toString();

    $lista_livros = [$livro];


    echo '<br>';

    $usuario = (new Usuario())->utilizandoOID(1)
                          ->comONome('Joao')
                          ->cadastradoComOLogin('123')
                          ->cadastradoComASenha('12321312')
                          ->utilizandoOCpf('121321321');

    echo $usuario->toString();

    
    echo '<br>';


    $emprestimo = (new Emprestimo())->utilizandoOID(1)
                          ->naADataDeEntrega(date('Y-m-d'))
                          ->naDataDeDevolucao(date('Y-m-d'))
                          ->cadastradoComOUsuario($usuario)
                          ->comAListaDeLivros($lista_livros);

    echo implode("", $emprestimo->getEmprestimoLivros()) . "<br>";
    
    


    include('footer.php');

?>