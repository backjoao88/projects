<?php

    include('autoload.php');

    class ItemProduto extends Produto{

        private $quantidadeProduto;

        public function getQuantidadeProduto(){
                return $this->quantidadeProduto;
        }

        public function setQuantidadeProduto($quantidadeProduto){
            $this->quantidadeProduto = $quantidadeProduto;
        }

    }



?>