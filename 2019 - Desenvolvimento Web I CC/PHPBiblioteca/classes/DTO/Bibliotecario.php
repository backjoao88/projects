<?php

    class Bibliotecario implements JsonSerializable{
        
        private $bibliotecario_id;
        private $bibliotecario_nome;
        private $bibliotecario_cpf;
        private $bibliotecario_login;
        private $bibliotecario_senha;


        /**
         * Get the value of bibliotecario_id
         */ 
        public function getBibliotecarioId()
        {
                return $this->bibliotecario_id;
        }

        /**
         * Set the value of bibliotecario_id
         *
         * @return  self
         */ 
        public function setBibliotecarioId($bibliotecario_id)
        {
                $this->bibliotecario_id = $bibliotecario_id;

                return $this;
        }

        /**
         * Get the value of bibliotecario_nome
         */ 
        public function getBibliotecarioNome()
        {
                return $this->bibliotecario_nome;
        }

        /**
         * Set the value of bibliotecario_nome
         *
         * @return  self
         */ 
        public function setBibliotecarioNome($bibliotecario_nome)
        {
                $this->bibliotecario_nome = $bibliotecario_nome;

                return $this;
        }

        /**
         * Get the value of bibliotecario_cpf
         */ 
        public function getBibliotecarioCpf()
        {
                return $this->bibliotecario_cpf;
        }

        /**
         * Set the value of bibliotecario_cpf
         *
         * @return  self
         */ 
        public function setBibliotecarioCpf($bibliotecario_cpf)
        {
                $this->bibliotecario_cpf = $bibliotecario_cpf;

                return $this;
        }

        /**
         * Get the value of bibliotecario_login
         */ 
        public function getBibliotecarioLogin()
        {
                return $this->bibliotecario_login;
        }

        /**
         * Set the value of bibliotecario_login
         *
         * @return  self
         */ 
        public function setBibliotecarioLogin($bibliotecario_login)
        {
                $this->bibliotecario_login = $bibliotecario_login;

                return $this;
        }

        /**
         * Get the value of bibliotecario_senha
         */ 
        public function getBibliotecarioSenha()
        {
                return $this->bibliotecario_senha;
        }

        /**
         * Set the value of bibliotecario_senha
         *
         * @return  self
         */ 
        public function setBibliotecarioSenha($bibliotecario_senha)
        {
                $this->bibliotecario_senha = $bibliotecario_senha;

                return $this;
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