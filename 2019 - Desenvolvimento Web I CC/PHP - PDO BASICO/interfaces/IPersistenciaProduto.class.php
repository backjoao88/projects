<?php
    interface IPersistenciaProduto{

        public function inserir(Produto $produto);
        public function alterar(Produto $produto);
        public function excluir(Produto $produto);
        public function listarProdutos();  
        public function listarProdutosPorDescricao(Produto $produto);
        public function listarProdutoPorCodigo(Produto $produto);

    
    }
?>