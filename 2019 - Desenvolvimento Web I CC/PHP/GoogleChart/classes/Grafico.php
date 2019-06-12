<?php

    class Grafico{

        private $titulo;
        private $legenda;
        private $desc_coluna;
        private $desc_linha;
        private $valoresX;
        private $valoresY;

        public function comOTitulo($titulo){
            $this->setTitulo($titulo);
            return $this;
        }

        public function legendadoCom($legenda){
            $this->setLegenda($legenda);
            return $this;
        }
        
        public function utilizandoADescricaoX($descX){
            $this->setDesc_linha($descX);
            return $this;
        }

        public function utilizandoADescricaoY($descY){
            $this->setDesc_coluna($descY);
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

        public function getDesc_coluna(){
            return $this->desc_coluna;
        }

        public function setDesc_coluna($desc_coluna){
            $this->desc_coluna = $desc_coluna;
        }

        public function getDesc_linha(){
            return $this->desc_linha;
        }

        public function setDesc_linha($desc_linha){
            $this->desc_linha = $desc_linha;
        }

        public function getValoresX(){
            return $this->valoresX;
        }

        public function setValoresX($valoresX){
            $this->valoresX = $valoresX;
        }
 
        public function getValoresY(){
            return $this->valoresY;
        }

        public function setValoresY($valoresY){
            $this->valoresY = $valoresY;
        }

        public function toString(){

            return '[Grafico -> titulo= ' 
            . $this->getTitulo(). ', legenda= ' 
            . $this->getLegenda() . ', desc_coluna= ' 
            . $this->getDesc_coluna() . ', desc_linha= '
            . $this->getDesc_linha() . ', valoresX= '
            . json_encode($this->getValoresX()) . ', valoresY= '
            . json_encode($this->getValoresY()) . ']'; 
           
  
        }

    }

?>