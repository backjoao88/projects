<?php

    include('autoload.php');

    class EmprestimoDAOMySQL implements IPersistenciaEmprestimo{


        private $lista_emprestimos;
        private const NOME_TABELA = 'emprestimo';

        public function inserir(Emprestimo $emprestimo){

        }
        
        public function alterar(Emprestimo $emprestimo){

        }

        public function excluir(Emprestimo $emprestimo){

        }

        public function procurarEmprestimoPorId(Emprestimo $emprestimo){

        }

        public function listarEmprestimos(){
            return $this->ler();
        }



    }


?>