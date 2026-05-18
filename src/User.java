import java.util.ArrayList;

public class User { ;
    private String name;
    private int balance;
    private final TypeUser type;
    private int password;
    private Basket basket;

    public User(String name, TypeUser type, int password) {
        this.name = name;
        this.type = type;
        this.password = password;
        this.basket = new Basket(this);
    }
    public User(TypeUser type) {
        this.type = type;
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
