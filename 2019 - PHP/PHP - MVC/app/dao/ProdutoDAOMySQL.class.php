<?php

    namespace app\dao;

    use app\dto\Produto;
    use conexao\Conexao;
    use app\interfaces\IPersistenciaProduto;
    use PDO;

    class ProdutoDAOMySQL implements IPersistenciaProduto{

        const NOME_TABELA = "PRODUTO";

        public function inserir(Produto $produto){
            try {
                $sql = ""
                    . "INSERT INTO " . self::NOME_TABELA . " (produto_descricao, produto_valor, produto_imagem)"
                    . "VALUES (:produto_descricao, :produto_valor, :produto_imagem)";
                $pdo = Conexao::conectar();
                $stmt = $pdo->prepare($sql);
                
                $stmt->bindParam(':produto_descricao', $produtoDescricao, PDO::PARAM_STR);
                $stmt->bindParam(':produto_valor', $produtoValor, PDO::PARAM_STR);
                $stmt->bindParam(':produto_imagem', $produtoImagem, PDO::PARAM_STR);
                
                $produtoDescricao = $produto->getProdutoDescricao();
                $produtoValor     = $produto->getProdutoValor();
                $produtoImagem    = $produto->getProdutoImagem();
                
                return $stmt->execute();

            }catch (PDOException $e){
                echo 'Erro ao Inserir -> ' . $e->getMessage();
            }finally{
                $pdo = null;
            }
        }

        public function alterar(Produto $produto){
            try{
                $pdo = Conexao::conectar();
                
                $sql = 'UPDATE ' . self::NOME_TABELA . ' SET produto_descricao = :produto_descricao, 
                produto_valor = :produto_valor, 
                produto_imagem = :produto_valor WHERE produto_codigo = :produto_codigo';

                $stmt = $pdo->prepare($sql);
                
                $stmt->bindParam(':produto_descricao', $produto_descricao, PDO::PARAM_INT);
                $stmt->bindParam(':produto_valor', $produto_valor,  PDO::PARAM_STR);
                $stmt->bindParam(':produto_imagem', $produto_imagem, PDO::PARAM_STR);
                $stmt->bindParam(':produto_codigo', $produto_codigo, PDO::PARAM_STR);
                
                $produto_descricao = $produto->getProdutoDescricao();
                $produto_valor     = $produto->getProdutoValor();
                $produto_imagem    = $produto->getProdutoImagem();
                
                $produto_codigo    = $produto->getProdutoCodigo();
                
                return $stmt->execute();

            }catch (PDOException $e){
                echo 'Erro ao Alterar -> ' . $e->getMessage();
                return false;
            }finally{
                $pdo = null;
            }
        }

        public function deletar(Produto $produto){
            try{
                $pdo = Conexao::conectar();
                $sql = 'DELETE FROM ' . self::NOME_TABELA . ' WHERE produto_codigo = :produto_codigo';
                $stmt = $pdo->prepare($sql);
                $stmt->bindParam(':produto_codigo', $produtoCodigo);
        
                $produtoCodigo = $produto->getProdutoCodigo();
                
                return $stmt->execute();

            }catch (PDOException $e){
                echo 'Erro ao Excluir -> ' . $e->getMessage();
                return false;
            }finally{
                $pdo = null;
            }
        }

        public function listar(){
            try{
                $pdo = Conexao::conectar();
                $sql = 'SELECT * FROM produto;';
                $query = $pdo->query($sql);
                $produtos = $query->fetchAll(PDO::FETCH_ASSOC);
                $lista_prod = [];
                foreach($produtos as $k => $produto){
                    $prod = (new Produto())->setProdutoCodigo($produto['produto_codigo'])
                                            ->setProdutoDescricao($produto['produto_descricao'])
                                            ->setProdutoImagem($produto['produto_imagem'])
                                            ->setProdutoValor($produto['produto_valor']);
                    $lista_prod[] = $prod;
                } 
                return $lista_prod;
            }catch (PDOException $e){
                echo 'Erro ao Listar -> ' . $e->getMessage();
            }finally{
                $pdo = null;
            }
        }

        
    }

?>