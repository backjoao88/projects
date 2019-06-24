<?php

    include('autoload.php');

    include('header.php');

    $bibliotecario = (new Bibliotecario())->utilizandoOID(1)
                              ->comONome('123321321')
                              ->utilizandoOCpf('1212121');

    $bibliotecario2 = (new Bibliotecario())->utilizandoOID(2)
                              ->comONome('fdsvdgfd')
                              ->utilizandoOCpf('mathias');

    $bibliotecario3 = (new Bibliotecario())->utilizandoOID(3)
                              ->comONome('2222222')
                              ->utilizandoOCpf('22222222222');


    $bibliotecarioDAO = new BibliotecarioDAO();
    $bibliotecarioBO = new BibliotecarioBO($bibliotecarioDAO);

    $bibliotecarioBO->inserir($bibliotecario);
    $bibliotecarioBO->inserir($bibliotecario2);
    $bibliotecarioBO->inserir($bibliotecario3);

    echo 'ANTES <br>';              
    echo json_encode($bibliotecarioBO->listarBibliotecarios());

    $bibliotecario4 = (new Bibliotecario())->utilizandoOID(2)
                               ->comONome('213131')
                               ->utilizandoOCpf('vitor');


    $bibliotecarioBO->alterar($bibliotecario4);

    $bibliotecario5 = (new Bibliotecario())->utilizandoOID(1)
                                ->comONome('213131')
                                ->utilizandoOCpf('vitor');


    $bibliotecarioBO->excluir($bibliotecario5);

    echo '<br> <br> DEPOIS <br>';
    echo json_encode($bibliotecarioBO->listarBibliotecarios());

    include('footer.php');


?>