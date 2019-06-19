<?php


    class Vendedor{

        private $idVendedor;
        private $nome;
        private $usuario;
        private $senha;
    
        /**
         * Get the value of idVendedor
         */ 
        public function getIdVendedor()
        {
                return $this->idVendedor;
        }

        /**
         * Set the value of idVendedor
         *
         * @return  self
         */ 
        public function setIdVendedor($idVendedor)
        {
                $this->idVendedor = $idVendedor;

                return $this;
        }

        /**
         * Get the value of nome
         */ 
        public function getNome()
        {
                return $this->nome;
        }

        /**
         * Set the value of nome
         *
         * @return  self
         */ 
        public function setNome($nome)
        {
                $this->nome = $nome;

                return $this;
        }

        /**
         * Get the value of usuario
         */ 
        public function getUsuario()
        {
                return $this->usuario;
        }

        /**
         * Set the value of usuario
         *
         * @return  self
         */ 
        public function setUsuario($usuario)
        {
                $this->usuario = $usuario;

                return $this;
        }

        /**
         * Get the value of senha
         */ 
        public function getSenha()
        {
                return $this->senha;
        }

        /**
         * Set the value of senha
         *
         * @return  self
         */ 
        public function setSenha($senha)
        {
                $this->senha = $senha;

                return $this;
        }
    }


?>