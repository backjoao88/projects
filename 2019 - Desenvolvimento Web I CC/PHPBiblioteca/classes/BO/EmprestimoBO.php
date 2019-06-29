<?php

include('autoload.php');

    class EmprestimoBO implements IPersistenciaEmprestimo{

        private $pemprestimo;

        public function __construct($pemprestimo){
            $this->pemprestimo = $pemprestimo;
        }

        public function inserir(Emprestimo $emprestimo){
            $this->pemprestimo->inserir($emprestimo);
        }
        
        public function alterar(Emprestimo $emprestimo){
            $this->pemprestimo->alterar($emprestimo);
            
        }

        public function excluir(Emprestimo $emprestimo){
            $this->pemprestimo->excluir($emprestimo);            
        }

        public function existe(Emprestimo $emprestimo){
            $this->pemprestimo->existe($emprestimo);            
        }

        public function procurarEmprestimoPorId(Emprestimo $emprestimo){
            return $this->pemprestimo->procurarEmprestimoPorId($emprestimo);            
        }

        public function listarEmprestimos(){
            return $this->pemprestimo->listarEmprestimos();   
        }

        public function inserirLivroEmprestimo(Emprestimo $emprestimo, Livro $livro){
            $this->pemprestimo->inserirLivroEmprestimo($emprestimo, $livro); 
        }

        public function alterarLivroEmprestimo(Emprestimo $emprestimo, Livro $livro){
            $this->pemprestimo->alterarLivroEmprestimo($emprestimo, $livro);    
        }

        public function excluirLivroEmprestimo(Emprestimo $emprestimo, Livro $livro){
            $this->pemprestimo->excluirLivroEmprestimo($emprestimo, $livro); 
        }

        public function procurarLivroPorId(Emprestimo $emprestimo, Livro $livro){
            return $this->pemprestimo->procurarLivroPorId($emprestimo, $livro);  
        }
        
        public function listarLivrosDoEmprestimo(Emprestimo $emprestimo){
            return $this->pemprestimo->listarLivrosDoEmprestimo($emprestimo); 
        } 

        public function deletarTodosLivrosDoEmprestimo(Emprestimo $emprestimo){
            $this->pemprestimo->deletarTodosLivrosDoEmprestimo($emprestimo); 
        }


    }

?>