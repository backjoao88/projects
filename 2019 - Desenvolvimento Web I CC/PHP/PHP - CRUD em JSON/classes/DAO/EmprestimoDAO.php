<?php

    include('autoload.php')

    class EmprestimoDAO implements IPersistenciaLista, IPersistenciaEmprestimo{


        private $lista_emprestimos;
        private const NOME_ARQUIVO = 'emprestimos.json';


        public function inserir(Emprestimo $emprestimo){

        }
        
        public function alterar(Emprestimo $emprestimo){
            
        }

        public function excluir(Emprestimo $emprestimo){
            
        }

        public function listarEmprestimos(){
        
        }


        public function gravar(){
            $fp = fopen(NOME_ARQUIVO, 'w');
            fwrite($fp, json_encode($lista_usuarios));
            fclose($fp);
        }

        public function ler(){
            $json_file = file_get_contents(NOME_ARQUIVO);   
            $json_str = json_decode($json_file, true);
            return $json_str;  
        }

    }


?>