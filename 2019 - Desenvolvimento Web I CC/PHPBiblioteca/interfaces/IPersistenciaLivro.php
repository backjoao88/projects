<?php

    interface IPersistenciaLivro{

        public function inserir(Livro $livro);
        public function alterar(Livro $livro);
        public function excluir(Livro $livro);
        public function procurarLivroPorId(Livro $livro);
        public function listarLivros();  

    }

?>