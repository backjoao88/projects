<?php

    interface IPersistenciaLivrosEmprestimo{

        private const NOME_TABELA_LIVRO_EMPRESTIMO = "livro_emprestimo";

        public function inserirLivroEmprestimo(Emprestimo $emprestimo, Livro $livro);
        public function alterarLivroEmprestimo(Emprestimo $emprestimo, Livro $livro);
        public function excluirLivroEmprestimo(Emprestimo $emprestimo, Livro $livro);
        public function procurarLivroEmprestimoPorId(Emprestimo $emprestimo);
        public function listarLivrosEmprestimo(Emprestimo $livro);  

    }

?>