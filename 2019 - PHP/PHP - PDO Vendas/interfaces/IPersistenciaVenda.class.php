<?php
    interface IPersistenciaVenda{

        public function inserir(Venda $venda);
        public function alterar(Venda $venda);
        public function excluir(Venda $venda);
        public function inserirItemProduto(Venda $venda, ItemProduto $itemProduto);
        public function listarItemProduto(Venda $venda);
        public function listarVendaPorCodigo(Venda $venda);
        public function listarVendas();  
    
    }
?>