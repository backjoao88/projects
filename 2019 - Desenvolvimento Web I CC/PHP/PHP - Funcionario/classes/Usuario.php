<?php

    abstract class Usuario{

        private $login;
        private $senha;

        public function __construct($login, $senha){
            $this->setLogin($login);
            $this->setSenha($this->codificarStringParaSha1($senha));
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

        /**
         * Get the value of login
         */ 
        public function getLogin()
        {
                return $this->login;
        }

        /**
         * Set the value of login
         *
         * @return  self
         */ 
        public function setLogin($login)
        {
                $this->login = $login;

                return $this;
        }

        public function codificarStringParaSha1($str){
            return sha1($str);
        }

        public function toString(){
            return 'Login = ' . $this->getLogin() . ' | ' . 'Senha = ' . $this->getSenha();
        }


    }


?>