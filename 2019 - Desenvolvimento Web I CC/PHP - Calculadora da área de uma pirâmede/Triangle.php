<?php

abstract class Triangle{

    private $basis    = 0;
    private $height   = 0;

    public function __construct($height, $basis){
        $this->setBasis($basis);
        $this->setHeight($height);
    }

    public function getBasis(){
        return $this->basis;
    }

    public function getHeight(){
        return $this->height;
    }

    public function setHeight($height){
        $this->height = $height;
    }

    public function setBasis($basis){
        $this->basis = $basis;
    }
}


?>