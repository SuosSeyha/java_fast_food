package FastFoodReport;

import java.util.ArrayList;

public class List_DrinkOrder {

    /**
     * @return the code
     */
    public int getCode() {
        return code;
    }

    /**
     * @return the qty
     */
    public int getQty() {
        return qty;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }
    private int code,qty;
    private String name;
    private double price,amount;

    public List_DrinkOrder(int code, String name, double price,int qty, double amount) {
        this.code = code;
        this.qty = qty;
        this.name = name;
        this.price = price;
        this.amount = amount;
    }
    static ArrayList<List_DrinkOrder> listdrinkorder = new ArrayList<>();
    
}
