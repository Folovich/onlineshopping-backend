import java.util.ArrayList;

public class User {
    private ArrayList<Basket> list = new ArrayList<>();
    private String name;
    private int balance;
    private TypeUser type;
    private int password;

    public User(String name, int balance, TypeUser type, int password) {
        this.name = name;
        this.balance = balance;
        this.type = type;
        this.password = password;
    }
    public User(TypeUser type) {
        this.type = type;
    }
}
