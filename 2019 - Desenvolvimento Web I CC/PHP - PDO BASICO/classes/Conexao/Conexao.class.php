<?php

    class Conexao{

        private static $pdo;

        private const BANCO_TIPO    = "mysql";
        private const BANCO_HOST    = "localhost";
        private const BANCO_NOME    = "vendaSimples";
        private const BANCO_USUARIO = "root";
        private const BANCO_SENHA   = "";
        
        public static function conectar(){
            if(self::$pdo == NULL){
                try{
                    self::$pdo = new PDO(self::BANCO_TIPO . ':host=' . self::BANCO_HOST . ';dbname=' . self::BANCO_NOME, self::BANCO_USUARIO, self::BANCO_SENHA);
                    self::$pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
                }catch(PDOException $e){
                    echo 'Erro na conexão -> ' . $e->getMessage();
                }
            }
            return self::$pdo;
        }

    }

?>