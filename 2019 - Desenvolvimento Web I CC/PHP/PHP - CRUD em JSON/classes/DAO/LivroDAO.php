<?php

    include('autoload.php');

    class LivroDAO implements IPersistenciaLista, IPersistenciaLivro{

        private $lista_livros;
        private const NOME_ARQUIVO = 'livros.json';

        public function inserir(Livro $livro){

        }
        
        public function alterar(Livro $livro){
            
        }

        public function excluir(Livro $livro){
            
        }

        public function listarLivros(){
        
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