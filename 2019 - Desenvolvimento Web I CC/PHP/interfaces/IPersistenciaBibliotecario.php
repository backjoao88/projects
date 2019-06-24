<?php
    interface IPersistenciaBibliotecario{

        public function inserir(Bibliotecario $bibliotecario);
        public function alterar(Bibliotecario $bibliotecario);
        public function excluir(Bibliotecario $bibliotecario);
        public function existe(Bibliotecario $bibliotecario);
        public function procurarBibliotecarioPorId(Bibliotecario $bibliotecario);
        public function listarBibliotecarios();  

    }
?>