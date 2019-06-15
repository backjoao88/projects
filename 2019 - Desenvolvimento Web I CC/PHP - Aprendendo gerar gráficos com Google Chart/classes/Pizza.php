<?php

    class Pizza extends Grafico{

   
        private $pizzaTamanhoBuraco;
        private $pizzaAnguloDeInicio;

        private const IDENTIFICACAO = 1;
     

        public function getIdentificacao(){
            return self::IDENTIFICACAO;
        }

        public function comOTamanhoDoBuracoDe($pizzaTamanhoBuraco){
            $this->setPizzaTamanhoBuraco($pizzaTamanhoBuraco);
            return $this;
        }

        public function deAnguloDeInicio($pizzaAnguloDeInicio){
            $this->setPizzaAnguloDeInicio($pizzaAnguloDeInicio);
            return $this;
        }

        public function getPizzaTamanhoBuraco(){
            return $this->pizzaTamanhoBuraco;
        }

        public function setPizzaTamanhoBuraco($pizzaTamanhoBuraco){
            $this->pizzaTamanhoBuraco = $pizzaTamanhoBuraco;
        }

        public function getPizzaAnguloDeInicio(){
            return $this->pizzaAnguloDeInicio;
        }

        public function setPizzaAnguloDeInicio($pizzaAnguloDeInicio){
            $this->pizzaAnguloDeInicio = $pizzaAnguloDeInicio;
        }

        public function jsonSerialize(){
            $obj = parent::jsonSerialize();
            $obj["pizzaTamanhoBuraco"] = $this->pizzaTamanhoBuraco;
            $obj["pizzaAnguloDeInicio"] = $this->pizzaAnguloDeInicio;
            $obj["IDENTIFICACAO"] = self::getIdentificacao();
            return $obj;
        }


        public function toString(){
            return parent::toString() . 
                ', [Pizza -> pizzaTamanhoBuraco= '
                . $this->getPizzaTamanhoBuraco(). ', pizzaAnguloDeInicio= ' 
                . $this->getPizzaAnguloDeInicio() . ']';
        }

    }

?>