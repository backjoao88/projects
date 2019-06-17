<?php

    include('autoload.php');

    // $marcaDAO = new MarcaDAO();
    // $marcaBO = new MarcaBO($marcaDAO);

    // $marca = (new Marca())->setId(13);

    // echo json_encode($marcaBO->listarMarcaPorCodigo($marca), JSON_PRETTY_PRINT);

    $produtoDAO = new ProdutoDAO();
    $produtoBO = new ProdutoBO($produtoDAO);

    $prod = (new Produto())->setId(2)
                    ->setDescricao('Netbook')
                    ->setPreco(121)
                    ->setCodigoBarra(123213131)
                    ->setMarcaId(9);

    echo json_encode($produtoBO->listarProdutoPorCodigo($prod), JSON_PRETTY_PRINT);
    

    

?>