<?php

    include('autoload.php');


    $vendedorDAO = new VendedorDAO();
    $vendedorBO  = new VendedorBO($vendedorDAO);

    header('Content-Type: application/json');
    echo print_r($vendedorBO->listarVendedores(), JSON_PRETTY_PRINT);



?>