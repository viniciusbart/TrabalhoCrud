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
public class DbHandler {
    
    public static void InsertIntoProdutos(String nome, double preco, double quantidade, int categoria, Connection cnn) throws SQLException{
        try{
            Statement stmt = cnn.createStatement();
            stmt.executeUpdate("INSERT INTO PRODUTOS (`nome`,`preco`,`qtd`,`categoria`) VALUES "
                    + "('"+nome+"','"+preco+"','"+quantidade+"','"+categoria+"')");
        } catch (Exception e) {
            throw new SQLException("Erro ao inserir dados. " + e.getMessage());
        }
    }
    
    public static void UpdateProdutos (int cod, String nome, double preco, double quantidade, int categoria, Connection cnn) throws SQLException{
        try{
           Statement stmt = cnn.createStatement(); 
           stmt.executeUpdate("UPDATE PRODUTOS SET `nome`='" + nome + "', `preco`='" + preco + "', `qtd`='" + quantidade
                   + "', `categoria`='" + categoria + "' WHERE `cod`='"+cod+"'");
        }catch (Exception e) {
            throw new SQLException("Erro ao atualizar dados. " + e.getMessage());
        }
    }
    
    public static void DeleteFromProdutos (int cod, Connection cnn) throws SQLException{
        try{
            Statement stmt = cnn.createStatement(); 
            stmt.executeUpdate("DELETE FROM PRODUTOS WHERE `cod`='"+cod+"'");
        }catch (Exception e){
            throw new SQLException("Erro ao remover dados. " + e.getMessage());
        }
    }
}
