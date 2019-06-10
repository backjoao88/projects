<?php

    include('autoload.php');

    class EmprestimoDAO implements IPersistenciaLista, IPersistenciaEmprestimo{


        private $lista_emprestimos;
        private const NOME_ARQUIVO = 'json/emprestimos.json';

        public function inserir(Emprestimo $emprestimo){
            if(!$this->existe($emprestimo)){
                $this->ler();
                $this->lista_emprestimos[] = $emprestimo;
                $this->gravar();
            }
        }
        
        public function alterar(Emprestimo $emprestimo){
            $this->ler();
            foreach($this->lista_emprestimos as $k => $emp){
                if($emp->getEmprestimoID() === $emprestimo->getEmprestimoID()){
                    $this->lista_emprestimos[$k] = $emprestimo;
                    $this->gravar();
                }  

            } 
        }

        public function excluir(Emprestimo $emprestimo){
            $this->ler();
            foreach($this->lista_emprestimos as $k => $emp){
                if($emp->getEmprestimoID() === $emprestimo->getEmprestimoID()){
                    unset($this->lista_emprestimos[$k]);
                    $this->lista_emprestimos = array_values($this->lista_emprestimos);
                    $this->gravar();
                }                         
            } 
        }

        public function existe(Emprestimo $emprestimo){
            $this->ler();
            foreach($this->lista_emprestimos as $k => $emp){
                if($emp->getEmprestimoID() === $emprestimo->getEmprestimoID()){
                    return true;
                }                         
            } 
            return false;
        }

        public function procurarEmprestimoPorId(Emprestimo $emprestimo){
            $this->ler();
            foreach($this->lista_emprestimos as $k => $emp){
                if($emp->getEmprestimoID() === $emprestimo->getEmprestimoID()){
                    return $emp;
                }                         
            } 
        }

        public function listarEmprestimos(){
            return $this->ler();
        }

        public function gravar(){
            $fp = fopen(self::NOME_ARQUIVO, 'w');
            $str = json_encode($this->lista_emprestimos);
            fwrite($fp, $str);
            fclose($fp);
        }

        public function ler(){

            $lista_emp_obj = [];

            $json_file = file_get_contents(self::NOME_ARQUIVO);  
            $this->lista_emprestimos = json_decode($json_file, true);
            if($this->lista_emprestimos){
                foreach($this->lista_emprestimos as $k => $empArray){
                    $emp = (new Emprestimo())->utilizandoOID($empArray['emprestimo_id'])
                                        ->naADataDeEntrega($empArray['emprestimo_data_entrega'])
                                        ->naDataDeDevolucao($empArray['emprestimo_data_devolucao'])
                                        ->cadastradoComOBibliotecario($empArray['emprestimo_bibliotecario_id'])
                                        ->comAListaDeLivros($empArray['emprestimo_livros']);
                    $lista_emp_obj[] = $emp;                  
                } 
            }

            $this->lista_emprestimos = $lista_emp_obj;

            return $this->lista_emprestimos;  
        }

    }


?>