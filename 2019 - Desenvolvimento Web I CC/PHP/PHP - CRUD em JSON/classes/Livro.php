<?php

    class Livro{

        private $livro_id;
        private $livro_nome;
        private $livro_isbn;
        private $livro_edicao;
        private $livro_data_publicacao;
        private $livro_autor;

        public function utilizandoOID($livro_id){
            $this->setLivroId($livro_id);
            return $this;
        }

        public function comONome($livro_nome){
            $this->setLivroNome($livro_nome);
            return $this;
        }

        public function cadastradoComOISBN($livro_isbn){
            $this->setLivroIsbn($livro_isbn);
            return $this;
        }

        public function naEdicao($livro_edicao){
            $this->setLivroEdicao($livro_edicao);
            return $this;
        }

        public function publicadoEm($livro_data_publicacao){
            $this->setLivroDataPublicacao($livro_data_publicacao);
            return $this;
        }

        public function criadoPeloAutor($livro_autor){
            $this->setLivroAutor($livro_autor);
            return $this;
        }

        public function getLivroId(){
            return $this->livro_id;
        }
 
        public function setLivroId($livro_id){
            $this->livro_id = $livro_id;
        }

        public function getLivroNome(){
            return $this->livro_nome;
        }

        public function setLivroNome($livro_nome){
            $this->livro_nome = $livro_nome;
        }

        public function getLivroIsbn(){
            return $this->livro_isbn;
        }

        public function setLivroIsbn($livro_isbn){
            $this->livro_isbn = $livro_isbn;
        }

        public function getLivroEdicao(){
            return $this->livro_edicao;
        }

        public function setLivroEdicao($livro_edicao){
            $this->livro_edicao = $livro_edicao;
        }

        public function getLivroDataPublicacao(){
            return $this->livro_data_publicacao;
        }

        public function setLivroDataPublicacao($livro_data_publicacao){
            $this->livro_data_publicacao = $livro_data_publicacao;
        }

        public function getLivroAutor(){
            return $this->livro_autor;
        }

        public function setLivroAutor($livro_autor){
            $this->livro_autor = $livro_autor;
        }

        public function toString(){
            return 'Livro -> '  . 
                    'Nome: '            . $this->getLivroNome() . ', ' . 
                    'ISBN: '            . $this->getLivroIsbn() . ', ' . 
                    'Edicao: '          . $this->getLivroEdicao() . ', ' . 
                    'Data Publicacao: ' . $this->getLivroDataPublicacao() . ', ' . 
                    'Autor: '           . $this->getLivroAutor(); 
                    
        }

    }

?>