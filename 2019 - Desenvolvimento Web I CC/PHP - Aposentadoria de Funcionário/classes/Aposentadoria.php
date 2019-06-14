<?php

    include('autoload.php');

    class Aposentadoria{

        private const IDADE_MINIMA_APOSENTADORIA_HOMEM = 65;
        private const TEMPO_MINIMO_CONTRIBUICAO_HOMEM = 35;
        private const IDADE_MINIMA_APOSENTADORIA_MULHER = 62;
        private const TEMPO_MINIMO_CONTRIBUICAO_MULHER = 35;
        private $funcionario;

        public function __construct($funcionario){
            $this->funcionario = $funcionario;
        }

        public function calcularAnoQueIraAposentar(){
            if($this->funcionario->getSexo() == 'M'){
                $anoAtual = date('Y');
                $quantidadeSomaAnosIdade = 0;
                $quantidadeSomaAnosContribuicao = 0;
    
                if($this->funcionario->calcularIdade() < self::IDADE_MINIMA_APOSENTADORIA_HOMEM){
                    $quantidadeSomaAnosIdade = self::IDADE_MINIMA_APOSENTADORIA_HOMEM - $this->funcionario->calcularIdade();
                }
    
                if($this->funcionario->numeroAnosTrabalhados() < self::TEMPO_MINIMO_CONTRIBUICAO_HOMEM){
                    $quantidadeSomaAnosContribuicao = self::TEMPO_MINIMO_CONTRIBUICAO_HOMEM - $this->funcionario->numeroAnosTrabalhados();
                }
    
                if($quantidadeSomaAnosIdade > $quantidadeSomaAnosContribuicao){
                    return $anoAtual + $quantidadeSomaAnosIdade;
                }else{
                    return $anoAtual + $quantidadeSomaAnosContribuicao;
                }
            }else{
                if($this->funcionario->getSexo() == 'F'){
                    $anoAtual = date('Y');
                    $quantidadeSomaAnosIdade = 0;
                    $quantidadeSomaAnosContribuicao = 0;
        
                    if($this->funcionario->calcularIdade() < self::IDADE_MINIMA_APOSENTADORIA_MULHER){
                        $quantidadeSomaAnosIdade = self::IDADE_MINIMA_APOSENTADORIA_MULHER - $this->funcionario->calcularIdade();
                    }
        
                    if($this->funcionario->numeroAnosTrabalhados() < self::TEMPO_MINIMO_CONTRIBUICAO_MULHER){
                        $quantidadeSomaAnosContribuicao = self::TEMPO_MINIMO_CONTRIBUICAO_MULHER - $this->funcionario->numeroAnosTrabalhados();
                    }
        
                    if($quantidadeSomaAnosIdade > $quantidadeSomaAnosContribuicao){
                        return $anoAtual + $quantidadeSomaAnosIdade;
                    }else{
                        return $anoAtual + $quantidadeSomaAnosContribuicao;   
                    }
                }
            }
        }

        public function calcularIdadeNaAposentadoria(){
            if($this->funcionario->getSexo() == 'M'){

                $quantidadeSomaAnosIdade = 0;
                $quantidadeSomaAnosContribuicao = 0;
    
                if($this->funcionario->calcularIdade() < self::IDADE_MINIMA_APOSENTADORIA_HOMEM){
                    $quantidadeSomaAnosIdade = self::IDADE_MINIMA_APOSENTADORIA_HOMEM - $this->funcionario->calcularIdade();
                }
    
                if($this->funcionario->numeroAnosTrabalhados() < self::TEMPO_MINIMO_CONTRIBUICAO_HOMEM){
                    $quantidadeSomaAnosContribuicao = self::TEMPO_MINIMO_CONTRIBUICAO_HOMEM - $this->funcionario->numeroAnosTrabalhados();
                }
    
                if($quantidadeSomaAnosIdade > $quantidadeSomaAnosContribuicao){
                    return $this->funcionario->calcularIdade() + $quantidadeSomaAnosIdade;
                }else{
                    return $this->funcionario->calcularIdade() + $quantidadeSomaAnosContribuicao;
                }
    
            }else{
                if($this->funcionario->getSexo() == 'F'){
                    $quantidadeSomaAnosIdade = 0;
                    $quantidadeSomaAnosContribuicao = 0;
        
                    if($this->funcionario->calcularIdade() < self::IDADE_MINIMA_APOSENTADORIA_MULHER){
                        $quantidadeSomaAnosIdade = self::IDADE_MINIMA_APOSENTADORIA_MULHER - $this->funcionario->calcularIdade();
                    }
        
                    if($this->funcionario->numeroAnosTrabalhados() < self::TEMPO_MINIMO_CONTRIBUICAO_MULHER){
                        $quantidadeSomaAnosContribuicao = self::TEMPO_MINIMO_CONTRIBUICAO_MULHER - $this->funcionario->numeroAnosTrabalhados();
                    }
        
                    if($quantidadeSomaAnosIdade > $quantidadeSomaAnosContribuicao){
                        return $this->funcionario->calcularIdade() + $quantidadeSomaAnosIdade;
                    }else{
                        if($quantidadeSomaAnosIdade < $quantidadeSomaAnosContribuicao){
                            return $this->funcionario->calcularIdade() + $quantidadeSomaAnosContribuicao;
                        }else{
                            return $this->funcionario->calcularIdade();
                        }
                    }
                }
            }
        }


    }

?>