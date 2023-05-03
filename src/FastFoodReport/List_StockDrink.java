package FastFoodReport;

import java.util.ArrayList;

public class List_StockDrink {
    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public double getPrice() {
        return price;
    }
    private int code;
    private String name,image;
    private double price;

    public List_StockDrink(int code, String name, double price,String image) {
        this.code = code;
        this.name = name;
        this.image = image;
        this.price = price;
    }
    static ArrayList<List_StockDrink> liststockdrink = new ArrayList<>();
    
}
