<?php


    class Vendedor{

        private $idVendedor;
        private $nome;
        private $usuario;
        private $senha;
        
        public function getIdVendedor(){
            return $this->idVendedor;
        }

        public function setIdVendedor($idVendedor){
            $this->idVendedor = $idVendedor;
        }

        public function getNome(){
            return $this->nome;
        }

        public function setNome($nome){
            $this->nome = $nome;
        }

        public function getUsuario(){
            return $this->usuario;
        }

        public function setUsuario($usuario){
            $this->usuario = $usuario;
        }

        public function getSenha(){
            return $this->senha;
        }

        public function setSenha($senha){
            $this->senha = $senha;
        }
    }


?>