<?php

    interface IPersistenciaEmprestimo{

        const NOME_TABELA_EMPRESTIMO = "emprestimo";

        public function inserir(Emprestimo $livro);
        public function alterar(Emprestimo $livro);
        public function excluir(Emprestimo $livro);
        public function procurarEmprestimoPorId(Emprestimo $emprestimo);
        public function listarEmprestimos();  

    }

?>