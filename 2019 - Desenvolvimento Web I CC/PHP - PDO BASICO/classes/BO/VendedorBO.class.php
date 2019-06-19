<?php

    include('autoload.php');

    class VendedorBO implements IPersistenciaVendedor{

        private $pvendedor;

        public function __construct($pvendedor){
            $this->pvendedor = $pvendedor;
        }

        public function inserir(Vendedor $vendedor){
            $this->pvendedor->inserir($vendedor);
        }
        
        public function alterar(Vendedor $vendedor){
            $this->pvendedor->alterar($vendedor);
            
        }

        public function excluir(Vendedor $vendedor){
            $this->pvendedor->excluir($vendedor);            
        }

        public function listarVendedores(){
            return $this->pvendedor->listarVendedores();   
        }

        public function listarVendedorPorCodigo(Vendedor $vendedor){
            return $this->pvendedor->listarVendedorPorCodigo($vendedor);  
        }

    }

?>