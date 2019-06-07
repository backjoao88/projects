<?php

    include('autoload.php');

    class UsuarioDAO implements IPersistenciaLista, IPersistenciaUsuario{


        private $lista_usuarios    = [];
        private const NOME_ARQUIVO = 'json/usuarios.json';

        public function inserir(Usuario $usuario){
            $this->ler();
            $this->lista_usuarios[] = $usuario;
            $this->gravar();
        }
        
        public function alterar(Usuario $usuario){
            $this->ler();
            foreach($this->lista_usuarios as $k => $usuArray){
                $usu = (new Usuario())->utilizandoOID($usuArray['usuario_id'])
                                      ->cadastradoComOLogin($usuArray['usuario_login'])
                                      ->cadastradoComASenha($usuArray['usuario_senha'])
                                      ->comONome($usuArray['usuario_nome'])
                                      ->utilizandoOCpf($usuArray['usuario_cpf']);
                if($usu->getUsuarioID() === $usuario->getUsuarioID()){
                    $this->lista_usuarios[$k] = $usuario;
                    $this->gravar();
                }                         
            } 
        }

        public function excluir(Usuario $usuario){
            $this->ler();
            foreach($this->lista_usuarios as $k => $usuArray){
                $usu = (new Usuario())->utilizandoOID($usuArray['usuario_id'])
                                      ->cadastradoComOLogin($usuArray['usuario_login'])
                                      ->cadastradoComASenha($usuArray['usuario_senha'])
                                      ->comONome($usuArray['usuario_nome'])
                                      ->utilizandoOCpf($usuArray['usuario_cpf']);
                if($usu->getUsuarioID() === $usuario->getUsuarioID()){
                    unset($this->lista_usuarios[$k]);
                    $this->lista_usuarios = array_values($this->lista_usuarios);
                    $this->gravar();
                }                         
            } 
        }

        public function listarUsuarios(){
            return $this->ler();
        }

        public function gravar(){
            $fp = fopen(self::NOME_ARQUIVO, 'w');
            $str = json_encode($this->lista_usuarios);
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