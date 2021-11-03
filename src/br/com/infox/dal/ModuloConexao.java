/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infox.dal;

import java.sql.*;

/**
 *
 * @author Cristiano
 */
public class ModuloConexao {
    // Método responsável por estabelecer a conexão com o banco de dados
    public static Connection conector() {
        java.sql.Connection conexao = null;
        
        // Chamando o drive de conexão
        String driver = "com.mysql.cj.jdbc.Driver";
        
        // Armazendo informações do banco de dados
        String url = "jdbc:mysql://localhost:3306/db_infox";
        String user = "root";
        String password = "74002716";
        
        // Estabelecendo o conexão com o banco de dados
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
            
        } catch (Exception e) {
            // System.out.println(e);
            return null;
        }
        
    }
    
}
