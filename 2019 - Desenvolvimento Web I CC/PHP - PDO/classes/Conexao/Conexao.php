<?php

    class Conexao{

        private const NOME_BANCO = "mysql";
        private const URL        = "localhost";
        private const NOME_DB    = "vendaSimples";
        private const USUARIO    = "root";
        private const SENHA      = "";
        
        public static function conectar(){
            $pdo = new PDO(self::NOME_BANCO . ':host=' . self::URL . ';dbname=' . self::NOME_DB, self::USUARIO, self::SENHA);
            $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
            return $pdo;
        }

    }

?>