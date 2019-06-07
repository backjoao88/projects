<?php

    include('Usuario.php');

    class Funcionario extends Usuario{

        private $nome;
        private $email;
        private $sexo;
        private $vetorHorasTrabalhadas = [];
        private $vetorValorHora        = [];
        private $dataNascimento;

        public function __construct($login, $senha, $nome, $sexo,  $email, $dataNascimento, $vetorHorasTrabalhadas, $vetorValorHora){
                parent::__construct($login, $senha);
                $this->setNome($nome);
                $this->setEmail($email);
                $this->setDataNascimento($dataNascimento);
                $this->setVetorHorasTrabalhadas($vetorHorasTrabalhadas);
                $this->setVetorValorHora($vetorValorHora);
                $this->setSexo($sexo);
        }


        public function getDataNascimento(){
                return $this->dataNascimento;
        }

        public function setDataNascimento($dataNascimento){
                $this->dataNascimento = $dataNascimento;
        }

        public function getVetorValorHora()
        {
                return $this->vetorValorHora;
        }

        public function setVetorValorHora($vetorValorHora){
                $this->vetorValorHora = $vetorValorHora;
        }

        public function getVetorHorasTrabalhadas(){
                return $this->vetorHorasTrabalhadas;
        }

        public function setVetorHorasTrabalhadas($vetorHorasTrabalhadas){
                $this->vetorHorasTrabalhadas = $vetorHorasTrabalhadas;
        }

        public function getEmail(){
                return $this->email;
        }

        public function setEmail($email){
                $this->email = $email;
        }

        public function getNome(){
                return $this->nome;
        }

        public function setNome($nome){
                $this->nome = $nome;
        }

        public function mediaTodosSalarios(){
                $salarios = [];
                for ($i = 0; $i < $this->numeroMesesTrabalhados(); $i++){
                        $salarios[$i] = $this->calcularSalarioMes($i);
                }
                return array_sum($salarios) / count($salarios);
        }

        public function calcularIdade(){
                $anoDataAtual      = date('Y', strtotime(date('d-m-Y')));
                $anoDataNascimento = date('Y', strtotime($this->getDataNascimento()));

                $mesDataAtual      = date('m', strtotime(date('d-m-Y')));
                $mesDataNascimento = date('m', strtotime($this->getDataNascimento()));
                
                $diaDataAtual      = date('d', strtotime(date('d-m-Y')));
                $diaDataNascimento = date('d', strtotime($this->getDataNascimento()));    

                if($mesDataAtual == $mesDataNascimento){
                        if($diaDataAtual > $diaDataNascimento){
                                return ($anoDataAtual - $anoDataNascimento) - 1;
                        }
                }else{
                        if($mesDataAtual < $mesDataNascimento){
                                return ($anoDataAtual - $anoDataNascimento) - 1;
                        }else{
                                return ($anoDataAtual - $anoDataNascimento); 
                        }
                }
        }

        public function numeroMesesTrabalhados(){
                return sizeof($this->getVetorValorHora());
        }

        public function numeroAnosTrabalhados(){
               return round($this->numeroMesesTrabalhados()/12);
        }

        public function calcularSalarioMes($mes){
                return $this->getVetorHorasTrabalhadas()[$mes] * $this->getVetorValorHora()[$mes];
        }

        public function maioresSalariosAte($n){
                $salarios = [];
                $maioresSalarios = [];
                for ($i = 0; $i < $this->numeroMesesTrabalhados(); $i++){
                        $salarios[$i] = $this->calcularSalarioMes($i);
                }
                rsort($salarios);
                for ($i = 0; $i < $n; $i++){
                        $maioresSalarios[$i] = $salarios[$i];
                }
                return $maioresSalarios;
        }

        public function menoresSalariosAte($n){
                $salarios = [];
                $maioresSalarios = [];
                for ($i = 0; $i < $this->numeroMesesTrabalhados(); $i++){
                        $salarios[$i] = $this->calcularSalarioMes($i);
                }
                sort($salarios);
                for ($i = 0; $i < $n; $i++){
                        $maioresSalarios[$i] = $salarios[$i];
                }
                return $maioresSalarios;
        }

        public function calcularValorTodosSalarios(){
                $somaTodosSalarios = 0;
                for($i = 0; $i < $this->numeroMesesTrabalhados(); $i++){
                        $somaTodosSalarios += $this->calcularSalarioMes($i);
                }
                return $somaTodosSalarios;
        }

        public function toString(){
                return parent::toString() . ' | ' . 'Nome = ' . $this->getNome() . ' | ' . 'Email = ' . $this->getEmail() . ' | ' . 'Vetor Horas Trabalhadas = ' . json_encode($this->getVetorHorasTrabalhadas()) . 
                ' | ' . 'Vetor Valor Hora = ' . json_encode($this->getVetorValorHora()) . ' | ' . 'Data Nascimento =    ' . $this->getDataNascimento(); 
        }

        public function getSexo(){
                return $this->sexo;
        }

        public function setSexo($sexo){
                $this->sexo = $sexo;
        }
    }


?>