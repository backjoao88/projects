<?php

    include('autoload.php');

    // $marcaDAO = new MarcaDAO();
    // $marcaBO = new MarcaBO($marcaDAO);

    // $marca = (new Marca())->setId(13)->setDescricao('COCA-COLA');

    // echo json_encode($marcaBO->listarMarcasPorDescricao($marca), JSON_PRETTY_PRINT);

    $produtoDAO = new ProdutoDAO();
    $produtoBO = new ProdutoBO($produtoDAO);

    $prod = (new Produto())->setId(8)
                    ->setDescricao('MARTELO')
                    ->setPreco(121)
                    ->setCodigoBarra(123213131)
                    ->setMarcaId(9);

    echo json_encode($produtoBO->listarProdutosPorDescricao($prod), JSON_PRETTY_PRINT);
    

    

?>