/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuário
 */
public class Listar {
    public static void tableModel(DefaultTableModel tableModel){
        try{
            Connection cnn = ConnBD.getConexao();
            Statement statement = cnn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM produtos");
            while(rs.next()){
                int cod = rs.getInt("cod");
                String nome = rs.getString("nome");
                String preco = rs.getString("preco");
                int categoria = rs.getInt("categoria");
                int qtd = rs.getInt("qtd");
                tableModel.addRow(new String[]{""+cod,nome,preco,""+categoria,""+qtd});
            }
            ConnBD.fechaConexao(cnn, statement);
        }catch(Exception e){
            System.err.println("Não foi possivel listar a tabela. " + e.getMessage());
        }
    }
}
