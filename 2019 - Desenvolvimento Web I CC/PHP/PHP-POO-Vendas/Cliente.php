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

        // comId(), comEstado()

        public function __construct($idCliente, $nome){
            $this->setIdCliente($idCliente);
            $this->setNome($nome);
        }

        
        public function getIdCliente(){
            return $this->idCliente;
        }

        public function setIdCliente($idCliente){
            $this->idCliente = $idCliente;
        }

        public function getNome(){
            return $this->nome;
        }

        public function setNome($nome){
            $this->nome = $nome;
        }

        public function getCpf(){
            return $this->cpf;
        }

        public function setCpf($cpf){
            $this->cpf = $cpf;
        }

        public function getRg(){
            return $this->rg;
        }

        public function setRg($rg){
            $this->rg = $rg;
        }


        public function getFone(){
            return $this->fone;
        }

        public function setFone($fone){
            $this->fone = $fone;
        }

        public function getEmail(){
            return $this->email;
        }

        public function setEmail($email){
            $this->email = $email;
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

        public function getEndereco(){
            return $this->endereco;
        }

        public function setEndereco($endereco){
            $this->endereco = $endereco;
        }

        public function getNumero(){
            return $this->numero;
        }

        public function setNumero($numero){
            $this->numero = $numero;
        }

        public function getBairro(){
            return $this->bairro;
        }

        public function setBairro($bairro){
            $this->bairro = $bairro;
        }

        public function getCidade(){
            return $this->cidade;
        }

        public function setCidade($cidade){
            $this->cidade = $cidade;
        }
        public function getEstado(){
            return $this->estado;
        }
        public function setEstado($estado){
            $this->estado = $estado;
        }


        public function toString(){
            return 'Cliente = [id: ' . $this->getIdCliente() . ', ' . 
            'nome: ' . $this->getNome() . ', ';
        }

    }


?>