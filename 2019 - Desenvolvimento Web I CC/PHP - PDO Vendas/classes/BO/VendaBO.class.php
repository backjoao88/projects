<?php

    include('autoload.php');

    class VendaBO implements IPersistenciaVenda{

        private $pvenda;

        public function __construct($venda){
            $this->pvenda = $venda;
        }

        public function inserir(Venda $venda){
            $this->pvenda->inserir($venda);
        }
        
        public function alterar(Venda $venda){
            $this->pvenda->alterar($venda);  
        }

        public function excluir(Venda $venda){
            $this->pvenda->excluir($venda);            
        }

        public function inserirItemProduto(Venda $venda, ItemProduto $itemProduto){
            $this->pvenda->inserirItemProduto($venda, $itemProduto); 
        }

        public function listarVendaPorCodigo(Venda $venda){
            return $this->pvenda->listarVendaPorCodigo($venda);   
        }

        public function listarVendas(){
            return $this->pvenda->listarVendas();   
        }

        public function listarItemProduto(Venda $venda){
            return $this->pvenda->listarItemProduto($venda);   
        }

    }

?>