import java.util.ArrayList;
import java.util.List;

public class Basket {
    private static  List<Product> products;
    private static ArrayList<Object> list = new ArrayList<>();
    private static Status status = Status.UNPAID;
    private static int money;
    public void add(String title, Product product){
        list.add(title);
        list.add(product);
    }

    public void pay(){
        status = Status.PAID;
    }

    public void check(){
        if(list.isEmpty()){
            System.out.println("Корзина пуста");
        }
        System.out.println("----- Корзина -----");
        System.out.println("Статус: " + status);
        System.out.println("В корзине:");
        for (int i = 0; i < list.size() - 1; i += 2){
            System.out.print(list.get(i) + ": ");
            System.out.println(list.get(i + 1));
        }
    }

}
