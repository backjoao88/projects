<?php

    include('autoload.php');

    $vendaDAO = new VendaDAO();
    $vendaBO  = new VendaBO($vendaDAO);

    $venda = (new Venda())->setIdVenda(6);

    header('Content-Type: application/json');
    echo var_dump($vendaBO->listarVendaPorCodigo($venda), JSON_PRETTY_PRINT);
    

?>