<?php

    include('autoload.php');

    // $marcaDAO = new MarcaDAO();
    // $marcaBO = new MarcaBO($marcaDAO);

    // $marca = (new Marca())->setId(10)->setDescricao('COCA-COLA');

    // $marcaBO->alterar($marca);

    $produtoDAO = new ProdutoDAO();
    $produtoBO = new ProdutoBO($produtoDAO);

    $prod = (new Produto())->setId(8)
                           ->setDescricao('MARTELO')
                           ->setPreco(50)
                           ->setCodigoBarra(12321321)
                           ->setMarcaId(13);

    $produtoBO->alterar($prod);



?>