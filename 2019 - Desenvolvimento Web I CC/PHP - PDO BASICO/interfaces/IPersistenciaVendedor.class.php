<?php
    interface IPersistenciaVendedor{

        public function inserir(Vendedor $vendedor);
        public function alterar(Vendedor $vendedor);
        public function excluir(Vendedor $vendedor);
        public function listarVendedores();  
        public function listarVendedorPorCodigo(Vendedor $vendedor); 
    
    }
?>