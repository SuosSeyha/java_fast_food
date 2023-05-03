package FastFoodReport;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
public class Payment extends javax.swing.JFrame {
    private ConnectDB db = new ConnectDB();
    private DefaultTableModel model;
    private double total=0,discount,disprice,payment,cash_receive,cash_return;
    private DecimalFormat df = new DecimalFormat("###0.00$");
    public Payment() {
       initComponents();
       model = (DefaultTableModel) tbtable.getModel();
       GetDrinkAndFoodOrder();
       payment=total;
       txtpayment.setText(String.valueOf(payment)+"$");
       txtdisprice.setText("0.00$");
    }
    private void GetDrinkAndFoodOrder(){
        //------------Drink
        db.FetchDrinkOrder();
        int no=0;
        model.setRowCount(0);
        for(int i=0;i<List_DrinkOrder.listdrinkorder.size();i++){
            Object row[]={
                ++no,
                List_DrinkOrder.listdrinkorder.get(i).getCode(),
                List_DrinkOrder.listdrinkorder.get(i).getName(),
                List_DrinkOrder.listdrinkorder.get(i).getPrice()+"$",
                List_DrinkOrder.listdrinkorder.get(i).getQty(),
                List_DrinkOrder.listdrinkorder.get(i).getAmount()+"$"
            };
            model.addRow(row);
            total+=List_DrinkOrder.listdrinkorder.get(i).getAmount();
        }
        txttotal.setText(String.valueOf(total)+"$");
        List_DrinkOrder.listdrinkorder.clear();
        //-------------Food
        db.FetchFoodOrder();
        for(int i=0;i<List_FoodOrder.listfoodroder.size();i++){
            Object row[]={
                ++no,
                List_FoodOrder.listfoodroder.get(i).getCode(),
                List_FoodOrder.listfoodroder.get(i).getName(),
                List_FoodOrder.listfoodroder.get(i).getPrice()+"$",
                List_FoodOrder.listfoodroder.get(i).getQty(),
                List_FoodOrder.listfoodroder.get(i).getAmount()+"$"
            };
            model.addRow(row);
            total+=List_FoodOrder.listfoodroder.get(i).getAmount();
        }
        txttotal.setText(String.valueOf(total)+"$");
        List_FoodOrder.listfoodroder.clear();
    }
    


 
    
   
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbtable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtreturn = new javax.swing.JTextField();
        txtpayment = new javax.swing.JTextField();
        txttotal = new javax.swing.JTextField();
        txtreceived = new javax.swing.JTextField();
        cbdiscount = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        txtdisprice = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btncash = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1127, 678));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        tbtable.setBackground(new java.awt.Color(153, 255, 153));
        tbtable.setFont(new java.awt.Font("sansserif", 0, 16)); // NOI18N
        tbtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Code", "Name", "Price", "Qty", "Amount"
            }
        ));
        jScrollPane1.setViewportView(tbtable);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(480, 170, 590, 270);

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel3.setText("Cash Return");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(50, 480, 140, 40);

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel4.setText("Total ");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(50, 170, 140, 40);

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel5.setText("Discount % ");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(50, 230, 140, 40);

        jLabel6.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel6.setText("Disprice :");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(50, 290, 140, 40);

        jLabel7.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel7.setText("Payment  ");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(50, 350, 140, 40);

        jLabel8.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel8.setText("Cash Received");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(50, 410, 140, 40);

        txtreturn.setEditable(false);
        txtreturn.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        getContentPane().add(txtreturn);
        txtreturn.setBounds(210, 480, 220, 40);

        txtpayment.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        getContentPane().add(txtpayment);
        txtpayment.setBounds(210, 350, 220, 40);

        txttotal.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        getContentPane().add(txttotal);
        txttotal.setBounds(210, 170, 220, 40);

        txtreceived.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        txtreceived.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtreceivedKeyReleased(evt);
            }
        });
        getContentPane().add(txtreceived);
        txtreceived.setBounds(210, 410, 220, 40);

        cbdiscount.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        cbdiscount.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0%", "10%", "20%", "30%", "40%", "50%" }));
        cbdiscount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbdiscountActionPerformed(evt);
            }
        });
        getContentPane().add(cbdiscount);
        cbdiscount.setBounds(210, 230, 220, 40);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        txtdisprice.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jPanel1.add(txtdisprice);
        txtdisprice.setBounds(210, 280, 220, 40);

        jPanel3.setBackground(new java.awt.Color(255, 204, 204));

        jButton3.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jButton3.setText("Back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jButton2.setText("Payment");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btncash.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        btncash.setText("Cash");
        btncash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncashActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        jLabel1.setText("Payment ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(btncash, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(620, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 437, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btncash, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(90, 90, 90))
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(0, 0, 1130, 690);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1130, 680);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 100, 100);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    }//GEN-LAST:event_formWindowOpened

    private void cbdiscountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbdiscountActionPerformed
       String sdiscount = cbdiscount.getSelectedItem().toString();//10%
       sdiscount=sdiscount.replace("%", "");//10
       discount=Double.parseDouble(sdiscount);
       disprice=total*discount/100;
       payment = total-disprice;
       txtdisprice.setText(String.valueOf(disprice)+"$");
       txtpayment.setText(String.valueOf(payment)+"$");
    }//GEN-LAST:event_cbdiscountActionPerformed

    private void txtreceivedKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtreceivedKeyReleased
     
    }//GEN-LAST:event_txtreceivedKeyReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
     Menu.main(null);
     dispose();
    }//GEN-LAST:event_jButton3ActionPerformed
    private Collection data(){
        ArrayList<List_Totalsale> lr = new ArrayList<>();
        for(List_Totalsale temp : List_Totalsale.listtotalsale){
            int code = temp.getCode();
            String name = temp.getName();
            double price = temp.getPrice();
            int qty = temp.getQty();
            double amount = temp.getAmount();
            lr.add(new List_Totalsale(code, name, price, qty, amount));
        }
        return lr;
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
//       if(List_Totalsale.listtotalsale.isEmpty()){
//            db.FetchTotalsale();
//       }
         db.CalculatorTotalSale();
         db.AddTotalsale();
         
       // Report
       try {
            JasperReport jp = JasperCompileManager.compileReport("Report/myreport.jrxml");
            HashMap pr = new HashMap();
            pr.put("total", total);
            pr.put("discount", discount/100);
            pr.put("disprice", disprice);
            pr.put("payment", payment);
            pr.put("cash_receive", cash_receive);
            pr.put("cash_return", cash_return);
            JRBeanCollectionDataSource jcd = new JRBeanCollectionDataSource(data());
            JasperPrint price = JasperFillManager.fillReport(jp, pr,jcd);
           JasperViewer.viewReport(price,false);
           
            //JasperPrintManager.printReport(price, true);
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(this, e);
            System.out.println("=>>>>>>>>>>>>>"+e);
        }
       List_Totalsale.listtotalsale.clear();
      
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btncashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncashActionPerformed
        
        cash_receive = Double.parseDouble(txtreceived.getText());
        cash_return = cash_receive-payment;
        txtreturn.setText(df.format(cash_return));
        if(cash_receive<payment){
            JOptionPane.showMessageDialog(null, "Cash receive not enough\n you need to pay "+df.format(payment-cash_receive),"Payment",JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btncashActionPerformed

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
            java.util.logging.Logger.getLogger(Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Payment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncash;
    private javax.swing.JComboBox<String> cbdiscount;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbtable;
    private javax.swing.JTextField txtdisprice;
    private javax.swing.JTextField txtpayment;
    private javax.swing.JTextField txtreceived;
    private javax.swing.JTextField txtreturn;
    private javax.swing.JTextField txttotal;
    // End of variables declaration//GEN-END:variables
}
