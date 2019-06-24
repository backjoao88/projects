<?php

    include('autoload.php');

    $produtoDAO = new ProdutoDAO();
    $produtoBO = new ProdutoBO($produtoDAO);

    header('Content-Type: application/json');
    echo json_encode($produtoBO->listarProdutos(), JSON_PRETTY_PRINT);

    
?>