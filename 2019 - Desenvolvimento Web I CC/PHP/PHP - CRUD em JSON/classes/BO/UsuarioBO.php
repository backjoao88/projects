<?php

include('autoload.php');

    class UsuarioBO implements IPersistenciaUsuario{

        private $pusuario;

        public function __construct($pusuario){
            $this->pusuario = $pusuario;
        }

        public function inserir(Usuario $usuario){
            $this->pusuario->inserir($usuario);
        }
        
        public function alterar(Usuario $usuario){
            $this->pusuario->alterar($usuario);  
        }

        public function excluir(Usuario $usuario){
            $this->pusuario->excluir($usuario);            
        }

        public function existe(Usuario $usuario){
            $this->pusuario->existe($usuario);            
        }

        public function procurarUsuarioPorId(Usuario $usuario){
            return $this->pusuario->procurarUsuarioPorId($usuario);            
        }

        public function listarUsuarios(){
            return $this->pusuario->listarUsuarios();   
        }

    }

?>