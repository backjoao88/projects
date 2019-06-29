<?php

    interface IPersistenciaLivroEmprestimo{

        const NOME_TABELA_LIVRO_EMPRESTIMO = "livro_emprestimo";

        public function inserirLivroEmprestimo(Emprestimo $emprestimo, Livro $livro);
        public function alterarLivroEmprestimo(Emprestimo $emprestimo, Livro $livro);
        public function excluirLivroEmprestimo(Emprestimo $emprestimo, Livro $livro);
        public function procurarLivroPorId(Emprestimo $emprestimo, Livro $livro);
        public function listarLivrosDoEmprestimo(Emprestimo $emprestimo);  
        public function deletarTodosLivrosDoEmprestimo(Emprestimo $emprestimo);  


    }

?>