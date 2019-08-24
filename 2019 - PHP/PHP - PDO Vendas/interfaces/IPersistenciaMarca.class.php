<?php
    interface IPersistenciaMarca{

        public function inserir(Marca $marca);
        public function alterar(Marca $marca);
        public function excluir(Marca $marca);
        public function listarMarcas(); 
        public function listarMarcasPorDescricao(Marca $marca);
        public function listarMarcaPorCodigo(Marca $marca);
 

    }
?>