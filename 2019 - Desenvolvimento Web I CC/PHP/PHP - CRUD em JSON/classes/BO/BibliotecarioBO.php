<?php

include('autoload.php');

    class BibliotecarioBO implements IPersistenciaBibliotecario{

        private $pbibliotecario;

        public function __construct($pbibliotecario){
            $this->pbibliotecario = $pbibliotecario;
        }

        public function inserir(Bibliotecario $bibliotecario){
            $this->pbibliotecario->inserir($bibliotecario);
        }
        
        public function alterar(Bibliotecario $bibliotecario){
            $this->pbibliotecario->alterar($bibliotecario);  
        }

        public function excluir(Bibliotecario $bibliotecario){
            $this->pbibliotecario->excluir($bibliotecario);            
        }

        public function existe(Bibliotecario $bibliotecario){
            $this->pbibliotecario->existe($bibliotecario);            
        }

        public function procurarBibliotecarioPorId(Bibliotecario $bibliotecario){
            return $this->pbibliotecario->procurarBibliotecarioPorId($bibliotecario);            
        }

        public function listarBibliotecarios(){
            return $this->pbibliotecario->listarBibliotecarios();   
        }

    }

?>