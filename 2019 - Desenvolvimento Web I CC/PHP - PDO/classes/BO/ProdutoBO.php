<?php

    include('autoload.php');

    class ProdutoBO implements IPersistenciaProduto{

        private $pproduto;

        public function __construct($pproduto){
            $this->pproduto = $pproduto;
        }

        public function inserir(Produto $produto){
            $this->pproduto->inserir($produto);
        }
        
        public function alterar(Produto $produto){
            $this->pproduto->alterar($produto);
            
        }

        public function excluir(Produto $produto){
            $this->pproduto->excluir($produto);            
        }

        public function listarProdutosPorDescricao(Produto $produto){
            return $this->pproduto->listarProdutosPorDescricao($produto);            
        }

        public function listarProdutoPorCodigo(Produto $produto){
            return $this->pproduto->listarProdutoPorCodigo($produto);  
        }

        public function listarProdutos(){
            return $this->pproduto->listarProdutos();   
        }

    }

?>