<?php

    namespace app\interfaces;

    use app\dto\Produto;

    interface IPersistenciaProduto{

        public function inserir(Produto $produto);
        public function alterar(Produto $produto);
        public function deletar(Produto $produto);
        public function listar();
        
    }

?>