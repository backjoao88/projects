<?php

    include('autoload.php');

    // $marcaDAO = new MarcaDAO();
    // $marcaBO = new MarcaBO($marcaDAO);

    // $marca = (new Marca())->setId(13);

    // header('Content-Type: application/json');
    // echo json_encode($marcaBO->listarMarcaPorCodigo($marca), JSON_PRETTY_PRINT);

    // $produtoDAO = new ProdutoDAO();
    // $produtoBO = new ProdutoBO($produtoDAO);

    // $prod = (new Produto())->setId(2)
    //                 ->setDescricao('Netbook')
    //                 ->setPreco(121)
    //                 ->setCodigoBarra(123213131)
    //                 ->setMarcaId(9);


    // $vendedorDAO = new VendedorDAO();
    // $vendedorBO  = new VendedorBO($vendedorDAO);

    // $vendedor = (new Vendedor())->setIdVendedor(4);

    // header('Content-Type: application/json');
    // echo json_encode($vendedorBO->listarVendedorPorCodigo($vendedor), JSON_PRETTY_PRINT);
    

    $clienteDAO = new ClienteDAO();
    $clienteBO  = new ClienteBO($clienteDAO);

    $cliente = (new Cliente())->setIdCliente(2);

    header('Content-Type: application/json');
    echo json_encode($clienteBO->listarClientePorCodigo($cliente), JSON_PRETTY_PRINT);
    


?>