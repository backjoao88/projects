<?php

    include('autoload.php');

    class UsuarioDAO implements IPersistenciaLista, IPersistenciaUsuario{


        public $lista_usuarios = [];

        private const NOME_ARQUIVO = 'usuariosfile.json';

        public function inserir(Usuario $usuario){
            $this->ler();
            $this->lista_usuarios[] = $usuario;
            $this->gravar();
        }
        
        public function alterar(Usuario $usuario){
            $this->ler();

            echo json_encode($this->lista_usuarios);
            foreach($this->lista_usuarios as $k => $usu){
                echo $this->usu->getUsuarioId();
            }  
        }

        public function excluir(Usuario $usuario){
            
        }

        public function listarUsuarios(){
            return $this->ler();
        }

        public function gravar(){

            $fp = fopen(self::NOME_ARQUIVO, 'w');
            $str = json_encode($this->lista_usuarios);
            echo $str;
            fwrite($fp, $str);
            fclose($fp);
        }

        public function ler(){
            $json_file = file_get_contents(self::NOME_ARQUIVO);  
            $this->lista_usuarios = json_decode($json_file, true);
            return $this->lista_usuarios;  
        }

    }


?>