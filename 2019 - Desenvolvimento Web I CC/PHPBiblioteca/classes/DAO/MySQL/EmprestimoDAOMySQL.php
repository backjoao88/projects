<?php

    include('autoload.php');

    class EmprestimoDAOMySQL implements IPersistenciaEmprestimo, IPersistenciaLivrosEmprestimo{


        public function inserir(Emprestimo $emprestimo){
            try{
                $pdo = Conexao::conectar();
                $sql = 'INSERT INTO ' . self::NOME_TABELA_EMPRESTIMO . ' (emprestimo_id, emprestimo_data_entrega, emprestimo_data_devolucao, emprestimo_bibliotecario_id) VALUES(:emprestimo_id,:emprestimo_data_entrega,:emprestimo_data_devolucao,:emprestimo_bibliotecario_id)';
                $stmt = $pdo->prepare($sql);

                $stmt->bindParam(':emprestimo_id', $emprestimo_id, PDO::PARAM_STR);
                $stmt->bindParam(':emprestimo_data_entrega', $emprestimo_data_entrega, PDO::PARAM_STR);
                $stmt->bindParam(':emprestimo_data_devolucao', $emprestimo_data_devolucao, PDO::PARAM_STR);
                $stmt->bindParam(':emprestimo_bibliotecario_id', $emprestimo_bibliotecario_id, PDO::PARAM_STR);

                $emprestimo_id                   = $emprestimo->getEmprestimoId();
                $emprestimo_data_entrega         = $emprestimo->getEmprestimoDataEntrega();
                $emprestimo_data_devolucao       = $emprestimo->getEmprestimoDataDevolucao();
                $emprestimo_bibliotecario_id     = $emprestimo->getEmprestimoBibliotecarioId();

                $stmt->execute();

                foreach($emprestimo->getEmprestimoLivros() as $livro){
                    $this->inserirLivroEmprestimo($emprestimo, $livro);
                }

            }catch (PDOException $e){
                echo 'Erro ao Inserir -> ' . $e->getMessage();
            }finally{
                $pdo = null;
            }    
        }
        
        public function alterar(Emprestimo $emprestimo){
            try{
                $pdo = Conexao::conectar();
                $sql = 'UPDATE ' . self::NOME_TABELA_EMPRESTIMO . ' SET emprestimo_id = :emprestimo_id, emprestimo_data_entrega = :emprestimo_data_entrega, emprestimo_data_devolucao = :emprestimo_data_devolucao, emprestimo_bibliotecario_id = :emprestimo_bibliotecario_id WHERE emprestimo_id = :emprestimo_id;';
                $stmt = $pdo->prepare($sql);

                $stmt->bindParam(':emprestimo_id', $emprestimo_id, PDO::PARAM_STR);
                $stmt->bindParam(':emprestimo_data_entrega', $emprestimo_data_entrega, PDO::PARAM_STR);
                $stmt->bindParam(':emprestimo_data_devolucao', $emprestimo_data_devolucao, PDO::PARAM_STR);
                $stmt->bindParam(':emprestimo_bibliotecario_id', $emprestimo_bibliotecario_id, PDO::PARAM_STR);
                $stmt->bindParam(':emprestimo_id', $emprestimo_id, PDO::PARAM_STR);

                $emprestimo_id                   = $emprestimo->getEmprestimoId();
                $emprestimo_data_entrega         = $emprestimo->getEmprestimoDataEntrega();
                $emprestimo_data_devolucao       = $emprestimo->getEmprestimoDataDevolucao();
                $emprestimo_bibliotecario_id     = $emprestimo->getEmprestimoBibliotecarioId();
                $emprestimo_id                   = $emprestimo->getEmprestimoId();

                $stmt->execute();

                foreach($emprestimo->getEmprestimoLivros() as $livro){
                    $this->alterarLivroEmprestimo($emprestimo, $livro);
                }

               
            }catch (PDOException $e){
                echo 'Erro ao Inserir -> ' . $e->getMessage();
            }finally{
                $pdo = null;
            }    
        }

        public function excluir(Emprestimo $emprestimo){
            try{
                $pdo = Conexao::conectar();
                $sql = 'DELETE FROM ' . self::NOME_TABELA_EMPRESTIMO . ' WHERE emprestimo_id = :emprestimo_id';
                $stmt = $pdo->prepare($sql);
                $stmt->bindParam(':emprestimo_id', $emprestimo_id);
        
                $emprestimo_id          = $emprestimo->getEmprestimoId();

                $stmt->execute();
            }catch (PDOException $e){
                echo 'Erro ao Excluir -> ' . $e->getMessage();
            }finally{
                $pdo = null;
            }
        }

        public function procurarEmprestimoPorId(Emprestimo $emprestimo){

        }

        public function listarEmprestimos(){
            return $this->ler();
        }

        public function inserirLivroEmprestimo(Emprestimo $emprestimo, Livro $livro){

        }
        public function alterarLivroEmprestimo(Emprestimo $emprestimo, Livro $livro){

        }
        public function excluirLivroEmprestimo(Emprestimo $emprestimo, Livro $livro){

        }
        public function procurarLivroEmprestimoPorId(Emprestimo $emprestimo){

        }
        public function listarLivrosEmprestimo(Emprestimo $livro){

        }  
    }
    
?>