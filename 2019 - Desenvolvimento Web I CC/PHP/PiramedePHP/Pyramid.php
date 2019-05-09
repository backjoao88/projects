<?php

    include('Triangle.php');

    class Pyramid extends Triangle{

        // Enum para os tipos
        // Usuário informará os dados: altura, base e tipo da tinta (pode ser pelo construtor)
        // Com esses dados, surgirão as funções: calcularAreaTotal, calcularQuantidadeLitros, 
        // calcularQuantidadeLatas e calcularQuantidadeValorTotal.

        // Classe para operações

        private const METERS_PER_LITER = 4.76;
        private $inkType               = 0;

        public function __construct($height, $basis, $inkType){
            parent::__construct($height, $basis);
            $this->setInkType($inkType);
        }
        
        public function getInkType(){
            return $this->inkType;
        }

        public function setInkType($inkType){
            $this->inkType = $inkType;
        }

        public function toString(){
            return '[Height = '. $this->getHeight(). ', Basis = '. $this->getBasis().', inkType = '. $this->getInkType().']';
        }

    }

    $pyramid = new Pyramid(200,300,1);

    echo $pyramid->toString();

?>