<?php

    class Produto{

        private $idProduto;
        private $descricao;
        private $valor;
        private $estoque;
        private $imagem;

    
        public function getIdProduto(){
                return $this->idProduto;
        }

        public function setIdProduto($idProduto){
                $this->idProduto = $idProduto;
        }

        public function getDescricao(){
            return $this->descricao;
        }

        public function setDescricao($descricao){
            $this->descricao = $descricao;
        }

        public function getValor(){
            return $this->valor;
        }

        public function setValor($valor){
            $this->valor = $valor;
        }

        public function getEstoque(){
            return $this->estoque;
        }
 
        public function setEstoque($estoque){
            $this->estoque = $estoque;
        }

        public function getImagem(){
            return $this->imagem;
        }

        public function setImagem($imagem){
            $this->imagem = $imagem;
        }
    }



?>