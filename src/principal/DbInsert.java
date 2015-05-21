/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Usuário
 */
public class DbInsert {
    
    public static void InsertIntoProdutos(int cod, String nome, double preco, double quantidade, int categoria, Connection cnn) throws SQLException{
        try{
            Statement stmt = cnn.createStatement();
            stmt.executeUpdate("INSERT INTO PRODUTOS (`cod`,`nome`,`preco`,`qtd`,`categoria`) VALUES "
                    + "('"+cod+"','"+nome+"','"+preco+"','"+quantidade+"','"+categoria+"')");
        } catch (Exception e) {
            throw new SQLException("Erro ao inserir dados. " + e.getMessage());
        }
    }
    public static void InsertIntoProdutos(String nome, double preco, double quantidade, int categoria, Connection cnn) throws SQLException{
        try{
            Statement stmt = cnn.createStatement();
            stmt.executeUpdate("INSERT INTO PRODUTOS (`nome`,`preco`,`qtd`,`categoria`) VALUES "
                    + "('"+nome+"','"+preco+"','"+quantidade+"','"+categoria+"')");
        } catch (Exception e) {
            throw new SQLException("Erro ao inserir dados. " + e.getMessage());
        }
    }
}
