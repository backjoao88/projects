<?php

    class Bibliotecario implements JsonSerializable{
        
        private $bibliotecario_id;
        private $bibliotecario_nome;
        private $bibliotecario_cpf;

        public function utilizandoOID($bibliotecario_id){
            $this->setBibliotecarioId($bibliotecario_id);
            return $this;
        }

        public function comONome($bibliotecario_nome){
            $this->setBibliotecarioNome($bibliotecario_nome);
            return $this;
        }

        public function utilizandoOCpf($bibliotecario_cpf){
            $this->setBibliotecarioCpf($bibliotecario_cpf);
            return $this;
        }

        public function getBibliotecarioId(){
            return $this->bibliotecario_id;
        }

        public function setBibliotecarioId($bibliotecario_id){
            $this->bibliotecario_id = $bibliotecario_id;
        }

        public function getBibliotecarioNome(){
            return $this->bibliotecario_nome;
        }

        public function setBibliotecarioNome($bibliotecario_nome){
            $this->bibliotecario_nome = $bibliotecario_nome;
        }

        public function getBibliotecarioCpf(){
                return $this->bibliotecario_cpf;
        }

        public function setBibliotecarioCpf($bibliotecario_cpf){
                $this->bibliotecario_cpf = $bibliotecario_cpf;
        }

        public function jsonSerialize(){
            return get_object_vars($this);
        }

        public function toString(){
            return 'Bibliotecario -> ' .   
                    'ID: ' . $this->getBibliotecarioId() . ', ' . 
                    'Nome: ' . $this->getBibliotecarioNome() . ', ' . 
                    'CPF: ' . $this->getBibliotecarioCpf();          
        }



    }


?>