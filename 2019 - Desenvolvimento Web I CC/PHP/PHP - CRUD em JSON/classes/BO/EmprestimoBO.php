<?php

include('autoload.php');

    class EmprestimoBO implements IPersistenciaEmprestimo{

        private IPersistenciaEmprestimo $pemprestimo;

        public function inserir(Emprestimo $emprestimo){
            $this->pemprestimo.inserir($emprestimo);
        }
        
        public function alterar(Emprestimo $emprestimo){
            $this->pemprestimo.inserir($emprestimo);
            
        }

        public function excluir(Emprestimo $emprestimo){
            $this->pemprestimo.inserir($emprestimo);            
        }

        public function listarEmprestimos(){
            return $this->pemprestimo.listarEmprestimos();   
        }

    }

?>