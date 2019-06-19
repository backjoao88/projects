<?php
    interface IPersistenciaCliente{

        public function inserir(Cliente $cliente);
        public function alterar(Cliente $cliente);
        public function excluir(Cliente $cliente);
        public function listarClientes(); 
        public function listarClientePorCodigo(Cliente $cliente); 
 

    }
?>