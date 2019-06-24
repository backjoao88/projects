<?php

    include('autoload.php');


    $clienteDAO = new ClienteDAO();
    $clienteBO  = new ClienteBO($clienteDAO);

    header('Content-Type: application/json');
    echo print_r($clienteBO->listarClientes(), JSON_PRETTY_PRINT);

?>