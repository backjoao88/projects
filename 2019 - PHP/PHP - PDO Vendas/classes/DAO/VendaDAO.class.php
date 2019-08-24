<?php

    include('autoload.php');

    class VendaDAO implements IPersistenciaVenda{

        private const NOME_TABELA = 'venda';
        private const NOME_TABELA_ASS = 'produto_has_venda';

        public function inserir(Venda $venda){
            try{
                $pdo = Conexao::conectar();
                
                $sql = 'INSERT INTO ' . self::NOME_TABELA . ' (data,dataVencimento,dataPagamento,cliente_idcliente,vendedor_idvendedor) VALUES(:data,:dataVencimento,:dataPagamento, :cliente, :vendedor)';
                $stmt = $pdo->prepare($sql);

                $stmt->bindParam(':data', $data, PDO::PARAM_STR);
                $stmt->bindParam(':dataVencimento', $dataVencimento, PDO::PARAM_STR);
                $stmt->bindParam(':dataPagamento', $dataPagamento, PDO::PARAM_STR);
                $stmt->bindParam(':cliente', $cliente, PDO::PARAM_STR);
                $stmt->bindParam(':vendedor', $vendedor, PDO::PARAM_STR);

                $data               = $venda->getData();
                $dataVencimento     = $venda->getDataVencimento();
                $dataPagamento      = $venda->getDataPagamento();
                $cliente            = $venda->getCliente()->getIdCliente();
                $vendedor           = $venda->getVendedor()->getIdVendedor();

                $stmt->execute();

            }catch (PDOException $e){
                echo 'Erro ao Inserir -> ' . $e->getMessage();
            }finally{
                $pdo = null;
            }    
        }
        
        public function alterar(Venda $venda){
            try{
                $pdo = Conexao::conectar();
                $sql = 'UPDATE ' . self::NOME_TABELA . ' SET data = :data, dataVencimento = :dataVencimento, dataPagamento = :dataPagamento, cliente = :cliente, vendedor = :vendedor WHERE idvenda = :codigo';
                $stmt = $pdo->prepare($sql);

                $stmt->bindParam(':data', $data, PDO::PARAM_STR);
                $stmt->bindParam(':dataVencimento', $dataVencimento, PDO::PARAM_STR);
                $stmt->bindParam(':dataPagamento', $dataPagamento, PDO::PARAM_STR);
                $stmt->bindParam(':cliente', $cliente, PDO::PARAM_STR);
                $stmt->bindParam(':vendedor', $vendedor, PDO::PARAM_STR);
                $stmt->bindParam(':codigo', $codigo, PDO::PARAM_STR);

                $data               = $venda->getData();
                $dataVencimento     = $venda->getDataVencimento();
                $dataPagamento      = $venda->getDataPagamento();
                $cliente            = $venda->getCliente()->getIdCliente();
                $vendedor           = $venda->getVendedor()->getIdVendedor();
                $codigo             = $venda->getIdVenda();

                $stmt->execute();
            }catch (PDOException $e){
                echo 'Erro ao Alterar -> ' . $e->getMessage();
            }finally{
                $pdo = null;
            }
        }

        public function excluir(Venda $venda){
            try{
                $pdo = Conexao::conectar();
                $sql = 'DELETE FROM ' . self::NOME_TABELA . ' WHERE idvenda = :codigo';
                $stmt = $pdo->prepare($sql);
                $stmt->bindParam(':codigo', $id);
        
                $id = $venda->getIdVenda();

                $stmt->execute();
            }catch (PDOException $e){
                echo 'Erro ao Excluir -> ' . $e->getMessage();
            }finally{
                $pdo = null;
            }
        }

        public function inserirItemProduto(Venda $venda, ItemProduto $itemProduto){

            $pdo = Conexao::conectar();

            $sql  = 'INSERT INTO ' . self::NOME_TABELA_ASS . ' VALUES(:produto,:venda,:quantidade)';
            $stmt = $pdo->prepare($sql);

            $stmt->bindParam(':produto', $produto, PDO::PARAM_STR);
            $stmt->bindParam(':venda', $vendaId, PDO::PARAM_STR);
            $stmt->bindParam(':quantidade', $quantidade, PDO::PARAM_STR);

            $quantidade       = $itemProduto->getQuantidadeProduto();
            $vendaId          = $venda->getIdVenda();
            $produto          = $itemProduto->getId();

            $stmt->execute();

        }

        public function listarVendas(){   
            try{
                $pdo = Conexao::conectar();
                $sql = 'SELECT * FROM ' . self::NOME_TABELA . ';';

                $query = $pdo->query($sql);

                $vendas = $query->fetchAll(PDO::FETCH_ASSOC);

                $lista_venda = [];

                foreach($vendas as $k => $vend){
                    
                    $vendaItemProduto = (new Venda())->setIdVenda($vend['idvenda']);

                    $vend = (new Venda())->setIdVenda($vend['idvenda'])
                                            ->setData($vend['data'])
                                            ->setDataPagamento($vend['dataPagamento'])
                                            ->setDataVencimento($vend['dataVencimento'])
                                            ->setCliente($vend['cliente_idcliente'])
                                            ->setVendedor($vend['vendedor_idvendedor'])
                                            ->setProdutos($this->listarItemProduto($vendaItemProduto));
                    $lista_venda[] = $vend;
                } 

                return $lista_venda;
            }catch (PDOException $e){
                echo 'Erro ao Listar -> ' . $e->getMessage();
            }finally{
                $pdo = null;
            }
        }


        public function listarVendaPorCodigo(Venda $venda){
            try{
                $pdo = Conexao::conectar();
                $sql = 'SELECT * FROM ' . self::NOME_TABELA . ' WHERE idvenda = :codigo';

                $stmt = $pdo->prepare($sql);
                $stmt->bindParam(':codigo', $codigo);
                $codigo = $venda->getIdVenda();

                $stmt->execute();
                $vendas = $stmt->fetchAll(PDO::FETCH_ASSOC);

                $lista_venda = [];

                foreach($vendas as $k => $vend){
                    $vend = (new Venda())->setIdVenda($vend['idvenda'])
                                            ->setData($vend['data'])
                                            ->setDataPagamento($vend['dataPagamento'])
                                            ->setDataVencimento($vend['dataVencimento'])
                                            ->setCliente($vend['cliente_idcliente'])
                                            ->setVendedor($vend['vendedor_idvendedor']);
                    $lista_venda[] = $vend;
                } 

                return $lista_venda[0];
            }catch (PDOException $e){
                echo 'Erro ao Listar -> ' . $e->getMessage();
            }finally{
                $pdo = null;
            }
        }

        public function listarItemProduto(Venda $venda){
            try{
                $pdo = Conexao::conectar();
                $sql = 'select * from produto p inner join produto_has_venda ph on p.idproduto = ph.produto_idproduto where venda_idvenda = :codigo;';

                $stmt = $pdo->prepare($sql);
                $stmt->bindParam(':codigo', $codigo);
                $codigo = $venda->getIdVenda();

                $stmt->execute();
                $vendas = $stmt->fetchAll(PDO::FETCH_ASSOC);

                $lista_venda = [];

                foreach($vendas as $k => $vend){
                    $vend = (new ItemProduto())->setId($vend['idproduto'])
                                            ->setDescricao($vend['descricao'])
                                            ->setPreco($vend['valor'])
                                            ->setCodigoBarra($vend['codigodebarra'])
                                            ->setMarcaId($vend['marca_idmarca'])
                                            ->setQuantidadeProduto($vend['quantidadeProduto']);
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