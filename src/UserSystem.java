import java.util.*;

public class UserSystem { ;
    private String name;
    private int balance;
    private final TypeUser type;
    private int password;

    private Basket basket = new Basket(this);

    private static Map<String, UserSystem> users = new HashMap<>();
    private static UserSystem currentUser = new UserSystem(TypeUser.GUEST);

    public UserSystem(String name, TypeUser type, int password) {
        this.name = name;
        this.type = type;
        this.password = password;
        users.put(name, this);
        this.basket = new Basket(this);
    }

    public UserSystem(TypeUser type) {
        this.type = type;
    }

    public static String registr(String name, int passw){
        currentUser = new UserSystem(name,TypeUser.USER,passw);
        users.put(name, currentUser);
        return "вы успешно зашли " + UserSystem.getCurrentUser().getName();
    }

    public static void setCurrentUser(UserSystem currentUser) {
        UserSystem.currentUser = currentUser;
    }

    public static UserSystem getCurrentUser() {
        return currentUser;
    }

    public static Map<String, UserSystem> getUsers() {
        return users;
    }



    public void setBalance(int money){
        this.balance += money;
    }

    public int getBalance() {
        return balance;
    }

    public Basket getBasket() {
        return basket;
    }

    public TypeUser getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public boolean checkPasswd(int passwd){
        if(passwd == this.password){
            return true;
        } else{
            return false;
        }
    }

    @Override
    public String toString() {
        return "Имя: " + name + "\n" +
                "Баланс: " + balance + "\n" +
                "Тип учетной записи: " + type;
    }
}
