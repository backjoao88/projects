<?php

    include('autoload.php');

    class MarcaDAO implements IPersistenciaMarca{

        private const NOME_TABELA = 'marca';

        public function inserir(Marca $marca){
            try{
                $pdo = Conexao::conectar();
                $sql = 'INSERT INTO ' . self::NOME_TABELA . ' (descricao) VALUES(:descricao)';
                $stmt = $pdo->prepare($sql);
                $stmt->bindParam(':descricao', $descricao, PDO::PARAM_STR);
                $descricao = $marca->getDescricao();
                $stmt->execute();
            }catch (PDOException $e){
                echo 'Erro ao Inserir -> ' . $e->getMessage();
            }finally{
                $pdo = null;
            }
        }

        public function alterar(Marca $marca){
            try{
                $pdo = Conexao::conectar();
                $sql = 'UPDATE ' . self::NOME_TABELA . ' SET DESCRICAO = (:descricao) WHERE CODIGO = (:codigo)';
                $stmt = $pdo->prepare($sql);
                $stmt->bindParam(':descricao', $descricao, PDO::PARAM_STR);
                $stmt->bindParam(':codigo', $codigo, PDO::PARAM_STR);
                $descricao = $marca->getDescricao();
                $codigo    = $marca->getId();
                $stmt->execute();
            }catch (PDOException $e){
                echo 'Erro ao Alterar -> ' . $e->getMessage();
            }finally{
                $pdo = null;
            }
        }

        public function excluir(Marca $marca){
            try{
                $pdo = Conexao::conectar();
                $sql = 'DELETE FROM ' . self::NOME_TABELA . ' WHERE codigo = :id';
                $stmt = $pdo->prepare($sql);
                $stmt->bindParam(':id', $id);
                
                $id = $marca->getId();

                $stmt->execute();
            }catch (PDOException $e){
                echo 'Erro ao Alterar -> ' . $e->getMessage();
            }finally{
                $pdo = null;
            }
        }

        public function listarMarcasPorDescricao(Marca $marca){
            try{
                $pdo = Conexao::conectar();
                $sql = 'SELECT * FROM ' . self::NOME_TABELA . ' WHERE descricao LIKE :descricao ORDER BY descricao';

                $stmt = $pdo->prepare($sql);
                $stmt->bindParam(':descricao', $descricao);
                $descricao = $marca->getDescricao();

                $stmt->execute();
                $marcas = $stmt->fetchAll();
                return $marcas;
            }catch (PDOException $e){
                echo 'Erro ao Listar -> ' . $e->getMessage();
            }finally{
                $pdo = null;
            }
        }

        
        public function listarMarcaPorCodigo(Marca $marca){
            try{
                $pdo = Conexao::conectar();
                $sql = 'SELECT * FROM ' . self::NOME_TABELA . ' WHERE codigo = :codigo';

                $stmt = $pdo->prepare($sql);
                $stmt->bindParam(':codigo', $codigo);
                $codigo = $marca->getId();

                $stmt->execute();
                $marcas = $stmt->fetchAll();
                return $marcas;
            }catch (PDOException $e){
                echo 'Erro ao Listar -> ' . $e->getMessage();
            }finally{
                $pdo = null;
            }
        }

        public function listarMarcas(){
            try{
                $pdo = Conexao::conectar();
                $sql = 'SELECT * FROM marca;';
                $query = $pdo->query($sql);
                $marcas = $query->fetchAll();
                return $marcas;
            }catch (PDOException $e){
                echo 'Erro ao Listar -> ' . $e->getMessage();
            }finally{
                $pdo = null;
            }
        }

    }


?>