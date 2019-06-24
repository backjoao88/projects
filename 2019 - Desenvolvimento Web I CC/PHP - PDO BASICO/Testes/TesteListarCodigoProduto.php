<?php

    include('autoload.php');

    $produtoDAO = new ProdutoDAO();
    $produtoBO  = new ProdutoBO($produtoDAO);

    $produto = (new Produto())->setId(2);

    header('Content-Type: application/json');
    echo json_encode($produtoBO->listarProdutoPorCodigo($produto), JSON_PRETTY_PRINT);
    


?>