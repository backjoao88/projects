<?php

    class Emprestimo implements JsonSerializable{

        private $emprestimo_id;
        private $emprestimo_data_entrega;
        private $emprestimo_data_devolucao;
        private $emprestimo_usuario_id;
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

        public function cadastradoComOUsuario($emprestimo_usuario){
            $this->setEmprestimoUsuarioId($emprestimo_usuario);
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

        public function getEmprestimoUsuarioId(){
            return $this->emprestimo_usuario_id;
        }

        public function setEmprestimoUsuarioId($emprestimo_usuario_id){
            $this->emprestimo_usuario_id = $emprestimo_usuario_id;
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


        public function toString(){
            $str = '';
            foreach($this->getEmprestimoLivros() as $livro){
                $str .= '<br>' . $livro->toString();
            }

            return 'Emprestimo -> '     . ', ' . 
                    'ID: '              . $this->getEmprestimoId() . ', ' . 
                    'Data Entrega: '    . $this->getEmprestimoDataEntrega() . ', ' . 
                    'Data Devolucao: '  . $this->getEmprestimoDataDevolucao() . ', ' . 
                    'Usuario ID: '      . $this->getEmprestimoUsuarioId()->toString() . ', ' . 
                    'Livros: '          . $str;
        }

    }

?>