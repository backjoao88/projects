<?php

    include('autoload.php');

    // $marcaDAO = new MarcaDAO();
    // $marcaBO = new MarcaBO($marcaDAO);

    // header('Content-Type: application/json');
    // echo json_encode($marcaBO->listarMarcas(), JSON_PRETTY_PRINT); echo '<br> <br>';

    // $clienteDAO = new ClienteDAO();
    // $clienteBO  = new ClienteBO($clienteDAO);

    // header('Content-Type: application/json');
    // echo json_encode($clienteBO->listarClientes(), JSON_PRETTY_PRINT);

    $vendedorDAO = new VendedorDAO();
    $vendedorBO  = new VendedorBO($vendedorDAO);

    header('Content-Type: application/json');
    echo json_encode($vendedorBO->listarVendedores(), JSON_PRETTY_PRINT);


    // $produtoDAO = new ProdutoDAO();
    // $produtoBO = new ProdutoBO($produtoDAO);

    // header('Content-Type: application/json');
    // echo json_encode($produtoBO->listarProdutos(), JSON_PRETTY_PRINT);
    

?>