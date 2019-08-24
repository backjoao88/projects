<?php

    session_start();
  

    include('autoload.php');


    $login = isset($_POST['login']) ? $_POST['login'] : '';
    $senha = isset($_POST['senha']) ? $_POST['senha'] : '';

    if(!$login && !$senha){
        header('Location: index.php');
        exit();
    }

    $pdo        = Conexao::conectar();
    $sql        = "SELECT * FROM BIBLIOTECARIO WHERE bibliotecario_login = :bibliotecario_login AND bibliotecario_senha = :bibliotecario_senha";

    $stmt = $pdo->prepare($sql);

    $stmt->bindParam(':bibliotecario_login', $bibliotecario_login, PDO::PARAM_STR);
    $stmt->bindParam(':bibliotecario_senha', $bibliotecario_senha, PDO::PARAM_STR);

    $bibliotecario_login     = $login;
    $bibliotecario_senha     = sha1($senha);

    $stmt->execute();
    
    $bibliotecarioAss = $stmt->fetch(PDO::FETCH_ASSOC);

    $bibliotecario = (new Bibliotecario())->setBibliotecarioId($bibliotecarioAss['bibliotecario_id'])
                        ->setBibliotecarioNome($bibliotecarioAss['bibliotecario_nome'])
                        ->setBibliotecarioCpf($bibliotecarioAss['bibliotecario_cpf'])
                        ->setBibliotecarioLogin($bibliotecarioAss['bibliotecario_login'])
                        ->setBibliotecarioSenha($bibliotecarioAss['bibliotecario_senha']);

    if($bibliotecarioAss){
        $_SESSION['usuario'] = $bibliotecario->getBibliotecarioNome();
        header('Location: home.php');
        exit();
    }else{
        header('Location: index.php');
        exit();
    }


?>