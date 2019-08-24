<?php

    include('autoload.php');

    class ItemProduto extends Produto implements JsonSerializable{

        private $quantidadeProduto;

        /**
         * Get the value of quantidadeProduto
         */ 
        public function getQuantidadeProduto()
        {
            return $this->quantidadeProduto;
        }

        /**
         * Set the value of quantidadeProduto
         *
         * @return  self
         */ 
        public function setQuantidadeProduto($quantidadeProduto)
        {
            $this->quantidadeProduto = $quantidadeProduto;

            return $this;
        }

        public function jsonSerialize(){
            return get_object_vars($this);
    }

    }

?>