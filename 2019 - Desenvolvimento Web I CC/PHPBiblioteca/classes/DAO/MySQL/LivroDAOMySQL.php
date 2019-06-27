<?php

    include('autoload.php');

    class LivroDAOMySQL implements IPersistenciaLivro{


        private const NOME_TABELA = 'livro';

        public function inserir(Livro $livro){
            try{
                $pdo = Conexao::conectar();
                $sql = 'INSERT INTO ' . self::NOME_TABELA . ' (livro_nome, livro_isbn, livro_edicao, livro_data_publicacao, livro_autor) VALUES(:livro_nome, :livro_isbn, :livro_edicao, :livro_data_publicacao, :livro_autor)';
                $stmt = $pdo->prepare($sql);

                $stmt->bindParam(':bibliotecario_nome', $bibliotecario_nome, PDO::PARAM_STR);
                $stmt->bindParam(':bibliotecario_cpf', $bibliotecario_cpf, PDO::PARAM_STR);
                $stmt->bindParam(':bibliotecario_login', $bibliotecario_login, PDO::PARAM_STR);
                $stmt->bindParam(':bibliotecario_senha', $bibliotecario_senha, PDO::PARAM_STR);

                $bibliotecario_nome        = $bibliotecario->getBibliotecarioNome();
                $bibliotecario_cpf         = $bibliotecario->getBibliotecarioCpf();
                $bibliotecario_login       = $bibliotecario->getBibliotecarioLogin();
                $bibliotecario_senha       = $bibliotecario->getBibliotecarioSenha();

                $stmt->execute();

            }catch (PDOException $e){
                echo 'Erro ao Inserir -> ' . $e->getMessage();
            }finally{
                $pdo = null;
            }    
        }
        
        public function alterar(Livro $livro){

        }

        public function excluir(Livro $livro){

        }

        public function procurarLivroPorId(Livro $livro){

        }


    }


?>