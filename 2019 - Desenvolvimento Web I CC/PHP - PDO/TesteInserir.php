<?php

    include('autoload.php');

    // $marcaDAO = new MarcaDAO();
    // $marcaBO = new MarcaBO($marcaDAO);

    // $marca = (new Marca())->setId(1)->setDescricao('AGRALE');

    // $marcaBO->inserir($marca);

    $produtoDAO = new ProdutoDAO();
    $produtoBO = new ProdutoBO($produtoDAO);

    $prod = (new Produto())->setId(1)
                           ->setDescricao('nadasda')
                           ->setPreco(50)
                           ->setCodigoBarra(22223)
                           ->setMarcaId(13);

    $produtoBO->inserir($prod);
    

?>