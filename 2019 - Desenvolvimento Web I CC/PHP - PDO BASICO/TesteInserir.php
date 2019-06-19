<?php

    include('autoload.php');

    // $marcaDAO = new MarcaDAO();
    // $marcaBO = new MarcaBO($marcaDAO);

    // $marca = (new Marca())->setId(1)->setDescricao('AGRALE');

    // $marcaBO->inserir($marca);

    // $produtoDAO = new ProdutoDAO();
    // $produtoBO = new ProdutoBO($produtoDAO);

    // $prod = (new Produto())->setId(1)
    //                        ->setDescricao('nadasda')
    //                        ->setPreco(50)
    //                        ->setCodigoBarra(22223)
    //                        ->setMarcaId(13);

    // $produtoBO->inserir($prod);

    $clienteDAO = new ClienteDAO();
    $clienteBO  = new ClienteBO($clienteDAO);

    $cliente = $clienteBO->listarClientePorCodigo(2);

    $vendaDAO = new VendaDAO();
    $vendaBO  = new VendaBO($vendaDAO);

    $venda = (new Venda())->setIdVenda(2)
                              ->setData('29/10/2011')
                              ->setDataVencimento('30/11/2011')
                              ->setDataPagamento('30/12/2011')
                              ->setVendedor($vendedor)
                              ->setCliente($cliente);

    $vendaBO->inserir($venda);

    

?>