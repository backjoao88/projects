<?php

    class Produto implements JsonSerializable{
        
        private $id;
        private $descricao;
        private $preco;
        private $codigoBarra;
        private $marcaId;

        /**
         * Get the value of id
         */ 
        public function getId()
        {
                return $this->id;
        }

        /**
         * Set the value of id
         *
         * @return  self
         */ 
        public function setId($id)
        {
                $this->id = $id;

                return $this;
        }

        /**
         * Get the value of descricao
         */ 
        public function getDescricao()
        {
                return $this->descricao;
        }

        /**
         * Set the value of descricao
         *
         * @return  self
         */ 
        public function setDescricao($descricao)
        {
                $this->descricao = $descricao;

                return $this;
        }

        /**
         * Get the value of preco
         */ 
        public function getPreco()
        {
                return $this->preco;
        }

        /**
         * Set the value of preco
         *
         * @return  self
         */ 
        public function setPreco($preco)
        {
                $this->preco = $preco;

                return $this;
        }

        /**
         * Get the value of codigoBarra
         */ 
        public function getCodigoBarra()
        {
                return $this->codigoBarra;
        }

        /**
         * Set the value of codigoBarra
         *
         * @return  self
         */ 
        public function setCodigoBarra($codigoBarra)
        {
                $this->codigoBarra = $codigoBarra;

                return $this;
        }

        /**
         * Get the value of marcaId
         */ 
        public function getMarcaId()
        {
                return $this->marcaId;
        }

        /**
         * Set the value of marcaId
         *
         * @return  self
         */ 
        public function setMarcaId($marcaId)
        {
                $this->marcaId = $marcaId;

                return $this;
        }

        public function jsonSerialize(){
                return get_object_vars($this);
        }


    }



?>