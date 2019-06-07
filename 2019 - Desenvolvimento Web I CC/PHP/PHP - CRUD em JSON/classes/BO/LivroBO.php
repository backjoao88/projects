<?php

    include('autoload.php');

    class LivroBO implements IPersistenciaLivro{

        private $plivro;

        public function __construct($plivro){
            $this->plivro = $plivro;
        }

        public function inserir(Livro $livro){
            $this->plivro->inserir($livro);
        }
        
        public function alterar(Livro $livro){
            $this->plivro->alterar($livro);
            
        }

        public function excluir(Livro $livro){
            $this->plivro->excluir($livro);            
        }

        public function listarLivros(){
            return $this->plivro->listarLivros();   
        }

    }

?>