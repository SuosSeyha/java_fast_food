package FastFoodReport;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
public class FoodModel extends javax.swing.JPanel {
    
//    public void FindWidthHeigh(){
//        JOptionPane.showMessageDialog(null, "Width ="+lbimage.getWidth());
//        JOptionPane.showMessageDialog(null, "Heigh ="+lbimage.getHeight());
//    }
    private ImageIcon resizeImage(String imagePath,byte[] pic){
        ImageIcon myImage;
        if(imagePath!=null){
            myImage = new ImageIcon(imagePath);
        }else{
            myImage = new ImageIcon(pic);
        }
        Image img = myImage.getImage();
        Image img1 =img.getScaledInstance(255, 137,Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(img1);
         return image;
    }
    public void setCode(int code) {
        this.code = code;
        lbcode.setText(lbcode.getText()+String.valueOf(code));
    }
    public void setName(String name) {
        this.name = name;
        lbname.setText(lbname.getText()+name);
    }
    public void setImage(String image) {
        this.image = image;
        lbimage.setIcon(resizeImage(image, null));
    }
    public void setPrice(double price) {
        this.price = price;
        lbprice.setText(lbprice.getText()+String.valueOf(price)+"$");
    }
    private int code,qty=0;
    private String name,image;
    private double price;
    private ConnectDB db = new ConnectDB();
    public FoodModel() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbimage = new javax.swing.JLabel();
        lbcode = new javax.swing.JLabel();
        lbname = new javax.swing.JLabel();
        lbprice = new javax.swing.JLabel();
        btnadd = new javax.swing.JButton();
        btnsub = new javax.swing.JButton();
        lbqty = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 255, 204));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2));

        lbimage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbcode.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        lbcode.setText("Code : ");

        lbname.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        lbname.setText("Name : ");

        lbprice.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        lbprice.setText("Price : ");

        btnadd.setBackground(new java.awt.Color(0, 153, 153));
        btnadd.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        btnadd.setText("+");
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });

        btnsub.setBackground(new java.awt.Color(255, 102, 102));
        btnsub.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        btnsub.setText("-");
        btnsub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsubActionPerformed(evt);
            }
        });

        lbqty.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        lbqty.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbqty.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lbimage, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(lbcode, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(lbname, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(lbprice, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(btnsub, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(lbqty, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btnadd, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(lbimage, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(lbcode, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(lbname, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(lbprice, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnsub)
                    .addComponent(lbqty)
                    .addComponent(btnadd))
                .addContainerGap(42, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
        qty++;
        lbqty.setText(String.valueOf(qty));
        db.FoodOrder(code,name,price,qty,price*qty);
    }//GEN-LAST:event_btnaddActionPerformed

    private void btnsubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsubActionPerformed
        qty--; //qty=3 2 1 0 -1 
        if(qty>=0){
            lbqty.setText(String.valueOf(qty));
            
        }else{
            qty=0;
        }
        db.FoodCancel(code, name, price, qty, price*qty);
    }//GEN-LAST:event_btnsubActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnadd;
    private javax.swing.JButton btnsub;
    private javax.swing.JLabel lbcode;
    private javax.swing.JLabel lbimage;
    private javax.swing.JLabel lbname;
    private javax.swing.JLabel lbprice;
    private javax.swing.JLabel lbqty;
    // End of variables declaration//GEN-END:variables
}
