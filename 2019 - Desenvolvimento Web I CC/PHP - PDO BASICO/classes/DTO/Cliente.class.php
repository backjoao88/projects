<?php


    class Cliente{
        
        private $idCliente;
        private $nome;
        private $cpf;
        private $rg;
        private $fone;
        private $email;
        private $usuario;
        private $senha;
        private $endereco;
        private $numero;
        private $bairro;
        private $cidade;
        private $estado;


        /**
         * Get the value of idCliente
         */ 
        public function getIdCliente()
        {
                return $this->idCliente;
        }

        /**
         * Set the value of idCliente
         *
         * @return  self
         */ 
        public function setIdCliente($idCliente)
        {
                $this->idCliente = $idCliente;

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
         * Get the value of cpf
         */ 
        public function getCpf()
        {
                return $this->cpf;
        }

        /**
         * Set the value of cpf
         *
         * @return  self
         */ 
        public function setCpf($cpf)
        {
                $this->cpf = $cpf;

                return $this;
        }

        /**
         * Get the value of rg
         */ 
        public function getRg()
        {
                return $this->rg;
        }

        /**
         * Set the value of rg
         *
         * @return  self
         */ 
        public function setRg($rg)
        {
                $this->rg = $rg;

                return $this;
        }

        /**
         * Get the value of fone
         */ 
        public function getFone()
        {
                return $this->fone;
        }

        /**
         * Set the value of fone
         *
         * @return  self
         */ 
        public function setFone($fone)
        {
                $this->fone = $fone;

                return $this;
        }

        /**
         * Get the value of email
         */ 
        public function getEmail()
        {
                return $this->email;
        }

        /**
         * Set the value of email
         *
         * @return  self
         */ 
        public function setEmail($email)
        {
                $this->email = $email;

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

        /**
         * Get the value of endereco
         */ 
        public function getEndereco()
        {
                return $this->endereco;
        }

        /**
         * Set the value of endereco
         *
         * @return  self
         */ 
        public function setEndereco($endereco)
        {
                $this->endereco = $endereco;

                return $this;
        }

        /**
         * Get the value of numero
         */ 
        public function getNumero()
        {
                return $this->numero;
        }

        /**
         * Set the value of numero
         *
         * @return  self
         */ 
        public function setNumero($numero)
        {
                $this->numero = $numero;

                return $this;
        }

        /**
         * Get the value of bairro
         */ 
        public function getBairro()
        {
                return $this->bairro;
        }

        /**
         * Set the value of bairro
         *
         * @return  self
         */ 
        public function setBairro($bairro)
        {
                $this->bairro = $bairro;

                return $this;
        }

        /**
         * Get the value of cidade
         */ 
        public function getCidade()
        {
                return $this->cidade;
        }

        /**
         * Set the value of cidade
         *
         * @return  self
         */ 
        public function setCidade($cidade)
        {
                $this->cidade = $cidade;

                return $this;
        }

        /**
         * Get the value of estado
         */ 
        public function getEstado()
        {
                return $this->estado;
        }

        /**
         * Set the value of estado
         *
         * @return  self
         */ 
        public function setEstado($estado)
        {
                $this->estado = $estado;

                return $this;
        }
    }


?>