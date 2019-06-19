<?php

    class Produto{
        
        private $id;
        private $descricao;
        private $preco;
        private $codigoBarra;
        private $marcaId;

        public function getId(){
            return $this->id;
        }

        public function setId($id){
            $this->id = $id;
            return $this;
        }

        public function getDescricao(){
            return $this->descricao;
        }

        public function setDescricao($descricao){
            $this->descricao = $descricao;
            return $this;
        }

        public function getPreco(){
            return $this->preco;
        }

        public function setPreco($preco){
            $this->preco = $preco;
            return $this;
        }

        public function getCodigoBarra(){
            return $this->codigoBarra;
        }

        public function setCodigoBarra($codigoBarra){
            $this->codigoBarra = $codigoBarra;
            return $this;
        }

        public function getMarcaId(){
            return $this->marcaId;
        }

        public function setMarcaId($marcaId){
            $this->marcaId = $marcaId;
        }
    }



?>