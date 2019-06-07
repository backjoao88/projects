<?php

    include('autoload.php');

    include('pag/header.php');

    $usuario = (new Usuario())->utilizandoOID(1)
                              ->cadastradoComOLogin('123')
                              ->cadastradoComASenha('123')
                              ->comONome('123321321')
                              ->utilizandoOCpf('1212121');

    $usuario2 = (new Usuario())->utilizandoOID(2)
                              ->cadastradoComOLogin('sdfdsf')
                              ->cadastradoComASenha('df')
                              ->comONome('fdsvdgfd')
                              ->utilizandoOCpf('mathias');

    $usuario3 = (new Usuario())->utilizandoOID(3)
                              ->cadastradoComOLogin('22222')
                              ->cadastradoComASenha('d22222222f')
                              ->comONome('2222222')
                              ->utilizandoOCpf('22222222222');


    $usuarioDAO = new UsuarioDAO();
    $usuarioBO = new UsuarioBO($usuarioDAO);

    $usuarioBO->inserir($usuario);
    $usuarioBO->inserir($usuario2);
    $usuarioBO->inserir($usuario3);

    echo 'ANTES <br>';              
    echo json_encode($usuarioBO->listarUsuarios());

    $usuario4 = (new Usuario())->utilizandoOID(2)
                               ->cadastradoComOLogin('21313')
                               ->cadastradoComASenha('df')
                               ->comONome('213131')
                               ->utilizandoOCpf('vitor');


    $usuarioBO->alterar($usuario4);

    $usuario5 = (new Usuario())->utilizandoOID(1)
                                ->cadastradoComOLogin('21313')
                                ->cadastradoComASenha('df')
                                ->comONome('213131')
                                ->utilizandoOCpf('vitor');


    $usuarioBO->excluir($usuario5);

    echo '<br> <br> DEPOIS <br>';
    echo json_encode($usuarioBO->listarUsuarios());

    include('pag/footer.php');


?>