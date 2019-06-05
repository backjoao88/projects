<?php

    class Usuario{
        
        private $usuario_id;
        private $usuario_login;
        private $usuario_senha;
        private $usuario_nome;
        private $usuario_cpf;

        public function utilizandoOID($usuario_id){
            $this->setUsuarioId($usuario_id);
            return $this;
        }

        public function cadastradoComOLogin($usuario_login){
            $this->setUsuarioLogin($usuario_login);
            return $this;
        }

        public function cadastradoComASenha($usuario_senha){
            $this->setUsuarioSenha($usuario_senha);
            return $this;
        }

        public function comONome($usuario_nome){
            $this->setUsuarioNome($usuario_nome);
            return $this;
        }

        public function utilizandoOCpf($usuario_cpf){
            $this->setUsuarioCpf($usuario_cpf);
            return $this;
        }

        public function getUsuarioId(){
            return $this->usuario_id;
        }

        public function setUsuarioId($usuario_id){
            $this->usuario_id = $usuario_id;
        }

        public function getUsuarioLogin(){
                return $this->usuario_login;
        }

        public function setUsuarioLogin($usuario_login){
            $this->usuario_login = $usuario_login;
        }

        public function getUsuarioSenha(){
            return $this->usuario_senha;
        }

        public function setUsuarioSenha($usuario_senha){
            $this->usuario_senha = $usuario_senha;
        }

        public function getUsuarioNome(){
            return $this->usuario_nome;
        }

        public function setUsuarioNome($usuario_nome){
            $this->usuario_nome = $usuario_nome;
        }

        public function getUsuarioCpf(){
                return $this->usuario_cpf;
        }

        public function setUsuarioCpf($usuario_cpf){
                $this->usuario_cpf = $usuario_cpf;
        }

        public function toString(){
            return 'Usuario -> ' .   
                    'ID: ' . $this->getUsuarioID() . ', ' . 
                    'Nome: ' . $this->getUsuarioNome() . ', ' . 
                    'Login: ' . $this->getUsuarioLogin() . ', ' . 
                    'Senha: ' . $this->getUsuarioSenha() . ', ' . 
                    'CPF: ' . $this->getUsuarioCpf();          
        }



    }


?>