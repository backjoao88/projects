<?php

    require_once('../../vendor/autoload.php');

    use app\dto\Produto;
    use app\dao\ProdutoDAOMySQL;
    use app\bo\ProdutoBO;
    

    $produtoDAO = new ProdutoDAOMySQL();
    $produtoBO  = new ProdutoBO($produtoDAO);

    $produto = (new Produto())->setProdutoDescricao('teste123')
                              ->setProdutoValor(123)
                              ->setProdutoImagem('123');

    $produtoBO->inserir($produto);


    $produto = (new Produto())->setProdutoDescricao('uauauau')
                              ->setProdutoValor(123)
                              ->setProdutoImagem('123')
                              ->setProdutoCodigo(3);

    $produtoBO->alterar($produto);

    $produto = (new Produto())->setProdutoCodigo(2);

    $produtoBO->deletar($produto);

    echo 'Sucess!';

?>