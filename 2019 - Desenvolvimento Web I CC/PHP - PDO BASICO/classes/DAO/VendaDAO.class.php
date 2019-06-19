<?php

    include('autoload.php');

    class VendaDAO implements IPersistenciaVenda{

        private const NOME_TABELA = 'venda';

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

                echo $cliente;

                //$stmt->execute();

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

        public function listarVendas(){   
            try{
                $pdo = Conexao::conectar();
                $sql = 'SELECT * FROM venda;';
                $query = $pdo->query($sql);
                $vendas = $query->fetchAll();
                return $vendas;
            }catch (PDOException $e){
                echo 'Erro ao Listar -> ' . $e->getMessage();
            }finally{
                $pdo = null;
            }
        }


    }


?>