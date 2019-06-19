<?php

    include('autoload.php');

    class ClienteDAO implements IPersistenciaCliente{

        private const NOME_TABELA = 'cliente';

        public function inserir(Cliente $cliente){
            try{
                $pdo = Conexao::conectar();
                $sql = 'INSERT INTO ' . self::NOME_TABELA . ' (nome,cpf,rg,fone,email,usuario,senha,endereco,numero,bairro,cidade,estado) VALUES(:nome,:cpf,:rg,:fone,:email,:usuario,:senha,:endereco,:numero,:bairro,:cidade,:estado)';
                $stmt = $pdo->prepare($sql);

                $stmt->bindParam(':nome', $nome, PDO::PARAM_STR);
                $stmt->bindParam(':cpf', $cpf, PDO::PARAM_STR);
                $stmt->bindParam(':rg', $rg, PDO::PARAM_STR);
                $stmt->bindParam(':fone', $fone, PDO::PARAM_STR);
                $stmt->bindParam(':email', $email, PDO::PARAM_STR);
                $stmt->bindParam(':usuario', $usuario, PDO::PARAM_STR);
                $stmt->bindParam(':senha', $senha, PDO::PARAM_STR);
                $stmt->bindParam(':endereco', $endereco, PDO::PARAM_STR);
                $stmt->bindParam(':numero', $numero, PDO::PARAM_STR);
                $stmt->bindParam(':bairro', $bairro, PDO::PARAM_STR);
                $stmt->bindParam(':cidade', $cidade, PDO::PARAM_STR);
                $stmt->bindParam(':estado', $estado, PDO::PARAM_STR);

                $nome        = $cliente->getNome();
                $cpf         = $cliente->getCpf();
                $rg          = $cliente->getRg();
                $fone        = $cliente->getFone();
                $email       = $cliente->getEmail();
                $usuario     = $cliente->getUsuario();
                $senha       = $cliente->getSenha();
                $endereco    = $cliente->getEndereco();
                $numero      = $cliente->getNumero();
                $bairro      = $cliente->getBairro();
                $cidade      = $cliente->getCidade();
                $estado      = $cliente->getEstado();

                $stmt->execute();

            }catch (PDOException $e){
                echo 'Erro ao Inserir -> ' . $e->getMessage();
            }finally{
                $pdo = null;
            }    
        }
        
        public function alterar(Cliente $cliente){
            try{
                $pdo = Conexao::conectar();
                $sql = 'UPDATE ' . self::NOME_TABELA . ' SET nome = :nome, cpf = :cpf, rg = :rg, fone = :fone, email = :email, usuario = :usuario, senha = :senha, endereco = :endereco, numero = :numero, bairro = :bairro, cidade = :cidade, estado = :estado WHERE idcliente = :codigo';
                $stmt = $pdo->prepare($sql);

                $stmt->bindParam(':nome', $nome, PDO::PARAM_STR);
                $stmt->bindParam(':cpf', $cpf, PDO::PARAM_STR);
                $stmt->bindParam(':rg', $rg, PDO::PARAM_STR);
                $stmt->bindParam(':fone', $fone, PDO::PARAM_STR);
                $stmt->bindParam(':email', $email, PDO::PARAM_STR);
                $stmt->bindParam(':usuario', $usuario, PDO::PARAM_STR);
                $stmt->bindParam(':senha', $senha, PDO::PARAM_STR);
                $stmt->bindParam(':endereco', $endereco, PDO::PARAM_STR);
                $stmt->bindParam(':numero', $numero, PDO::PARAM_STR);
                $stmt->bindParam(':bairro', $bairro, PDO::PARAM_STR);
                $stmt->bindParam(':cidade', $cidade, PDO::PARAM_STR);
                $stmt->bindParam(':estado', $estado, PDO::PARAM_STR);
                $stmt->bindParam(':codigo', $codigo, PDO::PARAM_STR);

                $nome        = $cliente->getNome();
                $cpf         = $cliente->getCpf();
                $rg          = $cliente->getRg();
                $fone        = $cliente->getFone();
                $email       = $cliente->getEmail();
                $usuario     = $cliente->getUsuario();
                $senha       = $cliente->getSenha();
                $endereco    = $cliente->getEndereco();
                $numero      = $cliente->getNumero();
                $bairro      = $cliente->getBairro();
                $cidade      = $cliente->getCidade();
                $estado      = $cliente->getEstado();
                $codigo      = $cliente->getIdCliente();

                $stmt->execute();
            }catch (PDOException $e){
                echo 'Erro ao Alterar -> ' . $e->getMessage();
            }finally{
                $pdo = null;
            }
        }

        public function excluir(Cliente $cliente){
            try{
                $pdo = Conexao::conectar();
                $sql = 'DELETE FROM ' . self::NOME_TABELA . ' WHERE idcliente = :id';
                $stmt = $pdo->prepare($sql);
                $stmt->bindParam(':id', $id);
        
                $id = $cliente->getIdCliente();

                $stmt->execute();
            }catch (PDOException $e){
                echo 'Erro ao Excluir -> ' . $e->getMessage();
            }finally{
                $pdo = null;
            }
        }

        public function listarClientes(){   
            try{
                $pdo = Conexao::conectar();
                $sql = 'SELECT * FROM cliente;';
                $query = $pdo->query($sql);
                $clientes = $query->fetchAll();
                return $clientes;
            }catch (PDOException $e){
                echo 'Erro ao Listar -> ' . $e->getMessage();
            }finally{
                $pdo = null;
            }
        }
        
        public function listarClientePorCodigo(Cliente $cliente){
            try{
                $pdo = Conexao::conectar();
                $sql = 'SELECT * FROM ' . self::NOME_TABELA . ' WHERE idcliente = :codigo';

                $stmt = $pdo->prepare($sql);
                $stmt->bindParam(':codigo', $codigo);
                $codigo = $cliente->getIdCliente();

                $stmt->execute();
                $cliente = $stmt->fetchAll();
                return $cliente;
            }catch (PDOException $e){
                echo 'Erro ao Listar -> ' . $e->getMessage();
            }finally{
                $pdo = null;
            }       
        }


    }


?>