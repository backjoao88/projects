<?php

    class Grafico implements JsonSerializable{

        private $titulo;
        private $legenda;
        private $descricaoColuna;
        private $descricaoLinha;
        private $largura;
        private $altura;
        private $valoresX = [];
        private $valoresY = []; 

        public function comOTitulo($titulo){
            $this->setTitulo($titulo);
            return $this;
        }

        public function legendadoCom($legenda){
            $this->setLegenda($legenda);
            return $this;
        }

        public function comAlturaDe($altura){
            $this->setAltura($altura);
            return $this;
        }

        public function comLarguraDe($largura){
            $this->setLargura($largura);
            return $this;
        }
        
        public function utilizandoADescricaoX($descX){
            $this->setDescricaoLinha($descX);
            return $this;
        }

        public function utilizandoADescricaoY($descY){
            $this->setDescricaoColuna($descY);
            return $this;
        }

        public function comOsValoresX($valoresX){
            $this->setValoresX($valoresX);
            return $this;
        }

        public function comOsValoresY($valoresY){
            $this->setValoresY($valoresY);
            return $this;
        }

        public function getTitulo(){
            return $this->titulo;
        }

        public function setTitulo($titulo){
            $this->titulo = $titulo;
        }

        public function getLegenda(){
            return $this->legenda;
        }

        public function setLegenda($legenda){
            $this->legenda = $legenda;
        }
        
        public function getValoresX(){
            return $this->valoresX;
        }

        public function setValoresX($valoresX){
            $this->valoresX = $valoresX;
        }

        public function getLargura(){
            return $this->largura;
        }

        public function setLargura($largura){
            $this->largura = $largura;
        }

        public function getAltura(){
            return $this->altura;
        }

        public function setAltura($altura){
            $this->altura = $altura;
        }
 
        public function getValoresY(){
            return $this->valoresY;
        }

        public function setValoresY($valoresY){
            $this->valoresY = $valoresY;
        }
        
        public function getDescricaoColuna(){
            return $this->descricaoColuna;
        }

        public function setDescricaoColuna($descricaoColuna){
            $this->descricaoColuna = $descricaoColuna;
        }
        
        public function getDescricaoLinha(){
            return $this->descricaoLinha;
        }
 
        public function setDescricaoLinha($descricaoLinha){
            $this->descricaoLinha = $descricaoLinha;
        }

        public function jsonSerialize(){
            return get_object_vars($this);
        }

        public function toString(){

            return '[Grafico -> titulo= ' 
            . $this->getTitulo(). ', legenda= ' 
            . $this->getLegenda() . ', desc_coluna= ' 
            . $this->getDescricaoColuna() . ', desc_linha= '
            . $this->getAltura() . ', altura= ' 
            . $this->getLargura() . ', largura= '
            . $this->getDescricaoLinha() . ', valoresX= '
            . json_encode($this->getValoresX()) . ', valoresY= '
            . json_encode($this->getValoresY()) . ']'; 
           
  
        }
    }

?>