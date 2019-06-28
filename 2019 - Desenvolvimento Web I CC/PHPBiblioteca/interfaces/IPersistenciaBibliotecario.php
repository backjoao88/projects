<?php
    interface IPersistenciaBibliotecario{

        private const NOME_TABELA_BIBLIOTECARIO = "bibliotecario";

        public function inserir(Bibliotecario $bibliotecario);
        public function alterar(Bibliotecario $bibliotecario);
        public function excluir(Bibliotecario $bibliotecario);
        public function procurarBibliotecarioPorId(Bibliotecario $bibliotecario);
        public function listarBibliotecarios();  

    }
?>