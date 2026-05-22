import java.util.ArrayList;
import java.util.List;

public class Basket {
    private  List<Product> products;
    private  ArrayList<Object> list = new ArrayList<>();
    private  ArrayList<Object> listPaid = new ArrayList<>();
    private  int money;
    private UserSystem owner;
    public Basket(UserSystem owner){
        this.owner = owner;
        this.products = new ArrayList<>();
    }
    public void add(String title, Product product){
        list.add(title);
        list.add(product);
        this.products.add(product);
    }

    public String pay(){
        int cost = 0;
        for (Product er : products){
            cost += (er.getPrice() * er.getQuant());
        }
        if(owner.getBalance() < cost){
            return "Недостаточно баланса";
        }
        owner.setBalance(-cost);
        for (int i = 0; i < list.size() - 1; i += 2){
            listPaid.add(list.get(i));
            listPaid.add(list.get(i + 1));
        }
        list.clear();
        return "Успешная покупка";
    }

    public void check(){
        if(list.isEmpty()){
            System.out.println("Корзина пуста");
            return;
        }
        System.out.println("----- Корзина -----");
        for (int i = 0; i < list.size() - 1; i += 2){
            System.out.print(list.get(i) + ": ");
            System.out.println(list.get(i + 1));
        }
    }
    public void checkPaid(){
        if(list.isEmpty()){
            System.out.println("Ничего не было куплено");
            return;
        }
        System.out.println("----- История покупок -----");
        for (int i = 0; i < list.size() - 1; i += 2){
            System.out.print(list.get(i) + ": ");
            System.out.println(list.get(i + 1));
        }
    }

}
