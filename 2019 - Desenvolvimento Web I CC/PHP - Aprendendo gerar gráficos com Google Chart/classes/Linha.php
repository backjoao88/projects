<?php

    class Linha extends Grafico{
        
        private $tipoCurva;

        private const IDENTIFICACAO = 3;

        public function getIdentificacao(){
            return self::IDENTIFICACAO;
        }

        public function comOTipoDeCurva($tipoCurva){
            $this->setTipoCurva($tipoCurva);
            return $this;
        }

        public function getTipoCurva(){
            return $this->tipoCurva;
        }

        public function setTipoCurva($tipoCurva){
            $this->tipoCurva = $tipoCurva;
        }

        public function jsonSerialize(){
            $obj = parent::jsonSerialize();
            $obj["tipoCurva"] = $this->tipoCurva;
            $obj["IDENTIFICACAO"] = self::getIdentificacao();
            return $obj;
        }


        public function toString(){
            return parent::toString() . 
                ', [Linha -> tipoCurva= '
                . $this->getTipoCurva(). ']';
        }

    }

?>