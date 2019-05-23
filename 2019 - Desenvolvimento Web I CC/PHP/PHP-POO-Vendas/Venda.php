<?php


    class Venda{


        private $idVenda;
        private $data;
        private $cliente;
        private $vendedor;
        private $produtos;
        private $dataVencimento;
        private $dataPagamento;

        
        public function getIdVenda(){
            return $this->idVenda;
        }

        public function setIdVenda($idVenda){
            $this->idVenda = $idVenda;
        }

        public function getData(){
            return $this->data;
        }

        public function setData($data){
            $this->data = $data;
        }

        public function getCliente(){
            return $this->cliente;
        }

        public function setCliente($cliente){
            $this->cliente = $cliente;
        }

        public function getVendedor(){
            return $this->vendedor;
        }

        public function setVendedor($vendedor){
            $this->vendedor = $vendedor;
        }

        public function getDataVencimento(){
            return $this->dataVencimento;
        }

        public function setDataVencimento($dataVencimento){
            $this->dataVencimento = $dataVencimento;
        }

        public function getDataPagamento(){
            return $this->dataPagamento;
        }

        public function setDataPagamento($dataPagamento){
            $this->dataPagamento = $dataPagamento;
        }
        
    }


?>