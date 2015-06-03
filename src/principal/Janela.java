/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *                                  *
 * @author Vinicius
 */
public class Janela extends javax.swing.JFrame {

    DefaultTableModel tableModel;

    /**
     * Creates new form Janela
     */
    public Janela() {
        initComponents();
        jTable.getTableHeader().setReorderingAllowed(false);
        resetTable();
        limparCampos();
        Listar.tableModel(tableModel);        
        txtPreco.addKeyListener(new KeyAdapter(){
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e); //To change body of generated methods, choose Tools | Templates.
                char c = e.getKeyChar();
                if (c == ',') e.setKeyChar('.');
            }
        });
        txtQtd.addKeyListener(new KeyAdapter(){
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e); //To change body of generated methods, choose Tools | Templates.
                char c = e.getKeyChar();
                if (c == ',') e.setKeyChar('.');
            }
        });
    }

    public void resetTable() {
        tableModel = new DefaultTableModel(new String[]{"COD", "Nome", "Preço", "Categoria", "Quantidade"}, 0);
        jTable.setModel(tableModel);
    }

    public void limparCampos() {
        txtCod.setText("");
        txtNome.setText("");
        txtPreco.setText("");
        jComboBox.setSelectedItem(null);
        txtQtd.setText("");
    }

    public void carregarCampos() {
        int linha = jTable.getSelectedRow();
        txtCod.setText((String) tableModel.getValueAt(linha, 0));
        txtNome.setText((String) tableModel.getValueAt(linha, 1));
        txtPreco.setText((String) tableModel.getValueAt(linha, 2));
        jComboBox.setSelectedItem((String) tableModel.getValueAt(linha, 3));
        txtQtd.setText((String) tableModel.getValueAt(linha, 4));
    }

    public void habilitarAlteracaoRemocao() {
        btAlterar.setEnabled(true);
        btExcluir.setEnabled(true);
        btInserir.setEnabled(false);
    }

    public void habilitarInsercao() {
        btAlterar.setEnabled(false);
        btExcluir.setEnabled(false);
        btInserir.setEnabled(true);
    }

    public void buscarTabela(){
        String nomeParcial = txtNome.getText();
        Vector dados = tableModel.getDataVector();
        boolean achou = false;
        jTable.removeRowSelectionInterval(0, jTable.getRowCount() - 1);
        for (int i = 0; i < dados.size(); i++) {
            Vector linha = (Vector) dados.get(i);
            if (((String) linha.elementAt(1)).indexOf(nomeParcial) >= 0) {
                achou = true;
                jTable.addRowSelectionInterval(i, i);
            }
        }
        if (achou) {
            carregarCampos();
            habilitarAlteracaoRemocao();
        } else {
            try{
                throw new Exception("Nome do produto não encontrado");
            } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
            }
            limparCampos();
            txtNome.setText(nomeParcial);
            txtNome.requestFocus();
            habilitarInsercao();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblCod = new javax.swing.JLabel();
        txtCod = new javax.swing.JTextField();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblPreco = new javax.swing.JLabel();
        txtPreco = new javax.swing.JTextField();
        lblCategoria = new javax.swing.JLabel();
        jComboBox = new javax.swing.JComboBox();
        btLimpar = new javax.swing.JButton();
        btBuscar = new javax.swing.JButton();
        btInserir = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();
        lblQtd = new javax.swing.JLabel();
        txtQtd = new javax.swing.JTextField();
        btExcluir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro de Produtos");

        lblCod.setText("COD: ");

        txtCod.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtCod.setEnabled(false);

        lblNome.setText("Nome:");

        lblPreco.setText("Preço: ");

        lblCategoria.setText("Categoria: ");

        jComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4" }));

        btLimpar.setText("Limpar");
        btLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparActionPerformed(evt);
            }
        });

        btBuscar.setText("Buscar");
        btBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarActionPerformed(evt);
            }
        });

        btInserir.setText("Inserir");
        btInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInserirActionPerformed(evt);
            }
        });

        btAlterar.setText("Alterar");
        btAlterar.setEnabled(false);
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });

        lblQtd.setText("Qtd.:");

        btExcluir.setText("Excluir");
        btExcluir.setEnabled(false);
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblCod)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblPreco)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblQtd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtQtd, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btAlterar)
                                .addGap(397, 397, 397)
                                .addComponent(btExcluir))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(btLimpar)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btBuscar)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btInserir)
                                    .addGap(18, 18, 18)
                                    .addComponent(lblCategoria)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCod)
                    .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPreco)
                    .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblQtd)
                    .addComponent(txtQtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblCategoria)
                        .addComponent(jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btLimpar)
                        .addComponent(btBuscar)
                        .addComponent(btInserir)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAlterar)
                    .addComponent(btExcluir))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jComboBox.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInserirActionPerformed
        try {
            if (txtNome.getText().equals("") || txtPreco.getText().equals("") || txtQtd.getText().equals("") || jComboBox.getSelectedItem() == null) {
                throw new Exception("Ow malucão, preenche direito essa porra!!");
            }
            Connection cnn = null;
            cnn = ConnBD.getConexao();
            DbHandler.InsertIntoProdutos(txtNome.getText(), Double.parseDouble(txtPreco.getText()), Double.parseDouble(txtQtd.getText()), Integer.parseInt(jComboBox.getSelectedItem().toString()), cnn);
            ConnBD.fechaConexao(cnn);
            resetTable();
            limparCampos();
            Listar.tableModel(tableModel);
        } catch (SQLException ex) {
            Logger.getLogger(Janela.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Janela.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btInserirActionPerformed

    private void btLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparActionPerformed
        limparCampos();
        jTable.removeRowSelectionInterval(0, jTable.getRowCount() - 1);
        habilitarInsercao();
        txtNome.requestFocus();
    }//GEN-LAST:event_btLimparActionPerformed

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
        if (evt.getClickCount() == 2) {
            carregarCampos();
            habilitarAlteracaoRemocao();
        }
    }//GEN-LAST:event_jTableMouseClicked

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        try {
            if (txtCod.getText().equals("") || txtNome.getText().equals("") || txtPreco.getText().equals("") || txtQtd.getText().equals("") || jComboBox.getSelectedItem() == null) {
                throw new Exception("Preencha TODOS os campos!!");
            }
            Connection cnn = null;
            cnn = ConnBD.getConexao();
            DbHandler.UpdateProdutos(Integer.parseInt(txtCod.getText()), txtNome.getText(), Double.parseDouble(txtPreco.getText()), Double.parseDouble(txtQtd.getText()), Integer.parseInt(jComboBox.getSelectedItem().toString()), cnn);
            ConnBD.fechaConexao(cnn);
            resetTable();
            limparCampos();
            habilitarInsercao();
            Listar.tableModel(tableModel);
        } catch (SQLException ex) {
            Logger.getLogger(Janela.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Janela.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btAlterarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        try {
            if (JOptionPane.showConfirmDialog(this, "Tem certeza que quer remover?", "CONFIRMAÇÃO", JOptionPane.WARNING_MESSAGE) == JOptionPane.OK_OPTION) {
                Connection cnn = null;
                cnn = ConnBD.getConexao();
                DbHandler.DeleteFromProdutos(Integer.parseInt(txtCod.getText()), cnn);
                ConnBD.fechaConexao(cnn);
                limparCampos();
                habilitarInsercao();
                resetTable();
                Listar.tableModel(tableModel);
                JOptionPane.showMessageDialog(this, "Removido com sucesso!", "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
            } else {
                throw new Exception("Operação cancelada pelo usuário");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
        if (!txtNome.getText().equals("")){
            buscarTabela();
        }
        
    }//GEN-LAST:event_btBuscarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Janela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Janela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Janela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Janela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Janela().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btInserir;
    private javax.swing.JButton btLimpar;
    private javax.swing.JComboBox jComboBox;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblCod;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblPreco;
    private javax.swing.JLabel lblQtd;
    private javax.swing.JTextField txtCod;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPreco;
    private javax.swing.JTextField txtQtd;
    // End of variables declaration//GEN-END:variables
}
