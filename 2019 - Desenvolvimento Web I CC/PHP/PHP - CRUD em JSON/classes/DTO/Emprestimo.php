<?php

    class Emprestimo implements JsonSerializable{

        private $emprestimo_id;
        private $emprestimo_data_entrega;
        private $emprestimo_data_devolucao;
        private $emprestimo_bibliotecario_id;
        private $emprestimo_livros = [];

        public function utilizandoOID($emprestimo_id){
            $this->setEmprestimoId($emprestimo_id);
            return $this;
        }

        public function naADataDeEntrega($emprestimo_data_entrega){
            $this->setEmprestimoDataEntrega($emprestimo_data_entrega);
            return $this;
        }

        public function naDataDeDevolucao($emprestimo_data_devolucao){
            $this->setEmprestimoDataDevolucao($emprestimo_data_devolucao);
            return $this;
        }

        public function cadastradoComOBibliotecario($emprestimo_bibliotecario){
            $this->setEmprestimoBibliotecarioId($emprestimo_bibliotecario);
            return $this;
        }

        public function comAListaDeLivros($emprestimo_livros){
            $this->setEmprestimoLivros($emprestimo_livros);
            return $this;
        }

        public function getEmprestimoId(){
            return $this->emprestimo_id;
        }

        public function setEmprestimoId($emprestimo_id){
            $this->emprestimo_id = $emprestimo_id;
        }

        public function getEmprestimoDataEntrega(){
            return $this->emprestimo_data_entrega;
        }

        public function setEmprestimoDataEntrega($emprestimo_data_entrega){
            $this->emprestimo_data_entrega = $emprestimo_data_entrega;
        }

        public function getEmprestimoDataDevolucao(){
            return $this->emprestimo_data_devolucao;
        }

        public function setEmprestimoDataDevolucao($emprestimo_data_devolucao){
            $this->emprestimo_data_devolucao = $emprestimo_data_devolucao;
        }

        public function getEmprestimoBibliotecarioId(){
            return $this->emprestimo_bibliotecario_id;
        }

        public function setEmprestimoBibliotecarioId($emprestimo_bibliotecario_id){
            $this->emprestimo_bibliotecario_id = $emprestimo_bibliotecario_id;
        }

        public function getEmprestimoLivros(){
            return $this->emprestimo_livros;
        }

        public function setEmprestimoLivros($emprestimo_livros){
            $this->emprestimo_livros = $emprestimo_livros;
        }

        public function jsonSerialize(){
            return get_object_vars($this);
        }

    }

?>