<?php

    include('autoload.php');

    class MarcaBO implements IPersistenciaMarca{

        private $pmarca;

        public function __construct($pmarca){
            $this->pmarca = $pmarca;
        }

        public function inserir(Marca $marca){
            $this->pmarca->inserir($marca);
        }
        
        public function alterar(Marca $marca){
            $this->pmarca->alterar($marca);            
        }

        public function excluir(Marca $marca){
            $this->pmarca->excluir($marca);            
        }

        public function listarMarcasPorDescricao(Marca $marca){
            return $this->pmarca->listarMarcasPorDescricao($marca);            
        }

        public function listarMarcaPorCodigo(Marca $marca){
            return $this->pmarca->listarMarcaPorCodigo($marca);            
        }

        public function listarMarcas(){
            return $this->pmarca->listarMarcas();   
        }

    }

?>