<?php

    include('autoload.php');

    class VendedorDAO implements IPersistenciaVendedor{

        private const NOME_TABELA = 'vendedor';

        public function inserir(Vendedor $vendedor){
            try{
                $pdo = Conexao::conectar();
                $sql = 'INSERT INTO ' . self::NOME_TABELA . ' (nome,usuario,senha) VALUES(:nome,:usuario,:senha)';
                $stmt = $pdo->prepare($sql);

                $stmt->bindParam(':nome', $nome, PDO::PARAM_STR);
                $stmt->bindParam(':usuario', $usuario, PDO::PARAM_STR);
                $stmt->bindParam(':senha', $senha, PDO::PARAM_STR);

                $nome         = $vendedor->getNome();
                $usuario      = $vendedor->getUsuario();
                $senha        = $vendedor->getSenha();

                $stmt->execute();

            }catch (PDOException $e){
                echo 'Erro ao Inserir -> ' . $e->getMessage();
            }finally{
                $pdo = null;
            }    
        }
        
        public function alterar(Vendedor $vendedor){
            try{
                $pdo = Conexao::conectar();
                $sql = 'UPDATE ' . self::NOME_TABELA . ' SET nome = :nome, usuario = :usuario, senha = :senha WHERE idvendedor = :codigo';
                $stmt = $pdo->prepare($sql);

                $stmt->bindParam(':nome', $nome, PDO::PARAM_STR);
                $stmt->bindParam(':usuario', $usuario,  PDO::PARAM_STR);
                $stmt->bindParam(':senha', $senha,  PDO::PARAM_INT);
                $stmt->bindParam(':codigo', $codigo,  PDO::PARAM_INT);

                $nome         = $vendedor->getNome();
                $usuario      = $vendedor->getUsuario();
                $senha        = $vendedor->getSenha();
                $codigo        = $vendedor->getIdVendedor();

                $stmt->execute();
            }catch (PDOException $e){
                echo 'Erro ao Alterar -> ' . $e->getMessage();
            }finally{
                $pdo = null;
            }
        }

        public function excluir(Vendedor $vendedor){
            try{
                $pdo = Conexao::conectar();
                $sql = 'DELETE FROM ' . self::NOME_TABELA . ' WHERE idvendedor = :codigo';
                $stmt = $pdo->prepare($sql);
                $stmt->bindParam(':codigo', $id);
        
                $id = $vendedor->getIdVendedor();

                $stmt->execute();
            }catch (PDOException $e){
                echo 'Erro ao Excluir -> ' . $e->getMessage();
            }finally{
                $pdo = null;
            }
        }

        public function listarVendedores(){   
            try{
                $pdo = Conexao::conectar();
                $sql = 'SELECT * FROM vendedor;';
                $query = $pdo->query($sql);
                $vendedores = $query->fetchAll();
                return $vendedores;
            }catch (PDOException $e){
                echo 'Erro ao Listar -> ' . $e->getMessage();
            }finally{
                $pdo = null;
            }
        }

        public function listarVendedorPorCodigo(Vendedor $vendedor){
            try{
                $pdo = Conexao::conectar();
                $sql = 'SELECT * FROM ' . self::NOME_TABELA . ' WHERE idvendedor = :codigo';

                $stmt = $pdo->prepare($sql);
                $stmt->bindParam(':codigo', $codigo);
                $codigo = $vendedor->getIdVendedor();

                $stmt->execute();
                $vendedor = $stmt->fetchAll();
                return $vendedor;
            }catch (PDOException $e){
                echo 'Erro ao Listar -> ' . $e->getMessage();
            }finally{
                $pdo = null;
            }
        }



    }


?>