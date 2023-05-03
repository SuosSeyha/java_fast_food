package FastFoodReport;
public class Signup extends javax.swing.JFrame {;
    ConnectDB db = new ConnectDB();
    public Signup() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtemail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnregister = new com.k33ptoo.components.KButton();
        jLabel8 = new javax.swing.JLabel();
        txtpassword = new javax.swing.JPasswordField();
        jLabel9 = new javax.swing.JLabel();
        txtcomfirmpassoword = new javax.swing.JPasswordField();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1396, 645));
        getContentPane().setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel1.setText("YOU HAVE NO ACCOUNT YET?");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(960, 550, 210, 20);

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        jLabel2.setText("SIGN UP YOUR ACCOUN");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(970, 190, 300, 50);

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel3.setText("Email");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(920, 230, 160, 50);

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel4.setText("PASSWORD");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(920, 310, 160, 50);

        txtemail.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        txtemail.setForeground(new java.awt.Color(255, 51, 51));
        txtemail.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel2.add(txtemail);
        txtemail.setBounds(920, 270, 340, 40);

        jLabel5.setIcon(new javax.swing.ImageIcon("D:\\Java Programming\\Icon\\UserLogin.png")); // NOI18N
        jPanel2.add(jLabel5);
        jLabel5.setBounds(1040, 80, 100, 110);

        jLabel6.setIcon(new javax.swing.ImageIcon("D:\\Java Programming\\Button\\Very-Basic-Lock-Filled-icon.png")); // NOI18N
        jPanel2.add(jLabel6);
        jLabel6.setBounds(870, 360, 40, 40);

        jLabel7.setIcon(new javax.swing.ImageIcon("D:\\Java Programming\\Button\\User-icon.png")); // NOI18N
        jPanel2.add(jLabel7);
        jLabel7.setBounds(870, 270, 40, 40);

        btnregister.setText("REGISTER");
        btnregister.setToolTipText("");
        btnregister.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        btnregister.setkBorderRadius(30);
        btnregister.setkEndColor(new java.awt.Color(255, 51, 51));
        btnregister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregisterActionPerformed(evt);
            }
        });
        jPanel2.add(btnregister);
        btnregister.setBounds(920, 490, 340, 40);

        jLabel8.setIcon(new javax.swing.ImageIcon("D:\\Java Programming\\Button\\Login.png")); // NOI18N
        jPanel2.add(jLabel8);
        jLabel8.setBounds(10, 0, 730, 640);

        txtpassword.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        txtpassword.setForeground(new java.awt.Color(255, 51, 51));
        txtpassword.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel2.add(txtpassword);
        txtpassword.setBounds(920, 360, 340, 40);

        jLabel9.setIcon(new javax.swing.ImageIcon("D:\\Java Programming\\Button\\Very-Basic-Lock-Filled-icon.png")); // NOI18N
        jPanel2.add(jLabel9);
        jLabel9.setBounds(870, 430, 40, 40);

        txtcomfirmpassoword.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        txtcomfirmpassoword.setForeground(new java.awt.Color(255, 51, 51));
        txtcomfirmpassoword.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel2.add(txtcomfirmpassoword);
        txtcomfirmpassoword.setBounds(920, 430, 340, 40);

        jLabel10.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel10.setText("COMFRIM PASSWORD");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(920, 390, 220, 50);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 1400, 650);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    private void btnregisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregisterActionPerformed
        db.UserRegister(
                txtemail.getText(),
                String.valueOf(txtpassword.getPassword()),
                String.valueOf(txtcomfirmpassoword.getPassword())
        );
        if(db.isCheckSignup()){
            Sigin.main(null);
            dispose();
        }
    }//GEN-LAST:event_btnregisterActionPerformed

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
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Signup().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.k33ptoo.components.KButton btnregister;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField txtcomfirmpassoword;
    private javax.swing.JTextField txtemail;
    private javax.swing.JPasswordField txtpassword;
    // End of variables declaration//GEN-END:variables
}
