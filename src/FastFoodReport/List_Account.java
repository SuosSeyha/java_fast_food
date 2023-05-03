package FastFoodReport;
import java.util.ArrayList;
public class List_Account {
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    private String email,password;

    public List_Account(String email, String password) {
        this.email = email;
        this.password = password;
    }
    static ArrayList<List_Account> listAcc = new ArrayList<>();
}
