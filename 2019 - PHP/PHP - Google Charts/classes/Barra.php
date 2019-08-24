<?php

    class Barra extends Grafico{


        private $larguraBarra;

        private const IDENTIFICACAO = 2;

        public function getIdentificacao(){
            return self::IDENTIFICACAO;
        }

        public function comALarguraDeBarra($larguraBarra){
            $this->setLarguraBarra($larguraBarra);
            return $this;
        }

        public function getLarguraBarra(){
            return $this->larguraBarra;
        }

        public function setLarguraBarra($larguraBarra){
            $this->larguraBarra = $larguraBarra;
        }

        public function jsonSerialize(){
            $obj = parent::jsonSerialize();
            $obj["larguraBarra"] = $this->larguraBarra;
            $obj["IDENTIFICACAO"] = self::getIdentificacao();
            return $obj;
        }

        public function toString(){
            return parent::toString() . 
                ', [Barra -> larguraBarra= '
                . $this->getLarguraBarra(). ']';
        }

    }

?>