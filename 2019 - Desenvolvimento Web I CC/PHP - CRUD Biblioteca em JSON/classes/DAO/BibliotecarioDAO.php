<?php

    include('autoload.php');

    class BibliotecarioDAO implements IPersistenciaLista, IPersistenciaBibliotecario{


        private $lista_bibliotecario    = [];
        private const NOME_ARQUIVO = 'json/bibliotecario.json';

        public function inserir(Bibliotecario $bibliotecario){
            if(!$this->existe($bibliotecario)){
                $this->ler();
                $this->lista_bibliotecario[] = $bibliotecario;
                $this->gravar();
            }
        }
        public function alterar(Bibliotecario $bibliotecario){
            $this->ler();
            foreach($this->lista_bibliotecario as $k => $bib){
                if($bib->getBibliotecarioId() === $bibliotecario->getBibliotecarioId()){
                    $this->lista_bibliotecario[$k] = $bibliotecario;
                    $this->gravar();
                }                         
            } 
        }

        public function excluir(Bibliotecario $bibliotecario){
            $this->ler();
            foreach($this->lista_bibliotecario as $k => $bib){
                if($bib->getBibliotecarioId() === $bibliotecario->getBibliotecarioId()){
                    unset($this->lista_bibliotecario[$k]);
                    $this->lista_bibliotecario = array_values($this->lista_bibliotecario);
                    $this->gravar();
                }                         
            } 
        }

        public function existe(Bibliotecario $bibliotecario){
            $this->ler();
            foreach($this->lista_bibliotecario as $k => $bib){
                if($bib->getBibliotecarioId() === $bibliotecario->getBibliotecarioId()){
                    return true;
                }                         
            }     
            return false;
        }



        public function listarBibliotecarios(){
            return $this->ler();
        }

        public function gravar(){
            $fp = fopen(self::NOME_ARQUIVO, 'w');
            $str = json_encode($this->lista_bibliotecario);
            fwrite($fp, $str);
            fclose($fp);
        }

        public function procurarBibliotecarioPorId(Bibliotecario $bibliotecario){
            $this->ler();
             foreach($this->lista_bibliotecario as $k => $bib){
                 if($bib->getBibliotecarioId() === $bibliotecario->getBibliotecarioId()){
                     json_encode($bib);
                     return $bib;
                 }                         
             }     
        }

        public function ler(){
            $lista_bibliotecario_obj = [];
            $json_file = file_get_contents(self::NOME_ARQUIVO);  
            $this->lista_bibliotecario = json_decode($json_file, true);
            
            if ($this->lista_bibliotecario){
                foreach($this->lista_bibliotecario as $k => $bibArray){
                    $bib = (new Bibliotecario())->utilizandoOID($bibArray['bibliotecario_id'])
                                        ->comONome($bibArray['bibliotecario_nome'])
                                        ->utilizandoOCpf($bibArray['bibliotecario_cpf']);
                    $lista_bibliotecario_obj[] = $bib;      
                } 
            }

            $this->lista_bibliotecario = $lista_bibliotecario_obj;

            return $this->lista_bibliotecario;  
        }

    }


?>