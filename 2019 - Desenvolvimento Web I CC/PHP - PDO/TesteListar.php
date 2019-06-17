<?php

    include('autoload.php');

    $marcaDAO = new MarcaDAO();
    $marcaBO = new MarcaBO($marcaDAO);

    echo json_encode($marcaBO->listarMarcas(), JSON_PRETTY_PRINT); echo '<br> <br>';

    // $produtoDAO = new ProdutoDAO();
    // $produtoBO = new ProdutoBO($produtoDAO);

    // echo json_encode($produtoBO->listarProdutos(), JSON_PRETTY_PRINT);
    

?>