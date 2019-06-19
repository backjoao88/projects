<?php

    include('autoload.php');

    class ClienteBO implements IPersistenciaCliente{

        private $pcliente;

        public function __construct($pcliente){
            $this->pcliente = $pcliente;
        }

        public function inserir(Cliente $pcliente){
            $this->pcliente->inserir($pcliente);
        }
        
        public function alterar(Cliente $pcliente){
            $this->pcliente->alterar($pcliente);            
        }

        public function excluir(Cliente $pcliente){
            $this->pcliente->excluir($pcliente);            
        }

        public function listarClientes(){
            return $this->pcliente->listarClientes();   
        }

        public function listarClientePorCodigo(Cliente $cliente){
            return $this->pcliente->listarClientePorCodigo($cliente);  
        }

    }

?>