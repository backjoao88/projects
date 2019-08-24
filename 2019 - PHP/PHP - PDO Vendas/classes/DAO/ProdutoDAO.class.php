<?php

    include('autoload.php');

    class ProdutoDAO implements IPersistenciaProduto{

        private const NOME_TABELA = 'produto';

        public function inserir(Produto $produto){
            try{
                $pdo = Conexao::conectar();
                $sql = 'INSERT INTO ' . self::NOME_TABELA . ' (descricao,preco,codigodebarra,marca_codigo) VALUES(:descricao,:preco,:codigodebarra,:marca_codigo)';
                $stmt = $pdo->prepare($sql);

                $stmt->bindParam(':descricao', $descricao, PDO::PARAM_STR);
                $stmt->bindParam(':preco', $preco, PDO::PARAM_STR);
                $stmt->bindParam(':codigodebarra', $codigobarra, PDO::PARAM_STR);
                $stmt->bindParam(':marca_codigo', $marca_codigo, PDO::PARAM_STR);

                $descricao          = $produto->getDescricao();
                $preco              = $produto->getPreco();
                $codigobarra        = $produto->getCodigoBarra();
                $marca_codigo       = $produto->getMarcaId();

                $stmt->execute();

            }catch (PDOException $e){
                echo 'Erro ao Inserir -> ' . $e->getMessage();
            }finally{
                $pdo = null;
            }    
        }
        
        public function alterar(Produto $produto){
            try{
                $pdo = Conexao::conectar();
                $sql = 'UPDATE ' . self::NOME_TABELA . ' SET descricao = :descricao, preco = :preco, codigodebarra = :codigodebarra, marca_codigo = :marca_codigo WHERE codigo = :codigo';
                $stmt = $pdo->prepare($sql);

                $stmt->bindParam(':codigo', $codigo, PDO::PARAM_INT);
                $stmt->bindParam(':descricao', $descricao,  PDO::PARAM_STR);
                $stmt->bindParam(':preco', $preco, PDO::PARAM_STR);
                $stmt->bindParam(':codigodebarra', $codigodebarra,  PDO::PARAM_STR);
                $stmt->bindParam(':marca_codigo', $marca_codigo,  PDO::PARAM_INT);

                $codigo = $produto->getId();
                $descricao = $produto->getDescricao();
                $preco = $produto->getPreco();
                $codigodebarra = $produto->getCodigoBarra();
                $marca_codigo = $produto->getMarcaId();

                $stmt->execute();
            }catch (PDOException $e){
                echo 'Erro ao Alterar -> ' . $e->getMessage();
            }finally{
                $pdo = null;
            }
        }

        public function excluir(Produto $produto){
            try{
                $pdo = Conexao::conectar();
                $sql = 'DELETE FROM ' . self::NOME_TABELA . ' WHERE codigo = :id';
                $stmt = $pdo->prepare($sql);
                $stmt->bindParam(':id', $id);
        
                $id = $produto->getId();

                $stmt->execute();
            }catch (PDOException $e){
                echo 'Erro ao Excluir -> ' . $e->getMessage();
            }finally{
                $pdo = null;
            }
        }

        public function listarProdutosPorDescricao(Produto $produto){
            try{
                $pdo = Conexao::conectar();
                $sql = 'SELECT * FROM ' . self::NOME_TABELA . ' WHERE descricao LIKE :descricao ORDER BY descricao';

                $stmt = $pdo->prepare($sql);
                $stmt->bindParam(':descricao', $descricao);
                $descricao = $produto->getDescricao();

                $stmt->execute();
                $produtos = $stmt->fetchAll();
                return $produtos;
            }catch (PDOException $e){
                echo 'Erro ao Listar -> ' . $e->getMessage();
            }finally{
                $pdo = null;
            }
        }

        
        public function listarProdutoPorCodigo(Produto $produto){
            try{
                $pdo = Conexao::conectar();
                $sql = 'SELECT * FROM ' . self::NOME_TABELA . ' WHERE idproduto = :codigo';

                $stmt = $pdo->prepare($sql);
                $stmt->bindParam(':codigo', $codigo);
                $codigo = $produto->getId();

                $stmt->execute();
                $produtos = $stmt->fetchAll();

                $lista_produtos = [];

                foreach($produtos as $k => $prod){
                    $prod = (new Produto())->setId($prod['idproduto'])
                                          ->setDescricao($prod['descricao'])
                                          ->setPreco($prod['valor'])
                                          ->setCodigoBarra($prod['codigodebarra'])
                                          ->setMarcaId($prod['marca_idmarca']);

                    $lista_produtos[] = $prod;
                } 
                
                return $lista_produtos[0];
            }catch (PDOException $e){
                echo 'Erro ao Listar -> ' . $e->getMessage();
            }finally{
                $pdo = null;
            }
        }

        public function listarProdutos(){   
            try{
                $pdo = Conexao::conectar();
                $sql = 'SELECT * FROM produto;';
                $query = $pdo->query($sql);
                $produtos = $query->fetchAll(PDO::FETCH_ASSOC);

                $lista_venda = [];

                foreach($produtos as $k => $vend){
                    $vend = (new Produto())->setId($vend['idproduto'])
                                            ->setDescricao($vend['descricao'])
                                            ->setPreco($vend['valor'])
                                            ->setCodigoBarra($vend['codigodebarra'])
                                            ->setMarcaId($vend['marca_idmarca']);
                    $lista_venda[] = $vend;
                } 
                return $lista_venda;
            }catch (PDOException $e){
                echo 'Erro ao Listar -> ' . $e->getMessage();
            }finally{
                $pdo = null;
            }
        }


    }


?>