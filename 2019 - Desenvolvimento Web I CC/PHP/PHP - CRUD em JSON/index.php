<?php

    include('autoload.php');

    include('header.php');


    $usuario = (new Usuario())->utilizandoOID(1)
                              ->cadastradoComOLogin('123')
                              ->cadastradoComASenha('123')
                              ->comONome('123321321')
                              ->utilizandoOCpf('1212121');

    $usuarioDAO = new UsuarioDAO();
    
    $usuarioBO = new UsuarioBO($usuarioDAO);
    $usuario2 = (new Usuario())->utilizandoOID(1)
                              ->cadastradoComOLogin('21321321321')
                              ->cadastradoComASenha('12312321')
                              ->comONome('123213')
                              ->utilizandoOCpf('12321321321312321312');

    
                              
    $usuarioBO->alterar($usuario2);



    include('footer.php');


?>