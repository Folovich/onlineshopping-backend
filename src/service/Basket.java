import java.awt.*;
import java.util.*;
import java.util.List;

public class Basket {
    private Map<Product,Integer> products;
    private UserSystem owner;
    public Basket(UserSystem owner){
        this.owner = owner;
        this.products = new HashMap<>();
    }
    public void add(Product product){
        products.put(product, products.getOrDefault(product, 0) + 1);
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void pay(Scanner scanner){
        System.out.println("0. Выход | 1. Картой | 2. Кредиткой");
        int choice = scanner.nextInt();
        if(choice == 1){
            PaymentStrategy strategy = new CardPayment();
            TransactionService transaction = new TransactionService(strategy);
            if(transaction.checkout(products, owner)){
                products.clear();
            }
        }else if (choice == 2) {
            PaymentStrategy strategy = new CreditPayment();
            TransactionService transaction = new TransactionService(strategy);
            if(transaction.checkout(products, owner)){
                products.clear();
            }
        } else{
            return;
        }
    }

    public void check(){
        System.out.println("----- Корзина -----");
        // Итерируемся по парам Товар-Количество из HashMap
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            System.out.println(entry.getKey().getTitle() + ": " + entry.getValue() + " шт.");
        }
    }


}
