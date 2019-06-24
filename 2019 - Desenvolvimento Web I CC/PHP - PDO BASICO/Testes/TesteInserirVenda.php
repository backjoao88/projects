<?php
    include('autoload.php');

    $clienteDAO = new ClienteDAO();
    $clienteBO  = new ClienteBO($clienteDAO);

    $vendedorDAO = new VendedorDAO();
    $vendedorBO  = new VendedorBO($vendedorDAO);

    $produtoDAO = new ProdutoDAO();
    $produtoBO  = new ProdutoBO($produtoDAO);

    $vendaDAO = new VendaDAO();
    $vendaBO  = new VendaBO($vendaDAO);



    $cliente = $clienteBO->listarClientePorCodigo((new Cliente)->setIdCliente(1));

    $vendedor = $vendedorBO->listarVendedorPorCodigo((new Vendedor)->setIdVendedor(3));

    $itemProduto = (new ItemProduto())->setQuantidadeProduto(20);
    $produto = $produtoBO->listarProdutoPorCodigo((new Produto)->setId(1));
    $itemProduto->setId($produto->getId())
                 ->setDescricao($produto->getDescricao())
                 ->setMarcaId($produto->getMarcaId())
                 ->setCodigoBarra($produto->getCodigoBarra())
                 ->setPreco($produto->getPreco());
                 
    $itemProduto2 = (new ItemProduto())->setQuantidadeProduto(220);
    $produto2 = $produtoBO->listarProdutoPorCodigo((new Produto)->setId(2));

    $itemProduto2->setId($produto2->getId())
                 ->setDescricao($produto2->getDescricao())
                 ->setMarcaId($produto2->getMarcaId())
                 ->setCodigoBarra($produto2->getCodigoBarra())
                 ->setPreco($produto2->getPreco());
                 
    $itens[] = $itemProduto;
    $itens[] = $itemProduto2;
   
    $venda = (new Venda())->setIdVenda(6)
                            ->setData('29/10/2011')
                            ->setDataVencimento('30/11/2011')
                            ->setDataPagamento('30/12/2011')
                            ->setVendedor($vendedor)
                            ->setCliente($cliente)
                            ->setProdutos($itens);

    $vendaBO->inserir($venda);

    $vendaIt = $vendaBO->listarVendaPorCodigo((new Venda)->setIdVenda(6));
    
    $vendaBO->inserirItemProduto($vendaIt, $itemProduto);
    $vendaBO->inserirItemProduto($vendaIt, $itemProduto2);
    


?>