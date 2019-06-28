<?php

    include('autoload.php');

    class LivroDAOMySQL implements IPersistenciaLivro{

        public function inserir(Livro $livro){
            try{
                $pdo = Conexao::conectar();
                $sql = 'INSERT INTO ' . self::NOME_TABELA . ' (livro_nome, livro_isbn, livro_edicao, livro_data_publicacao, livro_autor) VALUES(:livro_nome, :livro_isbn, :livro_edicao, :livro_data_publicacao, :livro_autor)';
                $stmt = $pdo->prepare($sql);

                $stmt->bindParam(':livro_nome', $livro_nome, PDO::PARAM_STR);
                $stmt->bindParam(':livro_isbn', $livro_isbn, PDO::PARAM_STR);
                $stmt->bindParam(':livro_edicao', $livro_edicao, PDO::PARAM_STR);
                $stmt->bindParam(':livro_data_publicacao', $livro_data_publicacao, PDO::PARAM_STR);
                $stmt->bindParam(':livro_autor', $livro_autor, PDO::PARAM_STR);


                $livro_nome             = $livro->getLivroNome();
                $livro_isbn             = $livro->getLivroIsbn();
                $livro_edicao           = $livro->getLivroEdicao();
                $livro_data_publicacao  = $livro->getLivroDataPublicacao();
                $livro_autor            = $livro->getLivroAutor();

                $stmt->execute();

            }catch (PDOException $e){
                echo 'Erro ao Inserir -> ' . $e->getMessage();
            }finally{
                $pdo = null;
            }    
        }
        
        public function alterar(Livro $livro){
            try{
                $pdo = Conexao::conectar();
                $sql = 'UPDATE ' . self::NOME_TABELA . ' SET livro_nome = :livro_nome, livro_isbn = :livro_isbn, livro_edicao = :livro_edicao, livro_data_publicacao = :livro_data_publicacao, livro_autor = :livro_autor WHERE livro_id = :livro_id;';
                $stmt = $pdo->prepare($sql);

                $stmt->bindParam(':livro_nome', $livro_nome, PDO::PARAM_STR);
                $stmt->bindParam(':livro_isbn', $livro_isbn, PDO::PARAM_STR);
                $stmt->bindParam(':livro_edicao', $livro_edicao, PDO::PARAM_STR);
                $stmt->bindParam(':livro_data_publicacao', $livro_data_publicacao, PDO::PARAM_STR);
                $stmt->bindParam(':livro_autor', $livro_autor, PDO::PARAM_STR);
                $stmt->bindParam(':livro_id', $livro_id, PDO::PARAM_STR);

                $livro_nome             = $livro->getLivroNome();
                $livro_isbn             = $livro->getLivroIsbn();
                $livro_edicao           = $livro->getLivroEdicao();
                $livro_data_publicacao  = $livro->getLivroDataPublicacao();
                $livro_autor            = $livro->getLivroAutor();
                $livro_id               = $livro->getLivroId();

                $stmt->execute();

            }catch (PDOException $e){
                echo 'Erro ao Inserir -> ' . $e->getMessage();
            }finally{
                $pdo = null;
            }    
        }

        public function excluir(Livro $livro){
            try{
                $pdo = Conexao::conectar();
                $sql = 'DELETE FROM ' . self::NOME_TABELA . ' WHERE livro_id = :livro_id';
                $stmt = $pdo->prepare($sql);
                $stmt->bindParam(':livro_id', $livro_id);
        
                $livro_id          = $livro->getLivroId();

                $stmt->execute();
            }catch (PDOException $e){
                echo 'Erro ao Excluir -> ' . $e->getMessage();
            }finally{
                $pdo = null;
            }
        }

        public function procurarLivroPorId(Livro $livro){
            try{
                $pdo        = Conexao::conectar();
                $sql        = 'SELECT * FROM ' . NOME_TABELA . ' WHERE livro_id = :livro_id';
                $query      = $pdo->query($sql);
                $stmt = $pdo->prepare($sql);
                $stmt->bindParam(':livro_id', $livro_id);
        
                $livro_id          = $livro->getLivroId();
                $stmt->execute();

                $livros = $stmt->fetchAll(PDO::FETCH_ASSOC);

                $lista_bibs = [];

                foreach($livros as $k => $liv){
                    $livro = (new Livro())->setLivroId($liv['livro_id'])
                                                          ->setLivroIsbn($liv['livro_isbn'])
                                                          ->setLivroEdicao($liv['livro_edicao'])
                                                          ->setLivroDataPublicacao($liv['livro_data_publicacao'])
                                                          ->setLivroAutor($liv['livro_autor']);
                    $lista_bibs[] = $livro;
                } 
                return $lista_bibs;
            }catch (PDOException $e){
                echo 'Erro ao Listar -> ' . $e->getMessage();
            }finally{
                $pdo = null;
            }
        }

        
        public function listarLivros(){
            try{
                $pdo        = Conexao::conectar();
                $sql        = 'SELECT * FROM ' . NOME_TABELA;
                $query      = $pdo->query($sql);
                $livros   = $query->fetchAll(PDO::FETCH_ASSOC);

                $lista_bibs = [];

                foreach($livros as $k => $liv){
                    $livro = (new Livro())->setLivroId($liv['livro_id'])
                                                          ->setLivroIsbn($liv['livro_isbn'])
                                                          ->setLivroEdicao($liv['livro_edicao'])
                                                          ->setLivroDataPublicacao($liv['livro_data_publicacao'])
                                                          ->setLivroAutor($liv['livro_autor']);
                    $lista_bibs[] = $livro;
                } 
                return $lista_bibs;
            }catch (PDOException $e){
                echo 'Erro ao Listar -> ' . $e->getMessage();
            }finally{
                $pdo = null;
            }
        }



    }


?>