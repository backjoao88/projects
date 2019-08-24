<?php

    include('autoload.php');

    $vendaDAO = new VendaDAO();
    $vendaBO  = new VendaBO($vendaDAO);

    header('Content-Type: application/json');
    echo json_encode($vendaBO->listarVendas(), JSON_PRETTY_PRINT);
    
?>