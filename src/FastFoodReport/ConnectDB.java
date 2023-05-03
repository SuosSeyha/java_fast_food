package FastFoodReport;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class ConnectDB {
    public boolean isCheckSignup() {
        return CheckSignup;
    }
    public boolean isCheckSignin() {
        return CheckSignin;
    }
    private PreparedStatement ps;
    private ResultSet r;
    private boolean CheckSignin=false;
    private boolean CheckSignup=false;
    // Method connect DB
    public Connection connection(){
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/fastfood11-12","root","");
            System.out.println("Completed.....");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Connection Error: "+e.getMessage());
        }
        return con;
    }
    // Method Fetch DB
    public void FetchUser(){
        try {
            ps=connection().prepareStatement("SELECT * FROM tbusersignin");
            r=ps.executeQuery();
            while(r.next()){
                List_Account.listAcc.add(new List_Account(r.getString("Email"),r.getString("Password")));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    // Method Sigin DB
    public void UserSignin(String email,String password){
        FetchUser();
        boolean isEmail=false;
        boolean isPassword=false;
        for(var i=0;i<List_Account.listAcc.size();i++){
            if(email.equals(List_Account.listAcc.get(i).getEmail())){
                isEmail=true;
            } 
            if(password.equals(List_Account.listAcc.get(i).getPassword())){
                isPassword=true;
            }
        }
        //-------- Email and Password correct -------------
        if(isEmail==true && isPassword==true){
            CheckSignin=true;
            JOptionPane.showMessageDialog(null, "Welcome to sign in...");
            Menu h = new Menu();
            h.setVisible(true);
        }
        //------- Email correct and Password wrong --------
        if(isEmail==true && isPassword==false){
            JOptionPane.showMessageDialog(null, "Incorrect password...!","SIGN IN",JOptionPane.ERROR_MESSAGE);
        }
        //------- Email wrong and Password correct --------
        if(isEmail==false && isPassword==true){
            JOptionPane.showMessageDialog(null, "Incorrect email...!","SIGN IN",JOptionPane.ERROR_MESSAGE);
        }
        //------- Email and Password worng ----------------
        if(isEmail==false && isPassword==false){
            JOptionPane.showMessageDialog(null, "Incorrect email and password...!","SIGN IN",JOptionPane.ERROR_MESSAGE);
        }
        // Clear user in list
        List_Account.listAcc.clear();
    }
    // Method Register
    public void UserRegister(String email,String password,String confirm){
        FetchUser();
        boolean isCheckEmail=false;
        //---------Not Input data--------------------
        if(email.equals("") || password.equals("") || confirm.equals("")){
            JOptionPane.showMessageDialog(null, "Please input data to register", "REGISTER", JOptionPane.ERROR_MESSAGE);
        }else{
            //---------Duplicate Email-------------------
            for(int i=0;i<List_Account.listAcc.size();i++){
                if(email.equals(List_Account.listAcc.get(i).getEmail())){
                    isCheckEmail=true;
                }
            }
            if(isCheckEmail){
                    JOptionPane.showMessageDialog(null, "Email already have....!", "REGISTER", JOptionPane.ERROR_MESSAGE);
                }else{
                  //---------Register successful---------------
                  if(password.equals(confirm)){
                      try {
                          ps=connection().prepareStatement("INSERT INTO tbusersignin(Email,Password) VALUES(?,?)");
                          ps.setString(1, email);
                          ps.setString(2, password);
                          int index = ps.executeUpdate();
                          if(index>0){
                              CheckSignup=true;
                              JOptionPane.showMessageDialog(null, "Accout created...");
                          }else{
                              JOptionPane.showMessageDialog(null, "Error...! create account...", "REGISTER", JOptionPane.ERROR_MESSAGE);
                          }
                      } catch (Exception e) {
                          JOptionPane.showMessageDialog(null, e, "REGISTER", JOptionPane.ERROR_MESSAGE);
                      }
                  }else{
                   //---------confirm not equal password--------
                   JOptionPane.showMessageDialog(null, "Incorrect confirm password...!", "REGISTER", JOptionPane.ERROR_MESSAGE);
                  }
                }
        }
        // Clear user in list
        List_Account.listAcc.clear(); 
    }
    
    //=================================== STOCK DRINK ===============================
    // Method FetchStockDrink
    public void FetchStockDrink(){
        try {
            ps=connection().prepareStatement("SELECT * FROM tbstockdrink");
            r=ps.executeQuery();
            while(r.next()){
                List_StockDrink.liststockdrink.add(new List_StockDrink(
                        r.getInt("Code"),
                        r.getString("Name"),
                        r.getDouble("Price"),
                        r.getString("Image")
                ));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "REGISTER", JOptionPane.ERROR_MESSAGE);
        }
    }
    // Method Add
    public void AddDrink(int code,String name,double price,String image){
        try {
            ps=connection().prepareStatement("INSERT INTO tbstockdrink(Code,Name,Price,Image) VALUES(?,?,?,?)");
            ps.setInt(1, code);
            ps.setString(2, name);
            ps.setDouble(3, price);
            ps.setString(4, image);
            int index = ps.executeUpdate();
            if(index>0){
                JOptionPane.showMessageDialog(null, "Add drink successful...");
            }else{
                JOptionPane.showMessageDialog(null, "Error...! add drink", "DRINK", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "DRINK", JOptionPane.ERROR_MESSAGE);
        }
    }
    // Method Update
    public void UpdateDrink(int code,String name,double price,String image){
        try {
            ps=connection().prepareStatement("UPDATE tbstockdrink SET Name=?,Price=?,Image=? WHERE Code=?");
            ps.setString(1, name);
            ps.setDouble(2,price);
            ps.setString(3,image);
            ps.setInt(4,code);
            int index = ps.executeUpdate();
            if(index>0){
                JOptionPane.showMessageDialog(null, "Update drink successful...");
            }else{
                JOptionPane.showMessageDialog(null, "Error...! update ", "DRINK", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "REGISTER", JOptionPane.ERROR_MESSAGE);
        }
    }
    // Method Remove
    public void RemoveDrink(int code){
        try {
            ps=connection().prepareStatement("DELETE FROM tbstockdrink WHERE Code=?");
            ps.setInt(1, code);
            int index = ps.executeUpdate();
            if(index>0){
                JOptionPane.showMessageDialog(null, "Remove drink successful...");
            }else{
                JOptionPane.showMessageDialog(null, "Error...! remove ", "DRINK", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "DRINK", JOptionPane.ERROR_MESSAGE);
        }
    }
    //============================== Food =====================================
    // Method FetchStockFood
    public void FetchStockFood(){
        try {
            ps=connection().prepareStatement("SELECT * FROM tbstockfood");
            r=ps.executeQuery();
            while(r.next()){
                List_StockFood.liststockfood.add(new List_StockFood(
                        r.getInt("Code"),
                        r.getString("Name"),
                        r.getDouble("Price"),
                        r.getString("Image")
                ));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "FOOD", JOptionPane.ERROR_MESSAGE);
        }
    }
    // Method Add
    public void AddFood(int code,String name,double price,String image){
        try {
            ps=connection().prepareStatement("INSERT INTO tbstockfood(Code,Name,Price,Image) VALUES(?,?,?,?)");
            ps.setInt(1, code);
            ps.setString(2, name);
            ps.setDouble(3, price);
            ps.setString(4, image);
            int index = ps.executeUpdate();
            if(index>0){
                JOptionPane.showMessageDialog(null, "Add food successful...");
            }else{
                JOptionPane.showMessageDialog(null, "Error...! add drink", "FOOD", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "FOOD", JOptionPane.ERROR_MESSAGE);
        }
    }
    // Method Update
    public void UpdateFood(int code,String name,double price,String image){
        try {
            ps=connection().prepareStatement("UPDATE tbstockfood SET Name=?,Price=?,Image=? WHERE Code=?");
            ps.setString(1, name);
            ps.setDouble(2,price);
            ps.setString(3,image);
            ps.setInt(4,code);
            int index = ps.executeUpdate();
            if(index>0){
                JOptionPane.showMessageDialog(null, "Update food successful...");
            }else{
                JOptionPane.showMessageDialog(null, "Error...! food ", "FOOD", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "FOOD", JOptionPane.ERROR_MESSAGE);
        }
    }
    // Method Remove
    public void RemoveFood(int code){
        try {
            ps=connection().prepareStatement("DELETE FROM tbstockfood WHERE Code=?");
            ps.setInt(1, code);
            int index = ps.executeUpdate();
            if(index>0){
                JOptionPane.showMessageDialog(null, "Remove food successful...");
            }else{
                JOptionPane.showMessageDialog(null, "Error...! food ", "FOOD", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "FOOD", JOptionPane.ERROR_MESSAGE);
        }
    }
    //====================== Drink Order ==============================
    public void DrinkOrder(int code,String name,double price,int qty, double amount){
        try {
            if(qty==1){ // Insert(tbdrinkorder)
                // tbdrinkorder
                ps=connection().prepareStatement("INSERT INTO tbdrinkorder(Code,Name,Price,Qty,Amount) VALUES(?,?,?,?,?)");
                ps.setInt(1, code);
                ps.setString(2, name);
                ps.setDouble(3, price);
                ps.setInt(4, qty);
                ps.setDouble(5, amount);
                ps.executeUpdate();
                
            }
            if(qty>=2){ // Update (tbdrinkorder)
                // tbdrink order
                ps=connection().prepareStatement("UPDATE tbdrinkorder SET Qty=?,Amount=? WHERE Code=?");
                ps.setInt(1, qty);
                ps.setDouble(2, amount);
                ps.setInt(3, code);
                ps.executeUpdate(); 
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void DrinkCancel(int code,String name,double price,int qty, double amount){
        try {
            if(qty==0){ // Delete (tbdrinkorder and tbtotalsale)
                // tbdrink order
                ps=connection().prepareStatement("DELETE FROM tbdrinkorder WHERE Code=?");
                ps.setInt(1, code);
                ps.executeUpdate();
                
            }
            if(qty!=0){ // update (tbdrinkorder and tbtotalsale)
                // tbdrink order
                ps=connection().prepareStatement("UPDATE tbdrinkorder SET Qty=?,Amount=? WHERE Code=?");
                ps.setInt(1, qty);
                ps.setDouble(2, amount);
                ps.setInt(3, code);
                ps.executeUpdate(); 
               
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    //======================== Fetch Drink Order ==================
    public void FetchDrinkOrder(){
        try {
            ps=connection().prepareStatement("SElECT * FROM tbdrinkorder");
            r=ps.executeQuery();
            while(r.next()){
                List_DrinkOrder.listdrinkorder.add(new List_DrinkOrder(
                        r.getInt("Code"),
                        r.getString("Name"),
                        r.getDouble("Price"),
                        r.getInt("Qty"),
                        r.getDouble("Amount")
                ));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    // Remove
    public void RemoveDrinkOrder(int code){
        try {
            ps=connection().prepareStatement("DELETE FROM tbdrinkorder WHERE Code=?");
            ps.setInt(1, code);
            int index = ps.executeUpdate();
            if(index>0){
                JOptionPane.showMessageDialog(null, "Remove Successful.");
            }else{
                JOptionPane.showMessageDialog(null, "Error Remove...!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void ResetDrinkOrder(){
         try {
            ps=connection().prepareStatement("DELETE FROM tbdrinkorder");
            int index = ps.executeUpdate();
            if(index>0){
                JOptionPane.showMessageDialog(null, "Reset successful.");
            }else{
                JOptionPane.showMessageDialog(null, "Error Reset...!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    //====================== Food Order 
    public void FoodOrder(int code,String name,double price,int qty, double amount){
        try {
            if(qty==1){ // Insert(tbdrinkorder)
                // tbdrinkorder
                ps=connection().prepareStatement("INSERT INTO tbfoodorder(Code,Name,Price,Qty,Amount) VALUES(?,?,?,?,?)");
                ps.setInt(1, code);
                ps.setString(2, name);
                ps.setDouble(3, price);
                ps.setInt(4, qty);
                ps.setDouble(5, amount);
                ps.executeUpdate();
                
            }
            if(qty>=2){ // Update (tbdrinkorder)
                // tbdrink order
                ps=connection().prepareStatement("UPDATE tbfoodorder SET Qty=?,Amount=? WHERE Code=?");
                ps.setInt(1, qty);
                ps.setDouble(2, amount);
                ps.setInt(3, code);
                ps.executeUpdate(); 
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void FoodCancel(int code,String name,double price,int qty, double amount){
        try {
            if(qty==0){ // Delete (tbdrinkorder and tbtotalsale)
                // tbdrink order
                ps=connection().prepareStatement("DELETE FROM tbfoodorder WHERE Code=?");
                ps.setInt(1, code);
                ps.executeUpdate();
                
            }
            if(qty!=0){ // update (tbdrinkorder and tbtotalsale)
                // tbdrink order
                ps=connection().prepareStatement("UPDATE tbfoodorder SET Qty=?,Amount=? WHERE Code=?");
                ps.setInt(1, qty);
                ps.setDouble(2, amount);
                ps.setInt(3, code);
                ps.executeUpdate(); 
               
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    //======================== Fetch Drink Order ==================
    public void FetchFoodOrder(){
        try {
            ps=connection().prepareStatement("SElECT * FROM tbfoodorder");
            r=ps.executeQuery();
            while(r.next()){
                List_FoodOrder.listfoodroder.add(new List_FoodOrder(
                        r.getInt("Code"),
                        r.getString("Name"),
                        r.getDouble("Price"),
                        r.getInt("Qty"),
                        r.getDouble("Amount")
                ));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    // Remove
    public void RemoveFoodOrder(int code){
        try {
            ps=connection().prepareStatement("DELETE FROM tbfoodorder WHERE Code=?");
            ps.setInt(1, code);
            int index = ps.executeUpdate();
            if(index>0){
                JOptionPane.showMessageDialog(null, "Remove Successful.");
            }else{
                JOptionPane.showMessageDialog(null, "Error Remove...!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void ResetFoodOrder(){
         try {
            ps=connection().prepareStatement("DELETE FROM tbfoodorder");
            int index = ps.executeUpdate();
            if(index>0){
                JOptionPane.showMessageDialog(null, "Reset successful.");
            }else{
                JOptionPane.showMessageDialog(null, "Error Reset...!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    //=========================Total Sale
    public void CalculatorTotalSale(){
        FetchDrinkOrder();
        FetchFoodOrder();
         for(List_DrinkOrder temp : List_DrinkOrder.listdrinkorder){
           List_Totalsale.listtotalsale.add(new List_Totalsale(
                   temp.getCode(),
                   temp.getName(),
                   temp.getPrice(),
                   temp.getQty(),
                   temp.getAmount()
           ));
        }
         for(List_FoodOrder temp : List_FoodOrder.listfoodroder){
           List_Totalsale.listtotalsale.add(new List_Totalsale(
                   temp.getCode(),
                   temp.getName(),
                   temp.getPrice(),
                   temp.getQty(),
                   temp.getAmount()
           ));
        }
           // Clear
        List_DrinkOrder.listdrinkorder.clear();
        List_FoodOrder.listfoodroder.clear();
        //List_Totalsale.listtotalsale.clear();
    }
    public void AddTotalsale(){
        // add to db
        for(int i=0;i<List_Totalsale.listtotalsale.size();i++){
            try {
                ps=connection().prepareStatement("INSERT INTO tbtotalsale(Code,Name,Price,Qty,Amount) VALUES(?,?,?,?,?)");
                ps.setInt(1, List_Totalsale.listtotalsale.get(i).getCode());
                ps.setString(2, List_Totalsale.listtotalsale.get(i).getName());
                ps.setDouble(3, List_Totalsale.listtotalsale.get(i).getPrice());
                ps.setInt(4, List_Totalsale.listtotalsale.get(i).getQty());
                ps.setDouble(5, List_Totalsale.listtotalsale.get(i).getAmount());
                ps.executeUpdate();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }
    public void GetTotalSale(){
        try {
            ps=connection().prepareStatement("SELECT * FROM tbtotalsale");
            r=ps.executeQuery();
            while(r.next()){
                List_Totalsale.listtotalsale.add(new List_Totalsale(
                        r.getInt("Code"),
                        r.getString("Name"),
                        r.getDouble("Price"),
                        r.getInt("Qty"),
                        r.getDouble("Amount")
                ));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
