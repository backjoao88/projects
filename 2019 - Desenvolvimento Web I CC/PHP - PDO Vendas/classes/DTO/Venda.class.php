<?php

    class Venda implements JsonSerializable{

        private $idVenda;
        private $data;
        private $cliente;
        private $vendedor;
        private $produtos = [];
        private $dataVencimento;
        private $dataPagamento;

        
        /**
         * Get the value of idVenda
         */ 
        public function getIdVenda()
        {
                return $this->idVenda;
        }

        /**
         * Set the value of idVenda
         *
         * @return  self
         */ 
        public function setIdVenda($idVenda)
        {
                $this->idVenda = $idVenda;

                return $this;
        }

        /**
         * Get the value of data
         */ 
        public function getData()
        {
                return $this->data;
        }

        /**
         * Set the value of data
         *
         * @return  self
         */ 
        public function setData($data)
        {
                $this->data = $data;

                return $this;
        }

        /**
         * Get the value of cliente
         */ 
        public function getCliente()
        {
                return $this->cliente;
        }

        /**
         * Set the value of cliente
         *
         * @return  self
         */ 
        public function setCliente($cliente)
        {
                $this->cliente = $cliente;

                return $this;
        }

        /**
         * Get the value of vendedor
         */ 
        public function getVendedor()
        {
                return $this->vendedor;
        }

        /**
         * Set the value of vendedor
         *
         * @return  self
         */ 
        public function setVendedor($vendedor)
        {
                $this->vendedor = $vendedor;

                return $this;
        }

        /**
         * Get the value of produtos
         */ 
        public function getProdutos()
        {
                return $this->produtos;
        }

        /**
         * Set the value of produtos
         *
         * @return  self
         */ 
        public function setProdutos($produtos)
        {
                $this->produtos = $produtos;

                return $this;
        }

        /**
         * Get the value of dataVencimento
         */ 
        public function getDataVencimento()
        {
                return $this->dataVencimento;
        }

        /**
         * Set the value of dataVencimento
         *
         * @return  self
         */ 
        public function setDataVencimento($dataVencimento)
        {
                $this->dataVencimento = $dataVencimento;

                return $this;
        }

        /**
         * Get the value of dataPagamento
         */ 
        public function getDataPagamento()
        {
                return $this->dataPagamento;
        }

        /**
         * Set the value of dataPagamento
         *
         * @return  self
         */ 
        public function setDataPagamento($dataPagamento)
        {
                $this->dataPagamento = $dataPagamento;

                return $this;
        }

        public function jsonSerialize(){
                return get_object_vars($this);
        }

    }


?>