/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.web.appturmas.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Joao
 */
public class Conexao {
    
    private static Connection conn;
    
    private static String DSN = "org.gjt.mm.mysql.Driver";
    
    private static String DB_TYPE     = "mysql";
    private static String DB_NAME     = "instituicao";
    private static String DB_HOST     = "localhost";
    private static String DB_USERNAME = "root";
    private static String DB_PASS     = "";

    public static Connection conectar(){
        String url = "jdbc:" + DB_TYPE + "://" + DB_HOST + "/" +  DB_NAME;
        if (conn == null){
            try{
                Class.forName(DSN);
                conn = DriverManager.getConnection(url, DB_USERNAME, DB_PASS);   
            }catch(SQLException e){
                System.out.println("Houve um erro com a conexão do SQL. Erro -> " + e.getMessage());
            }catch(ClassNotFoundException e){
                System.out.println("DSN não encontrado!");
            }
        }
        return conn;
    }
    
}
