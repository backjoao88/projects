<?php

    include('autoload.php');

    class EmprestimoDAO implements IPersistenciaLista, IPersistenciaEmprestimo{


        private $lista_emprestimos;
        private const NOME_ARQUIVO = 'json/emprestimos.json';

        public function inserir(Emprestimo $emprestimo){
           // $this->ler();
            $this->lista_emprestimos[] = $emprestimo;
            $this->gravar();
        }
        
        public function alterar(Emprestimo $emprestimo){
            $this->ler();
            foreach($this->lista_emprestimos as $k => $empArray){
                $emp = (new Emprestimo())->utilizandoOID($empArray['emprestimo_id'])
                                      ->naADataDeEntrega($empArray['emprestimo_data_entrega'])
                                      ->naDataDeDevolucao($empArray['emprestimo_data_devolucao'])
                                      ->cadastradoComOUsuario($empArray['emprestimo_usuario_id'])
                                      ->comAListaDeLivros($empArray['emprestimo_livros']);

                if($emp->getEmprestimoID() === $emprestimo->getEmprestimoID()){
                    $this->lista_emprestimos[$k] = $emprestimo;
                    $this->gravar();
                }  

            } 
        }

        public function excluir(Emprestimo $emprestimo){
            $this->ler();
            foreach($this->lista_emprestimos as $k => $empArray){
                $emp = (new Emprestimo())->utilizandoOID($empArray['emprestimo_id'])
                                      ->naADataDeEntrega($empArray['emprestimo_data_entrega'])
                                      ->naDataDeDevolucao($empArray['emprestimo_data_devolucao'])
                                      ->cadastradoComOUsuario($empArray['emprestimo_usuario_id'])
                                      ->comAListaDeLivros($empArray['emprestimo_livros']);

                if($emp->getEmprestimoID() === $emprestimo->getEmprestimoID()){
                    unset($this->lista_emprestimos[$k]);
                    $this->lista_emprestimos = array_values($this->lista_emprestimos);
                    $this->gravar();
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
            $json_file = file_get_contents(self::NOME_ARQUIVO);  
            $this->lista_emprestimos = json_decode($json_file, true);
            return $this->lista_emprestimos;  
        }

    }


?>