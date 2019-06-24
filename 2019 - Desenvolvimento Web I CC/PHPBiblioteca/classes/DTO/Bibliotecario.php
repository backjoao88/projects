<?php

    class Bibliotecario implements JsonSerializable{
        
        private $bibliotecario_id;
        private $bibliotecario_nome;
        private $bibliotecario_cpf;
        private $bibliotecario_login;
        private $bibliotecario_senha;

        public function utilizandoOID($bibliotecario_id){
            $this->setBibliotecarioId($bibliotecario_id);
            return $this;
        }

        public function comONome($bibliotecario_nome){
            $this->setBibliotecarioNome($bibliotecario_nome);
            return $this;
        }

        public function utilizandoOCpf($bibliotecario_cpf){
            $this->setBibliotecarioCpf($bibliotecario_cpf);
            return $this;
        }

        public function casdastradoComOLogin($bibliotecario_login){
            $this->setLogin($bibliotecario_login);
            return $this;
        }

        public function casdastradoComASenha($bibliotecario_senha){
            $this->setSenha($bibliotecario_senha);
            return $this;
        }

        public function getBibliotecarioId(){
            return $this->bibliotecario_id;
        }

        public function setBibliotecarioId($bibliotecario_id){
            $this->bibliotecario_id = $bibliotecario_id;
        }

        public function getBibliotecarioNome(){
            return $this->bibliotecario_nome;
        }

        public function setBibliotecarioNome($bibliotecario_nome){
            $this->bibliotecario_nome = $bibliotecario_nome;
        }

        public function getBibliotecarioCpf(){
                return $this->bibliotecario_cpf;
        }

        public function setBibliotecarioCpf($bibliotecario_cpf){
                $this->bibliotecario_cpf = $bibliotecario_cpf;
        }

        public function getBibliotecarioLogin(){
            return $this->bibliotecario_login;
        }

        public function setBibliotecarioLogin($bibliotecario_login){
            $this->bibliotecario_login = $bibliotecario_login;
        }

        public function getBibliotecarioSenha(){
            return $this->bibliotecario_senha;
        }

        public function setBibliotecarioSenha($bibliotecario_senha){
            $this->bibliotecario_senha = $bibliotecario_senha;
        }
        
        public function jsonSerialize(){
            return get_object_vars($this);
        }

        public function toString(){
            return 'Bibliotecario -> ' .   
                    'ID: ' . $this->getBibliotecarioId() . ', ' . 
                    'Nome: ' . $this->getBibliotecarioNome() . ', ' . 
                    'CPF: ' . $this->getBibliotecarioCpf();          
        }

    }


?>