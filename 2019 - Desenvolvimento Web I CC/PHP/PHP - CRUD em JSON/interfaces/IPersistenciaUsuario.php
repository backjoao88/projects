<?php
    interface IPersistenciaUsuario{

        public function inserir(Usuario $usuario);
        public function alterar(Usuario $usuario);
        public function excluir(Usuario $usuario);
        public function listarUsuarios();  

    }
?>