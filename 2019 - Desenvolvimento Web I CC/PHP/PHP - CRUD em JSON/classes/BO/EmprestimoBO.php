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

        public function listarEmprestimos(){
            return $this->pemprestimo->listarEmprestimos();   
        }

    }

?>