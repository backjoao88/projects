<?php
    interface IPersistenciaVenda{

        public function inserir(Venda $venda);
        public function alterar(Venda $venda);
        public function excluir(Venda $venda);
        public function listarVendas();  

    
    }
?>