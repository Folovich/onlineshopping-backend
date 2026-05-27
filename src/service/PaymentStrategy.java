import java.time.LocalDate;
import java.util.Map;
import java.util.stream.Collectors;

public interface PaymentStrategy {
    boolean pay(Map<Product, Integer> products, UserSystem user);
}

class CardPayment implements PaymentStrategy {
    @Override
    public boolean pay(Map<Product, Integer> products, UserSystem user) {
        int totalCost = calculateTotal(products);

        if (totalCost > user.getBalance()) {
            System.out.println("Недостаточно денег на карте!");
            return false;
        }

        user.setBalance(-totalCost);
        System.out.println("Успешная оплата картой. Списано: " + totalCost);

        String itemsString = products.keySet().stream()
                .map(Product::getTitle)
                .collect(Collectors.joining(", "));

        user.getHistory().add(LocalDate.now() + " | Оплата картой | Товары: [" + itemsString + "] | Сумма: " + totalCost);

        return true;
    }

    private int calculateTotal(Map<Product, Integer> products) {
        int cost = 0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            cost += entry.getKey().getPrice() * entry.getValue();
        }
        return cost;
    }
}

class CreditPayment implements PaymentStrategy {
    @Override
    public boolean pay(Map<Product, Integer> products, UserSystem user) {
        int totalCost = calculateTotal(products);

        if (totalCost > user.getCreditBalance()) {
            System.out.println("Недостаточно средств для оформления кредита!");
            return false;
        }

        user.setBalance(-totalCost);

        System.out.println("\n----- ЧЕК (КРЕДИТ) -----");
        System.out.println("Дата покупки: " + LocalDate.now());
        System.out.println("------------------------");

        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            int itemTotal = (product.getPrice() * quantity);
            System.out.println(product.getTitle() + " x " + quantity + " = " + itemTotal);
        }

        System.out.println("------------------------");
        System.out.println("Итого оплачено кредиткой: " + totalCost);
        System.out.println("------------------------");

        String itemsString = products.keySet().stream()
                .map(Product::getTitle)
                .collect(Collectors.joining(", "));

        user.getHistory().add(LocalDate.now() + " | Оплата картой | Товары: [" + itemsString + "] | Сумма: " + totalCost);

        return true;
    }

    private int calculateTotal(Map<Product, Integer> products) {
        int cost = 0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            cost += entry.getKey().getPrice() * entry.getValue();
        }
        return cost;
    }
}

class TransactionService{
    private PaymentStrategy paymentStrategy;

    public TransactionService(PaymentStrategy paymentStrategy){
        this.paymentStrategy = paymentStrategy;
    }

    public boolean checkout(Map<Product, Integer> products, UserSystem user){
        return paymentStrategy.pay(products, user);
    }
}
