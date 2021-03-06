package javacovid19app.ManagedUser.ManagedUserHomePage.ChangePassword;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javacovid19app.ManagedUser.ManagedUserHomePage.ManagedUserHomePage;
import javax.swing.JOptionPane;
import org.springframework.security.crypto.bcrypt.BCrypt;


public class ChangePassword extends javax.swing.JFrame {

    String userID="";
    /**
     * Creates new form ChangePassword
     */
    public ChangePassword() {
        initComponents();
        this.setResizable(false);
        setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
    }
    
    public ChangePassword(String username) {
        initComponents();
        this.userID=username;
        this.setTitle("Covid 19 Change Password Menu");
        this.setResizable(false);
        setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backLabel = new javax.swing.JLabel();
        confirmBtnLabel = new javax.swing.JLabel();
        oldPasswordField = new javax.swing.JPasswordField();
        newPasswordField = new javax.swing.JPasswordField();
        confirmPasswordField = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        backLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backLabelMouseClicked(evt);
            }
        });
        getContentPane().add(backLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 70, 60));

        confirmBtnLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                confirmBtnLabelMouseClicked(evt);
            }
        });
        getContentPane().add(confirmBtnLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 460, 160, 60));

        oldPasswordField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        oldPasswordField.setBorder(null);
        oldPasswordField.setOpaque(false);
        getContentPane().add(oldPasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 170, 290, 30));

        newPasswordField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        newPasswordField.setBorder(null);
        newPasswordField.setOpaque(false);
        newPasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newPasswordFieldActionPerformed(evt);
            }
        });
        getContentPane().add(newPasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 270, 290, 30));

        confirmPasswordField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        confirmPasswordField.setBorder(null);
        confirmPasswordField.setOpaque(false);
        confirmPasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmPasswordFieldActionPerformed(evt);
            }
        });
        getContentPane().add(confirmPasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 370, 230, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javacovid19app/ManagedUser/ManagedUserHomePage/ChangePassword/UserChangePasswordBackground.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 3, 960, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backLabelMouseClicked
        ManagedUserHomePage homepage = new ManagedUserHomePage(userID);                
        homepage.show();
        dispose();
    }//GEN-LAST:event_backLabelMouseClicked

    private void confirmBtnLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmBtnLabelMouseClicked
        // TODO add your handling code here:
        // if User click Sign In
        // TODO add your handling code here:
        // check account for login admin services.

        String oldPassword = oldPasswordField.getText();
        String newPassword = newPasswordField.getText();
        String confirmPassword=confirmPasswordField.getText();

        if (oldPassword.isEmpty() && newPassword.isEmpty() && confirmPassword.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please provide old,new and confirm password!");
        } else {
            try {
                //use SQL Query to update admin password.
                Class.forName("com.mysql.jdbc.Driver");
                Connection connect = DriverManager.getConnection("jdbc:mysql://sql6.freemysqlhosting.net:3306/sql6448649?useSSL = true", "sql6448649", "ygTCgTJZu6");
                Statement state = connect.createStatement();

                String sql = "Select Password from Account where UserID = '" + userID + "' and Type = 3";
                ResultSet res = state.executeQuery(sql);

                if (res.next()) {
                    String real_pass = res.getString(1);
                    System.out.println(real_pass);
                    if (BCrypt.checkpw(oldPassword, real_pass) == true && newPassword.compareTo(confirmPassword)==0) {
                        String hashPass=BCrypt.hashpw(newPassword,BCrypt.gensalt(12));
                        System.out.println(hashPass);
                       
                        sql="UPDATE Account SET Password= '"+ hashPass +"' WHERE UserID= '" + userID + "'";
                        int rowAffect=state.executeUpdate(sql);
                        if(rowAffect==1){
                            JOptionPane.showMessageDialog(this, "Change Password Succesfully!");
                            oldPasswordField.setText("");
                            newPasswordField.setText("");
                            confirmPasswordField.setText("");
                        }
                        else{
                            JOptionPane.showMessageDialog(this, "Wrong password!");
                            oldPasswordField.setText("");
                            newPasswordField.setText("");
                            confirmPasswordField.setText("");
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Wrong password!");
                        oldPasswordField.setText("");
                        newPasswordField.setText("");
                        confirmPasswordField.setText("");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Wrong password!");
                    oldPasswordField.setText("");
                    newPasswordField.setText("");
                    confirmPasswordField.setText("");
                }
                connect.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }//GEN-LAST:event_confirmBtnLabelMouseClicked

    private void newPasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newPasswordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newPasswordFieldActionPerformed

    private void confirmPasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmPasswordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_confirmPasswordFieldActionPerformed

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
            java.util.logging.Logger.getLogger(ChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChangePassword().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backLabel;
    private javax.swing.JLabel confirmBtnLabel;
    private javax.swing.JPasswordField confirmPasswordField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPasswordField newPasswordField;
    private javax.swing.JPasswordField oldPasswordField;
    // End of variables declaration//GEN-END:variables
}
