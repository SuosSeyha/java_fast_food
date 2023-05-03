package FastFoodReport;
import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AddFoodStock extends javax.swing.JFrame {
    private ConnectDB db = new ConnectDB();
    private DefaultTableModel model;
    public AddFoodStock() {
        initComponents();
        model = (DefaultTableModel) tbtable.getModel();
        GetFood();
    }
    private void GetFood(){
        db.FetchStockFood();
        model.setRowCount(0);
        for(int i=0;i<List_StockFood.liststockfood.size();i++){
            Object row[]={
                List_StockFood.liststockfood.get(i).getCode(),
                List_StockFood.liststockfood.get(i).getName(),
                List_StockFood.liststockfood.get(i).getPrice(),
                List_StockFood.liststockfood.get(i).getImage(),
            };
            model.addRow(row);
        }
        List_StockFood.liststockfood.clear();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnback = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbtable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtimage = new javax.swing.JTextField();
        txtcode = new javax.swing.JTextField();
        txtname = new javax.swing.JTextField();
        lbimage = new javax.swing.JLabel();
        txtprice = new javax.swing.JTextField();
        btnimage = new javax.swing.JButton();
        btnremove = new javax.swing.JButton();
        btnadd = new javax.swing.JButton();
        btnupdate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1389, 430));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setLayout(null);

        btnback.setBackground(new java.awt.Color(255, 51, 51));
        btnback.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        btnback.setText("Back");
        btnback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackActionPerformed(evt);
            }
        });
        jPanel1.add(btnback);
        btnback.setBounds(10, 10, 80, 31);

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 36)); // NOI18N
        jLabel1.setText("STOCK FOOD");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(120, 30, 320, 60);

        tbtable.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        tbtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Code", "Name", "Price", "Image"
            }
        ));
        tbtable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbtableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbtable);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(40, 110, 570, 210);

        jLabel2.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel2.setText("Name ");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(660, 170, 90, 40);

        jLabel3.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel3.setText("Code ");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(660, 120, 90, 40);

        jLabel4.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel4.setText("Price");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(660, 220, 90, 40);

        txtimage.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jPanel1.add(txtimage);
        txtimage.setBounds(1110, 230, 200, 30);

        txtcode.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jPanel1.add(txtcode);
        txtcode.setBounds(740, 130, 210, 30);

        txtname.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jPanel1.add(txtname);
        txtname.setBounds(740, 180, 210, 30);

        lbimage.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(lbimage);
        lbimage.setBounds(970, 120, 130, 140);

        txtprice.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jPanel1.add(txtprice);
        txtprice.setBounds(740, 230, 210, 30);

        btnimage.setText("Image");
        btnimage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnimageActionPerformed(evt);
            }
        });
        jPanel1.add(btnimage);
        btnimage.setBounds(1110, 200, 73, 28);

        btnremove.setBackground(new java.awt.Color(255, 153, 153));
        btnremove.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        btnremove.setText("Remove");
        btnremove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnremoveActionPerformed(evt);
            }
        });
        jPanel1.add(btnremove);
        btnremove.setBounds(970, 290, 110, 40);

        btnadd.setBackground(new java.awt.Color(255, 153, 153));
        btnadd.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        btnadd.setText("Add");
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });
        jPanel1.add(btnadd);
        btnadd.setBounds(670, 290, 110, 40);

        btnupdate.setBackground(new java.awt.Color(255, 153, 153));
        btnupdate.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        btnupdate.setText("Update");
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });
        jPanel1.add(btnupdate);
        btnupdate.setBounds(820, 290, 110, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1390, 430);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed
        AddStockMenu.main(null);
        dispose();
    }//GEN-LAST:event_btnbackActionPerformed

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
        int code = Integer.parseInt(txtcode.getText());
        String name = txtname.getText();
        double price = Double.parseDouble(txtprice.getText());
        String image = txtimage.getText();
        db.AddFood(code,name,price,image);
        GetFood();
        Clear();
    }//GEN-LAST:event_btnaddActionPerformed
    private ImageIcon resizeImage(String imagePath,byte[] pic){
        ImageIcon myImage;
        if(imagePath!=null){
            myImage = new ImageIcon(imagePath);
        }else{
            myImage = new ImageIcon(pic);
        }
        Image img = myImage.getImage();
        Image img1 =img.getScaledInstance(lbimage.getWidth(), lbimage.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(img1);
         return image;
    }
    private void btnimageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnimageActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        String filename = f.getAbsolutePath();
        txtimage.setText(filename);
        lbimage.setIcon(resizeImage(filename, null));
    }//GEN-LAST:event_btnimageActionPerformed

    private void tbtableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbtableMouseClicked
        int row = tbtable.getSelectedRow();
        txtcode.setText(model.getValueAt(row, 0).toString());
        txtname.setText(model.getValueAt(row, 1).toString());
        txtprice.setText(model.getValueAt(row, 2).toString());
        txtimage.setText(model.getValueAt(row, 3).toString());
        lbimage.setIcon(resizeImage(model.getValueAt(row, 3).toString(), null));
    }//GEN-LAST:event_tbtableMouseClicked
    private void Clear(){
        txtcode.setText("");
        txtname.setText("");
        txtprice.setText("");
        txtimage.setText("");
        lbimage.setIcon(null);
    }
    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        if(JOptionPane.showConfirmDialog(null, "Do you want to update?", "UPDATE FOOD", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION){
            int code = Integer.parseInt(txtcode.getText());
            String name = txtname.getText();
            double price = Double.parseDouble(txtprice.getText());
            String image = txtimage.getText();
            db.UpdateFood(code,name,price,image);
            GetFood();
            Clear();
        }
    }//GEN-LAST:event_btnupdateActionPerformed

    private void btnremoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnremoveActionPerformed
        if(JOptionPane.showConfirmDialog(null, "Do you want to remove?", "UPDATE FOOD", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION){
            db.RemoveFood(Integer.parseInt(txtcode.getText()));
            GetFood();
            Clear();
        }
       
    }//GEN-LAST:event_btnremoveActionPerformed

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
            java.util.logging.Logger.getLogger(AddFoodStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddFoodStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddFoodStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddFoodStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddFoodStock().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnadd;
    private javax.swing.JButton btnback;
    private javax.swing.JButton btnimage;
    private javax.swing.JButton btnremove;
    private javax.swing.JButton btnupdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbimage;
    private javax.swing.JTable tbtable;
    private javax.swing.JTextField txtcode;
    private javax.swing.JTextField txtimage;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtprice;
    // End of variables declaration//GEN-END:variables
}
