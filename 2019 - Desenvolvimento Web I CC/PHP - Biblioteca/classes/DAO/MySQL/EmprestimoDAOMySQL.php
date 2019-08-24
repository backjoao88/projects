<?php

    include('autoload.php');

    class EmprestimoDAOMySQL implements IPersistenciaEmprestimo, IPersistenciaLivroEmprestimo{


        public function inserir(Emprestimo $emprestimo){

            $pdo = Conexao::iniciarTransacao();

            try{
                $sql = 'INSERT INTO ' . self::NOME_TABELA_EMPRESTIMO . '(emprestimo_data_entrega, emprestimo_data_devolucao, emprestimo_bibliotecario_id) VALUES(:emprestimo_data_entrega, :emprestimo_data_devolucao, :emprestimo_bibliotecario_id)';
                $stmt = $pdo->prepare($sql);

                $stmt->bindParam(':emprestimo_data_entrega', $emprestimo_data_entrega, PDO::PARAM_STR);
                $stmt->bindParam(':emprestimo_data_devolucao', $emprestimo_data_devolucao, PDO::PARAM_STR);
                $stmt->bindParam(':emprestimo_bibliotecario_id', $emprestimo_bibliotecario_id, PDO::PARAM_STR);

                $emprestimo_data_entrega       = $emprestimo->getEmprestimoDataEntrega();
                $emprestimo_data_devolucao     = $emprestimo->getEmprestimoDataDevolucao();
                $emprestimo_bibliotecario_id   = $emprestimo->getEmprestimoBibliotecarioId()->getBibliotecarioId();

                $stmt->execute();

                
                foreach($emprestimo->getEmprestimoLivros() as $livro){
                    $this->inserirLivroEmprestimo($this->procurarUltimoEmprestimo(), $livro);
                }

                $pdo->commit();

            }catch (PDOException $e){
                echo 'Erro ao Inserir -> ' . $e->getMessage();
                $pdo->rollback();
            }finally{
                $pdo = null;
            }    
        }
        
        public function alterar(Emprestimo $emprestimo){

            $pdo = Conexao::iniciarTransacao();

            try{
                $sql = 'UPDATE ' . self::NOME_TABELA_EMPRESTIMO . ' SET emprestimo_data_entrega = :emprestimo_data_entrega, emprestimo_data_devolucao = :emprestimo_data_devolucao, emprestimo_bibliotecario_id = :emprestimo_bibliotecario_id WHERE emprestimo_id = :emprestimo_id;';
                $stmt = $pdo->prepare($sql);

                $stmt->bindParam(':emprestimo_data_entrega', $emprestimo_data_entrega, PDO::PARAM_STR);
                $stmt->bindParam(':emprestimo_data_devolucao', $emprestimo_data_devolucao, PDO::PARAM_STR);
                $stmt->bindParam(':emprestimo_bibliotecario_id', $emprestimo_bibliotecario_id, PDO::PARAM_STR);
                $stmt->bindParam(':emprestimo_id', $emprestimo_id, PDO::PARAM_STR);

                $emprestimo_data_entrega       = $emprestimo->getEmprestimoDataEntrega();
                $emprestimo_data_devolucao     = $emprestimo->getEmprestimoDataDevolucao();
                $emprestimo_bibliotecario_id   = $emprestimo->getEmprestimoBibliotecarioId()->getBibliotecarioId();
                $emprestimo_id                 = $emprestimo->getEmprestimoId();
                
                $stmt->execute();
                
                $this->deletarTodosLivrosDoEmprestimo($emprestimo);

                foreach($emprestimo->getEmprestimoLivros() as $livro){
                    $this->inserirLivroEmprestimo($emprestimo, $livro);
                }

                $pdo->commit();

            }catch (PDOException $e){
                echo 'Erro ao Alterar -> ' . $e->getMessage();
                $pdo->rollback();
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
        
                $emprestimo_id = $emprestimo->getEmprestimoId();
                
                foreach($emprestimo->getEmprestimoLivros() as $livro){
                    $this->excluirLivroEmprestimo($emprestimo, $livro);
                }

                $stmt->execute();
            }catch (PDOException $e){
                echo 'Erro ao Excluir -> ' . $e->getMessage();
            }finally{
                $pdo = null;
            }
        }

        public function procurarEmprestimoPorId(Emprestimo $emprestimo){
            try{
                $pdo = Conexao::conectar();
                $sql = 'DELETE FROM ' . self::NOME_TABELA_EMPRESTIMO . ' WHERE emprestimo_id = :emprestimo_id';
                $stmt = $pdo->prepare($sql);
                $stmt->bindParam(':emprestimo_id', $emprestimo_id);
        
                $emprestimo_id = $emprestimo_id->getEmprestimoId();

                $stmt->execute();
            }catch (PDOException $e){
                echo 'Erro ao Excluir -> ' . $e->getMessage();
            }finally{
                $pdo = null;
            }
        }

        public function listarEmprestimos(){
            try{
                $pdo        = Conexao::conectar();
                $sql        = 'SELECT * FROM ' . self::NOME_TABELA_EMPRESTIMO . ';';

                $query      = $pdo->query($sql);

                $emprestimos = $query->fetchAll(PDO::FETCH_ASSOC);

                $lista_emprestimo = [];

                $bibliotecarioDAO = new BibliotecarioDAOMySQL();
                $bibliotecarioBO = new BibliotecarioBO($bibliotecarioDAO);

                foreach($emprestimos as $k => $emp){
                    
                    $emprestimo_id    = (new Emprestimo())->setEmprestimoId($emp['emprestimo_id']);
                    $bibliotecario_id = $bibliotecarioBO->procurarBibliotecarioPorId((new Bibliotecario())->setBibliotecarioId($emp['emprestimo_bibliotecario_id']));

                    $emprestimo = (new Emprestimo())->setEmprestimoId($emp['emprestimo_id'])
                                            ->setEmprestimoDataEntrega($emp['emprestimo_data_entrega'])
                                            ->setEmprestimoDataDevolucao($emp['emprestimo_data_devolucao'])
                                            ->setEmprestimoBibliotecarioId($bibliotecario_id)
                                            ->setEmprestimoLivros($this->listarLivrosDoEmprestimo($emprestimo_id));
                    $lista_emprestimo[] = $emprestimo;
                } 
                
                return $lista_emprestimo;
            }catch (PDOException $e){
                echo 'Erro ao Listar -> ' . $e->getMessage();
            }finally{
                $pdo = null;
            }
        }

        public function inserirLivroEmprestimo(Emprestimo $emprestimo, Livro $livro){

            $pdo = Conexao::conectar();

            $sql = 'INSERT INTO ' . self::NOME_TABELA_LIVRO_EMPRESTIMO . ' (livro_emprestimo_livro_id, livro_emprestimo_emprestimo_id) VALUES(:livro_emprestimo_livro_id, :livro_emprestimo_emprestimo_id)';
            $stmt = $pdo->prepare($sql);

            $stmt->bindParam(':livro_emprestimo_livro_id', $livro_emprestimo_livro_id, PDO::PARAM_STR);
            $stmt->bindParam(':livro_emprestimo_emprestimo_id', $livro_emprestimo_emprestimo_id, PDO::PARAM_STR);

            $livro_emprestimo_livro_id          = $livro->getLivroId();
            $livro_emprestimo_emprestimo_id     = $emprestimo->getEmprestimoId();

            $stmt->execute();

        }
        public function alterarLivroEmprestimo(Emprestimo $emprestimo, Livro $livro){

            $pdo = Conexao::conectar();

            $sql = 'UPDATE ' . self::NOME_TABELA_LIVRO_EMPRESTIMO . ' SET livro_emprestimo_livro_id = :livro_emprestimo_livro_id, livro_emprestimo_emprestimo_id = :livro_emprestimo_emprestimo_id WHERE livro_emprestimo_livro_id = :livro_emprestimo_livro_id AND livro_emprestimo_emprestimo_id = :livro_emprestimo_emprestimo_id;';
            $stmt = $pdo->prepare($sql);

            $stmt->bindParam(':livro_emprestimo_livro_id', $livro_emprestimo_livro_id, PDO::PARAM_STR);
            $stmt->bindParam(':livro_emprestimo_emprestimo_id', $livro_emprestimo_emprestimo_id, PDO::PARAM_STR);

            $livro_emprestimo_livro_id          = $livro->getLivroId();
            $livro_emprestimo_emprestimo_id     = $emprestimo->getEmprestimoId();

            $stmt->execute();

        }
        public function excluirLivroEmprestimo(Emprestimo $emprestimo, Livro $livro){

            $pdo = Conexao::conectar();

            $sql = 'DELETE FROM ' . self::NOME_TABELA_LIVRO_EMPRESTIMO . ' WHERE livro_emprestimo_livro_id = :livro_emprestimo_livro_id AND livro_emprestimo_emprestimo_id = :livro_emprestimo_emprestimo_id;';
            $stmt = $pdo->prepare($sql);

            $stmt->bindParam(':livro_emprestimo_livro_id', $livro_emprestimo_livro_id, PDO::PARAM_STR);
            $stmt->bindParam(':livro_emprestimo_emprestimo_id', $livro_emprestimo_emprestimo_id, PDO::PARAM_STR);

            $livro_emprestimo_livro_id          = $livro->getLivroId();
            $livro_emprestimo_emprestimo_id     = $emprestimo->getEmprestimoId();

            $stmt->execute();
        

        }

        public function procurarLivroPorId(Emprestimo $emprestimo, Livro $livro){

            try{
                $pdo        = Conexao::conectar();
                $sql        = 'select l.* from livro_emprestimo le inner join livro l on le.livro_emprestimo_livro_id = l.livro_id where l.livro_id = :livro_id and le.livro_emprestimo_emprestimo_id = :livro_emprestimo_emprestimo_id;';
                
                $stmt = $pdo->prepare($sql);

                $stmt->bindParam(':livro_id', $livro_emprestimo_livro_id, PDO::PARAM_STR);
                $stmt->bindParam(':livro_emprestimo_emprestimo_id', $livro_emprestimo_emprestimo_id, PDO::PARAM_STR);

                $livro_emprestimo_emprestimo_id     = $emprestimo->getEmprestimoId();
                $livro_id                           = $livro->getLivroId();

                $stmt->execute();

                $liv = $stmt->fetch(PDO::FETCH_ASSOC);

                $livro = (new Livro())->setLivroId($liv['livro_id'])
                                        ->setLivroNome($liv['livro_nome'])
                                        ->setLivroIsbn($liv['livro_isbn'])
                                        ->setLivroEdicao($liv['livro_edicao'])
                                        ->setLivroDataPublicacao($liv['livro_data_publicacao'])
                                        ->setLivroAutor($liv['livro_autor']);
            
                return $livro;
                
            }catch (PDOException $e){
                echo 'Erro ao Listar -> ' . $e->getMessage();
            }finally{
                $pdo = null;
            }

        }

        public function listarLivrosDoEmprestimo(Emprestimo $emprestimo){
            try{
                $pdo        = Conexao::conectar();
                $sql        = 'SELECT l.* from ' . self::NOME_TABELA_LIVRO_EMPRESTIMO . '  LE INNER JOIN LIVRO L ON LE.LIVRO_EMPRESTIMO_LIVRO_ID = L.LIVRO_ID WHERE LE.LIVRO_EMPRESTIMO_EMPRESTIMO_ID = :livro_emprestimo_emprestimo_id;';

                $stmt = $pdo->prepare($sql);
                $stmt->bindParam(':livro_emprestimo_emprestimo_id', $livro_emprestimo_emprestimo_id, PDO::PARAM_STR);

                $livro_emprestimo_emprestimo_id     = $emprestimo->getEmprestimoId();

                $stmt->execute();

                $lista_livros = [];

                $livros = $stmt->fetchAll(PDO::FETCH_ASSOC);

                foreach($livros as $k => $liv){
                    $livro = (new Livro())->setLivroId($liv['livro_id'])
                                        ->setLivroNome($liv['livro_nome'])
                                        ->setLivroIsbn($liv['livro_isbn'])
                                        ->setLivroEdicao($liv['livro_edicao'])
                                        ->setLivroDataPublicacao($liv['livro_data_publicacao'])
                                        ->setLivroAutor($liv['livro_autor']);

                    $lista_livros[] = $livro;
                }
                 
                return $lista_livros;

            }catch (PDOException $e){
                echo 'Erro ao Listar -> ' . $e->getMessage();
            }finally{
                $pdo = null;
            }
        }

        public function deletarTodosLivrosDoEmprestimo(Emprestimo $emprestimo){
            $pdo = Conexao::conectar();

            $sql = 'DELETE FROM ' . self::NOME_TABELA_LIVRO_EMPRESTIMO . ' WHERE livro_emprestimo_emprestimo_id = :livro_emprestimo_emprestimo_id;';
            $stmt = $pdo->prepare($sql);

            $stmt->bindParam(':livro_emprestimo_emprestimo_id', $livro_emprestimo_emprestimo_id, PDO::PARAM_STR);

            $livro_emprestimo_emprestimo_id     = $emprestimo->getEmprestimoId();

            $stmt->execute();
        
        }

        public function procurarUltimoEmprestimo(){
            try{
                $pdo        = Conexao::conectar();
                $sql        = 'select * from '. self::NOME_TABELA_EMPRESTIMO .' order by emprestimo_id desc limit 1;';

                
                $query      = $pdo->query($sql);

                $emp = $query->fetch(PDO::FETCH_ASSOC);

                $bibliotecarioDAO = new BibliotecarioDAOMySQL();
                $bibliotecarioBO = new BibliotecarioBO($bibliotecarioDAO);
            
                $emprestimo_id    = (new Emprestimo())->setEmprestimoId($emp['emprestimo_id']);
                $bibliotecario_id = $bibliotecarioBO->procurarBibliotecarioPorId((new Bibliotecario())->setBibliotecarioId($emp['emprestimo_bibliotecario_id']));

                $emprestimo = (new Emprestimo())->setEmprestimoId($emp['emprestimo_id'])
                                        ->setEmprestimoDataEntrega($emp['emprestimo_data_entrega'])
                                        ->setEmprestimoDataDevolucao($emp['emprestimo_data_devolucao'])
                                        ->setEmprestimoBibliotecarioId($bibliotecario_id)
                                        ->setEmprestimoLivros($this->listarLivrosDoEmprestimo($emprestimo_id));

                return $emprestimo;

            }catch (PDOException $e){
                echo 'Erro ao Listar -> ' . $e->getMessage();
            }finally{
                $pdo = null;
            }
        }




    }


?>