<?php

    class Emprestimo implements JsonSerializable{

        private $emprestimo_id;
        private $emprestimo_data_entrega;
        private $emprestimo_data_devolucao;
        private $emprestimo_bibliotecario_id;
        private $emprestimo_livros = [];

        /**
         * Get the value of emprestimo_id
         */ 
        public function getEmprestimoId()
        {
                return $this->emprestimo_id;
        }

        /**
         * Set the value of emprestimo_id
         *
         * @return  self
         */ 
        public function setEmprestimoId($emprestimo_id)
        {
                $this->emprestimo_id = $emprestimo_id;

                return $this;
        }

        /**
         * Get the value of emprestimo_data_entrega
         */ 
        public function getEmprestimoDataEntrega()
        {
                return $this->emprestimo_data_entrega;
        }

        /**
         * Set the value of emprestimo_data_entrega
         *
         * @return  self
         */ 
        public function setEmprestimoDataEntrega($emprestimo_data_entrega)
        {
                $this->emprestimo_data_entrega = $emprestimo_data_entrega;

                return $this;
        }

        /**
         * Get the value of emprestimo_data_devolucao
         */ 
        public function getEmprestimoDataDevolucao()
        {
                return $this->emprestimo_data_devolucao;
        }

        /**
         * Set the value of emprestimo_data_devolucao
         *
         * @return  self
         */ 
        public function setEmprestimoDataDevolucao($emprestimo_data_devolucao)
        {
                $this->emprestimo_data_devolucao = $emprestimo_data_devolucao;

                return $this;
        }

        /**
         * Get the value of emprestimo_bibliotecario_id
         */ 
        public function getEmprestimoBibliotecarioId()
        {
                return $this->emprestimo_bibliotecario_id;
        }

        /**
         * Set the value of emprestimo_bibliotecario_id
         *
         * @return  self
         */ 
        public function setEmprestimoBibliotecarioId($emprestimo_bibliotecario_id)
        {
                $this->emprestimo_bibliotecario_id = $emprestimo_bibliotecario_id;

                return $this;
        }

        /**
         * Get the value of emprestimo_livros
         */ 
        public function getEmprestimoLivros()
        {
                return $this->emprestimo_livros;
        }

        /**
         * Set the value of emprestimo_livros
         *
         * @return  self
         */ 
        public function setEmprestimoLivros($emprestimo_livros)
        {
                $this->emprestimo_livros = $emprestimo_livros;

                return $this;
        }

        
        public function jsonSerialize(){
            return get_object_vars($this);
        }


    }

?>