<?php

    class Livro implements JsonSerializable{

        private $livro_id;
        private $livro_nome;
        private $livro_isbn;
        private $livro_edicao;
        private $livro_data_publicacao;
        private $livro_autor;

        

        
        public function jsonSerialize(){
            return get_object_vars($this);
        }

        public function toString(){
            return 'Livro -> '  . 
                    'Nome: '            . $this->getLivroNome() . ', ' . 
                    'ISBN: '            . $this->getLivroIsbn() . ', ' . 
                    'Edicao: '          . $this->getLivroEdicao() . ', ' . 
                    'Data Publicacao: ' . $this->getLivroDataPublicacao() . ', ' . 
                    'Autor: '           . $this->getLivroAutor(); 
                    
        }


        /**
         * Get the value of livro_id
         */ 
        public function getLivroId()
        {
                return $this->livro_id;
        }

        /**
         * Set the value of livro_id
         *
         * @return  self
         */ 
        public function setLivroId($livro_id)
        {
                $this->livro_id = $livro_id;

                return $this;
        }

        /**
         * Get the value of livro_nome
         */ 
        public function getLivroNome()
        {
                return $this->livro_nome;
        }

        /**
         * Set the value of livro_nome
         *
         * @return  self
         */ 
        public function setLivroNome($livro_nome)
        {
                $this->livro_nome = $livro_nome;

                return $this;
        }

        /**
         * Get the value of livro_isbn
         */ 
        public function getLivroIsbn()
        {
                return $this->livro_isbn;
        }

        /**
         * Set the value of livro_isbn
         *
         * @return  self
         */ 
        public function setLivroIsbn($livro_isbn)
        {
                $this->livro_isbn = $livro_isbn;

                return $this;
        }

        /**
         * Get the value of livro_edicao
         */ 
        public function getLivroEdicao()
        {
                return $this->livro_edicao;
        }

        /**
         * Set the value of livro_edicao
         *
         * @return  self
         */ 
        public function setLivroEdicao($livro_edicao)
        {
                $this->livro_edicao = $livro_edicao;

                return $this;
        }

        /**
         * Get the value of livro_data_publicacao
         */ 
        public function getLivroDataPublicacao()
        {
                return $this->livro_data_publicacao;
        }

        /**
         * Set the value of livro_data_publicacao
         *
         * @return  self
         */ 
        public function setLivroDataPublicacao($livro_data_publicacao)
        {
                $this->livro_data_publicacao = $livro_data_publicacao;

                return $this;
        }

        /**
         * Get the value of livro_autor
         */ 
        public function getLivroAutor()
        {
                return $this->livro_autor;
        }

        /**
         * Set the value of livro_autor
         *
         * @return  self
         */ 
        public function setLivroAutor($livro_autor)
        {
                $this->livro_autor = $livro_autor;

                return $this;
        }
    }

?>