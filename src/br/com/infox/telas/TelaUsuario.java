/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infox.telas;

/**
 *
 * @author Cristiano
 */
import java.sql.*;
import br.com.infox.dal.ModuloConexao;
import javax.swing.JOptionPane;

public class TelaUsuario extends javax.swing.JInternalFrame {

    Connection conexao = null;

    PreparedStatement prepared = null;
    ResultSet result = null;

    public TelaUsuario() {
        initComponents();
        conexao = ModuloConexao.conector();
    }

    // Metodo consultar
    private void read() {
        String sql = "select * from tb_usuarios where id_user=?";

        try {
            prepared = conexao.prepareStatement(sql);
            prepared.setString(1, txtUsuarioId.getText());
            result = prepared.executeQuery();

            if (result.next()) {
                txtUsuarioNome.setText(result.getString(2));
                txtUsuarioTelefone.setText(result.getString(3));
                txtUsuarioLogin.setText(result.getString(4));
                txtUsuarioSenha.setText(result.getString(5));
                cboUsuarioPerfil.setSelectedItem(result.getString(6));
            } else {
                JOptionPane.showMessageDialog(null, "Usuário não cadastrado.");
                txtUsuarioNome.setText(null);
                txtUsuarioTelefone.setText(null);
                txtUsuarioLogin.setText(null);
                txtUsuarioSenha.setText(null);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    // Método adicionar
    private void create() {
        String sql = "insert into tb_usuarios"
                + "(id_user, usuario, fone, login, senha, perfil) "
                + "values(?, ?, ?, ?, ?, ?)";
        try {
            prepared = conexao.prepareStatement(sql);
            prepared.setString(1, txtUsuarioId.getText());
            prepared.setString(2, txtUsuarioNome.getText());
            prepared.setString(3, txtUsuarioTelefone.getText());
            prepared.setString(4, txtUsuarioLogin.getText());
            prepared.setString(5, txtUsuarioSenha.getText());
            prepared.setString(6, cboUsuarioPerfil.getSelectedItem().toString());

            // Validando os campos obrigatórios
            if ((txtUsuarioId.getText().isEmpty())
                    || (txtUsuarioNome.getText().isEmpty())
                    || (txtUsuarioLogin.getText().isEmpty())
                    || (txtUsuarioSenha.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null,
                        "Preencha todos os campos obritórios!");
            } else {

                // Atualizando o banco de dados com os novos dados
                int add = prepared.executeUpdate();

                // Verificando se tem algum usuário cadastrado
                if (add > 0) {
                    JOptionPane.showMessageDialog(null,
                            "Usuário adiconado com sucesso!");
                    txtUsuarioId.setText(null);
                    txtUsuarioNome.setText(null);
                    txtUsuarioTelefone.setText(null);
                    txtUsuarioLogin.setText(null);
                    txtUsuarioSenha.setText(null);
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    // Método Editar
    private void edit() {
        String sql = "update tb_usuarios set usuario=?, fone=?, login=?, "
                + "senha=?, perfil=? where id_user=?";
        try {
            prepared = conexao.prepareStatement(sql);
            prepared.setString(1, txtUsuarioNome.getText());
            prepared.setString(2, txtUsuarioTelefone.getText());
            prepared.setString(3, txtUsuarioLogin.getText());
            prepared.setString(4, txtUsuarioSenha.getText());
            prepared.setString(5, cboUsuarioPerfil.getSelectedItem().toString());
            prepared.setString(6, txtUsuarioId.getText());

            if ((txtUsuarioId.getText().isEmpty())
                    || (txtUsuarioNome.getText().isEmpty())
                    || (txtUsuarioLogin.getText().isEmpty())
                    || (txtUsuarioSenha.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null,
                        "Preencha todos os campos obritórios!");
            } else {

                int add = prepared.executeUpdate();

                if (add > 0) {
                    JOptionPane.showMessageDialog(null,
                            "Dados do usuário alterado com sucesso!");
                    txtUsuarioId.setText(null);
                    txtUsuarioNome.setText(null);
                    txtUsuarioTelefone.setText(null);
                    txtUsuarioLogin.setText(null);
                    txtUsuarioSenha.setText(null);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    // Metodo Remover
    private void remove() {
        // Fazendo a confirmação da remoção
        int confirma = JOptionPane.showConfirmDialog(null, 
                "Tem que certeza que deseja remover esse usuário?", 
                "Atenção", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            String sql = "delete from tb_usuarios where id_user=?";
            try {
                prepared = conexao.prepareStatement(sql);
                prepared.setString(1, txtUsuarioId.getText());
                
                // Verificando se foi apagado o usuário
                int clear = prepared.executeUpdate();
                
                if (clear > 0) {
                    JOptionPane.showMessageDialog(null, "Usuário Removido com sucesso!!");
                    txtUsuarioId.setText(null);
                    txtUsuarioNome.setText(null);
                    txtUsuarioTelefone.setText(null);
                    txtUsuarioLogin.setText(null);
                    txtUsuarioSenha.setText(null);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtUsuarioId = new javax.swing.JTextField();
        txtUsuarioSenha = new javax.swing.JTextField();
        txtUsuarioNome = new javax.swing.JTextField();
        cboUsuarioPerfil = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtUsuarioTelefone = new javax.swing.JTextField();
        btnUserCreate = new javax.swing.JButton();
        btnUserRead = new javax.swing.JButton();
        btnUserEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtUsuarioLogin = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Usuários");
        setMinimumSize(new java.awt.Dimension(750, 523));
        setPreferredSize(new java.awt.Dimension(663, 462));

        jLabel1.setText("* ID");

        jLabel2.setText("* Nome");

        jLabel4.setText("* Senha");

        jLabel5.setText("* Perfil");

        cboUsuarioPerfil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "admin", "user" }));

        jLabel6.setText("Telefone");

        btnUserCreate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infox/icones/create.png"))); // NOI18N
        btnUserCreate.setToolTipText("Adicionar");
        btnUserCreate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUserCreate.setPreferredSize(new java.awt.Dimension(80, 80));
        btnUserCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserCreateActionPerformed(evt);
            }
        });

        btnUserRead.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infox/icones/read.png"))); // NOI18N
        btnUserRead.setToolTipText("Consultar");
        btnUserRead.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUserRead.setPreferredSize(new java.awt.Dimension(80, 80));
        btnUserRead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserReadActionPerformed(evt);
            }
        });

        btnUserEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infox/icones/update.png"))); // NOI18N
        btnUserEdit.setToolTipText("Alterar");
        btnUserEdit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUserEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserEditActionPerformed(evt);
            }
        });

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infox/icones/delete.png"))); // NOI18N
        btnDelete.setToolTipText("Remover");
        btnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel7.setText("* Login");

        jLabel3.setText("* Campos obrigatórios");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUsuarioNome)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtUsuarioId, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addGap(123, 123, 123))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(txtUsuarioTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel7))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(txtUsuarioSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(60, 60, 60)
                                        .addComponent(jLabel5)))
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cboUsuarioPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtUsuarioLogin))))))
                .addGap(31, 31, 31))
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(btnUserCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnUserRead, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(btnUserEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(79, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtUsuarioId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel3)))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtUsuarioNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtUsuarioTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtUsuarioLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtUsuarioSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(cboUsuarioPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUserCreate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUserRead, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUserEdit)
                    .addComponent(btnDelete))
                .addContainerGap(58, Short.MAX_VALUE))
        );

        txtUsuarioNome.getAccessibleContext().setAccessibleDescription("");

        setBounds(0, 0, 750, 523);
    }// </editor-fold>                        

    // Chamando o metodo read
    private void btnUserReadActionPerformed(java.awt.event.ActionEvent evt) {                                            
        read();
    }                                           

    // Chamando o metodo create
    private void btnUserCreateActionPerformed(java.awt.event.ActionEvent evt) {                                              
        create();
    }                                             

    // Chamando o metodo editar
    private void btnUserEditActionPerformed(java.awt.event.ActionEvent evt) {                                            
        edit();
    }                                           

    // Chamando o metodo remover
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {                                          
        remove();
    }                                         


    // Variables declaration - do not modify                     
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUserCreate;
    private javax.swing.JButton btnUserEdit;
    private javax.swing.JButton btnUserRead;
    private javax.swing.JComboBox<String> cboUsuarioPerfil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txtUsuarioId;
    private javax.swing.JTextField txtUsuarioLogin;
    private javax.swing.JTextField txtUsuarioNome;
    private javax.swing.JTextField txtUsuarioSenha;
    private javax.swing.JTextField txtUsuarioTelefone;
    // End of variables declaration                   
}
