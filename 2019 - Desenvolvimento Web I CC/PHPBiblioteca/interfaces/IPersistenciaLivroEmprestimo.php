<?php

    interface IPersistenciaLivroEmprestimo{

        private const NOME_TABELA_LIVRO_EMPRESTIMO = "livro_emprestimo";

        public function inserirLivroEmprestimo(Emprestimo $emprestimo, Livro $livro);
        public function alterarLivroEmprestimo(Emprestimo $emprestimo, Livro $livro);
        public function excluirLivroEmprestimo(Emprestimo $emprestimo, Livro $livro);
        public function procurarLivroPorId(Emprestimo $emprestimo, Livro $livro);
        public function listarLivrosDoEmprestimo(Emprestimo $emprestimo);  

    }

?>