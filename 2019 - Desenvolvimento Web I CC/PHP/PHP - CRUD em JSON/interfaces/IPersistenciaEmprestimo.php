<?php

    interface IPersistenciaEmprestimo{


        public function inserir(Emprestimo $livro);
        public function alterar(Emprestimo $livro);
        public function excluir(Emprestimo $livro);
        public function existe(Emprestimo $emprestimo);
        public function procurarEmprestimoPorId(Emprestimo $emprestimo);
        public function listarEmprestimos();  

    }

?>