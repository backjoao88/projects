<?php

include('autoload.php')
    class LivroBO implements IPersistenciaLivro{

        private IPersistenciaLivro $plivro;

        public function inserir(Livro $plivro){
            $this->plivro.inserir($plivro);
        }
        
        public function alterar(Livro $emprestimo){
            $this->plivro.inserir($plivro);
            
        }

        public function excluir(Livro $plivro){
            $this->plivro.inserir($plivro);            
        }

        public function listarLivros(){
            return $this->plivro.listarLivros();   
        }

    }

?>