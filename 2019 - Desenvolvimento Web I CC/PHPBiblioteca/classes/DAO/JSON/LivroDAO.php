<?php

    include('autoload.php');

    class LivroDAO implements IPersistenciaLista, IPersistenciaLivro{

        private $lista_livros;
        private const NOME_ARQUIVO = 'json/livros.json';

        public function inserir(Livro $livro){
            if(!$this->existe($livro)){
                $this->ler();
                $this->lista_livros[] = $livro;
                $this->gravar();
            }
        }
        
        public function alterar(Livro $livro){
            $this->ler();
            foreach($this->lista_livros as $k => $liv){
                if($liv->getLivroID() === $livro->getLivroID()){
                    $this->lista_livros[$k] = $livro;
                    $this->gravar();
                }  
            } 
            return false;
        }

        public function excluir(Livro $livro){
            $this->ler();
            foreach($this->lista_livros as $k => $liv){
                if($liv->getLivroID() === $livro->getLivroID()){
                    unset($this->lista_livros[$k]);
                    $this->lista_livros = array_values($this->lista_livros);
                    $this->gravar();
                }                         
            } 
        }

        public function existe(Livro $livro){
            $this->ler();
            foreach($this->lista_livros as $k => $liv){
                if($liv->getLivroID() === $livro->getLivroID()){
                    return true;
                }                         
            } 
        }

        public function procurarLivroPorId(Livro $livro){
            $this->ler();
            foreach($this->lista_livros as $k => $liv){
                if($liv->getLivroID() === $livro->getLivroID()){
                    return $liv;
                }                         
            } 
        }

        public function listarLivros(){
            return $this->ler();
        }

        public function gravar(){
            $fp = fopen(self::NOME_ARQUIVO, 'w');
            $str = json_encode($this->lista_livros);
            fwrite($fp, $str);
            fclose($fp);
        }

        public function ler(){
            $lista_livros_obj = [];
            $json_file = file_get_contents(self::NOME_ARQUIVO);  
            $this->lista_livros = json_decode($json_file, true);
            if ($this->lista_livros){
                foreach($this->lista_livros as $k => $livroArray){
                    $liv = (new Livro())->utilizandoOID($livroArray['livro_id'])
                                        ->comONome($livroArray['livro_nome'])
                                        ->cadastradoComOISBN($livroArray['livro_isbn'])
                                        ->criadoPeloAutor($livroArray['livro_autor'])
                                        ->publicadoEm($livroArray['livro_data_publicacao'])
                                        ->naEdicao($livroArray['livro_edicao']);
                                        
                    $lista_livros_obj[] = $liv;
                } 
            }
            $this->lista_livros = $lista_livros_obj;

            return $this->lista_livros;  
        }
    }


?>