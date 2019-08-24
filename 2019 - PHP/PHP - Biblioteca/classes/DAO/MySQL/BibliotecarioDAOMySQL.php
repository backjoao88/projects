<?php

    include('autoload.php');

    class BibliotecarioDAOMySQL implements IPersistenciaBibliotecario{


        public function inserir(Bibliotecario $bibliotecario){
            try{
                $pdo = Conexao::conectar();
                $sql = 'INSERT INTO ' . self::NOME_TABELA_BIBLIOTECARIO . ' (bibliotecario_nome, bibliotecario_cpf, bibliotecario_login, bibliotecario_senha) VALUES(:bibliotecario_nome,:bibliotecario_cpf,:bibliotecario_login,:bibliotecario_senha)';
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

        public function alterar(Bibliotecario $bibliotecario){
            try{
                $pdo = Conexao::conectar();
                $sql = 'UPDATE ' . self::NOME_TABELA_BIBLIOTECARIO . ' SET bibliotecario_nome = :bibliotecario_nome, bibliotecario_cpf = :bibliotecario_cpf, bibliotecario_login = :bibliotecario_login, bibliotecario_senha = :bibliotecario_senha WHERE bibliotecario_id = :bibliotecario_id;';
                $stmt = $pdo->prepare($sql);

                $stmt->bindParam(':bibliotecario_nome', $bibliotecario_nome, PDO::PARAM_STR);
                $stmt->bindParam(':bibliotecario_cpf', $bibliotecario_cpf, PDO::PARAM_STR);
                $stmt->bindParam(':bibliotecario_login', $bibliotecario_login, PDO::PARAM_STR);
                $stmt->bindParam(':bibliotecario_senha', $bibliotecario_senha, PDO::PARAM_STR);
                $stmt->bindParam(':bibliotecario_id', $bibliotecario_id, PDO::PARAM_STR);

                $bibliotecario_nome        = $bibliotecario->getBibliotecarioNome();
                $bibliotecario_cpf         = $bibliotecario->getBibliotecarioCpf();
                $bibliotecario_login       = $bibliotecario->getBibliotecarioLogin();
                $bibliotecario_senha       = $bibliotecario->getBibliotecarioSenha();
                $bibliotecario_id          = $bibliotecario->getBibliotecarioId();

                $stmt->execute();

            }catch (PDOException $e){
                echo 'Erro ao Inserir -> ' . $e->getMessage();
            }finally{
                $pdo = null;
            }  
        }

        public function excluir(Bibliotecario $bibliotecario){
            try{
                $pdo = Conexao::conectar();
                $sql = 'DELETE FROM ' . self::NOME_TABELA_BIBLIOTECARIO . ' WHERE bibliotecario_id = :bibliotecario_id';
                $stmt = $pdo->prepare($sql);
                $stmt->bindParam(':bibliotecario_id', $bibliotecario_id);
        
                $bibliotecario_id  = $bibliotecario->getBibliotecarioId();

                $stmt->execute();
            }catch (PDOException $e){
                echo 'Erro ao Excluir -> ' . $e->getMessage();
            }finally{
                $pdo = null;
            }
        }

        public function procurarBibliotecarioPorId(Bibliotecario $bibliotecario){
            try{
                $pdo        = Conexao::conectar();
                $sql        = 'SELECT * FROM ' . self::NOME_TABELA_BIBLIOTECARIO . ' WHERE BIBLIOTECARIO_ID = :bibliotecario_id';
          
                $stmt = $pdo->prepare($sql);
                $stmt->bindParam(':bibliotecario_id', $bibliotecario_id);
        
                $bibliotecario_id          = $bibliotecario->getBibliotecarioId();
                $stmt->execute();

                $bibliotecarioAss = $stmt->fetch(PDO::FETCH_ASSOC);

                $bibliotecario = (new Bibliotecario())->setBibliotecarioId($bibliotecarioAss['bibliotecario_id'])
                                        ->setBibliotecarioNome($bibliotecarioAss['bibliotecario_nome'])
                                        ->setBibliotecarioCpf($bibliotecarioAss['bibliotecario_cpf'])
                                        ->setBibliotecarioLogin($bibliotecarioAss['bibliotecario_login'])
                                        ->setBibliotecarioSenha($bibliotecarioAss['bibliotecario_senha']);

                return $bibliotecario;
            }catch (PDOException $e){
                echo 'Erro ao Listar -> ' . $e->getMessage();
            }finally{
                $pdo = null;
            }
        }

        public function listarBibliotecarios(){
            try{
                $pdo        = Conexao::conectar();
                $sql        = 'SELECT * FROM ' . self::NOME_TABELA_BIBLIOTECARIO . ';';
                $query      = $pdo->query($sql);
                $bibliotecarios   = $query->fetchAll(PDO::FETCH_ASSOC);
                
                $lista_bibs = [];

                foreach($bibliotecarios as $k => $bib){

                    $bibliotecario = (new Bibliotecario())->setBibliotecarioId($bib['bibliotecario_id'])
                                            ->setBibliotecarioNome($bib['bibliotecario_nome'])
                                            ->setBibliotecarioCpf($bib['bibliotecario_cpf'])
                                            ->setBibliotecarioLogin($bib['bibliotecario_login'])
                                            ->setBibliotecarioSenha($bib['bibliotecario_senha']);
                    $lista_bibs[] = $bibliotecario;
                   // echo var_dump($bibliotecario);echo '<br>';echo '<br>';
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