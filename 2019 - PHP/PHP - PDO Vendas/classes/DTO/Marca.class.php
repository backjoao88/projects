<?php

    class Marca implements JsonSerializable{
        
        private $id;
        private $descricao;

        public function getId(){
            return $this->id;
        }

        public function setId($id){
            $this->id = $id;
            return $this;
        }

        public function getDescricao(){
            return $this->descricao;
        }

        public function setDescricao($descricao){
            $this->descricao = $descricao;
            return $this;
        }

        public function jsonSerialize(){
            return get_object_vars($this);
        }

        
    }


?>