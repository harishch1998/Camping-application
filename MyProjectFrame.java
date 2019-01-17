/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package camping.org;
import static camping.org.RegisterFrame.PASS;
import static camping.org.RegisterFrame.URL;
import static camping.org.RegisterFrame.USER;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author harish
 */
public class MyProjectFrame extends javax.swing.JFrame {

    /**
     * Creates new form MyProjectFrame
     */
    public MyProjectFrame() {
        
        initComponents();
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        register = new javax.swing.JButton();
        login = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        usernametext = new javax.swing.JTextField();
        passwordtext = new javax.swing.JPasswordField();
        backgroundimage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(9, 243, 252));
        getContentPane().setLayout(null);

        register.setText("Register");
        register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerActionPerformed(evt);
            }
        });
        getContentPane().add(register);
        register.setBounds(350, 230, 100, 29);

        login.setText("Log in ");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        getContentPane().add(login);
        login.setBounds(510, 230, 80, 29);

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel2.setText("username");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(240, 90, 85, 21);

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel3.setText("password");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(240, 160, 83, 21);

        usernametext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernametextActionPerformed(evt);
            }
        });
        getContentPane().add(usernametext);
        usernametext.setBounds(350, 90, 235, 27);

        passwordtext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordtextActionPerformed(evt);
            }
        });
        getContentPane().add(passwordtext);
        passwordtext.setBounds(350, 160, 235, 27);

        backgroundimage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myproject/Camps wild.jpg"))); // NOI18N
        getContentPane().add(backgroundimage);
        backgroundimage.setBounds(60, 10, 700, 470);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usernametextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernametextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernametextActionPerformed

    private void registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerActionPerformed

        dispose();
        new RegisterFrame().setVisible(true);
       
    }//GEN-LAST:event_registerActionPerformed

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
            
            
            
            String currusername = null;
            String currpassword = null;
            currusername = usernametext.getText();
            currpassword = passwordtext.getText();
            if(currusername.equals("admin") && currpassword.equals("admin"))
                {
                    dispose();
                    new AdminPage().setVisible(true);
                }
            else
            {
            Connection conn = null;
            Statement stmt = null;
            try{
                System.out.println("username:"+currusername +" password:" +currpassword);
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(URL,USER,PASS);
            System.out.println("Connected database successfully...");
            stmt = conn.createStatement();
            String query = " select password from userData where username = '"+currusername+"';";
            
            ResultSet rs = stmt.executeQuery(query);
            
            rs.next();
            
                String password = rs.getString(1);
                System.out.println(password);
                if (password.equals(currpassword))
            
                {
                         dispose();
                
                         new HomeFrame(currusername).setVisible(true);
                
                        JOptionPane.showMessageDialog(null, 
                        "Login successful", 
                        "Welcome!", 
                        JOptionPane.INFORMATION_MESSAGE);
                }
            
                else
                {
                    JOptionPane.showMessageDialog(null, 
                    "Username or password incorrect", 
                    "Error!", 
                    JOptionPane.WARNING_MESSAGE);

                }
                
            }
            catch(SQLException se){
      //Handle errors for JDBC
                    
                JOptionPane.showMessageDialog(null, 
                              "Username or password incorrect", 
                              "Error!", 
                              JOptionPane.WARNING_MESSAGE);
            se.printStackTrace();
            }catch(Exception e){
      //Handle errors for Class.forName
            e.printStackTrace();
            }
            }
    }//GEN-LAST:event_loginActionPerformed

    private void passwordtextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordtextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordtextActionPerformed
    
  
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
            java.util.logging.Logger.getLogger(MyProjectFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MyProjectFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MyProjectFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MyProjectFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MyProjectFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backgroundimage;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton login;
    private javax.swing.JPasswordField passwordtext;
    private javax.swing.JButton register;
    private javax.swing.JTextField usernametext;
    // End of variables declaration//GEN-END:variables
}
