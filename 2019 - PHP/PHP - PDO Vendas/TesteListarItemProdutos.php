<?php

    include('autoload.php');

    $vendaDAO = new VendaDAO();
    $vendaBO  = new VendaBO($vendaDAO);

    $venda = (new Venda())->setIdVenda(2);

    header('Content-Type: application/json');
    echo json_encode($vendaBO->listarItemProduto($venda));
    
?>