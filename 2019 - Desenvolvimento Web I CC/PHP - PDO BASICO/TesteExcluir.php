<?php

    include('autoload.php');

    // $marcaDAO = new MarcaDAO();
    // $marcaBO = new MarcaBO($marcaDAO);

    // $marca = (new Marca())->setId(9);

    // $marcaBO->excluir($marca);

    // $produtoDAO = new ProdutoDAO();
    // $produtoBO = new ProdutoBO($produtoDAO);

    // $prod = (new Produto())->setId(10);

    // $produtoBO->excluir($prod);

    $vendedorDAO = new VendedorDAO();
    $vendedorBO  = new VendedorBO($vendedorDAO);

    $vendedor = (new Vendedor())->setIdVendedor(1);

    $vendedorBO->excluir($vendedor);

?>