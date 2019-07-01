<?php

    include('autoload.php');

    $bibliotecarioDAO = new BibliotecarioDAOMySQL();
    $bibliotecarioBO = new BibliotecarioBO($bibliotecarioDAO);

    $b = $bibliotecarioBO->procurarBibliotecarioPorId((new Bibliotecario())->setBibliotecarioId(3));

    echo json_encode($b, JSON_PRETTY_PRINT);



?>