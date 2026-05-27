import java.util.HashMap;
import java.util.Objects;

public class Product implements Payable, Comparable<Product> {
    private static int quant;
    private long id;
    private static long counter = 0;
    private String title;
    private int price;
    private boolean paid = false;
    public Product(String title, int price, int quant) {
        this.id = ++counter;
        this.title = title;
        this.price = price;
        this.quant = quant;
    }

    @Override
    public int compareTo(Product other) {
        return this.title.compareTo(other.title);
    }


    @Override
    public double pay(double amount){
        if(((amount - this.price) < 0) || paid){
            return amount;
        }
        paid = true;
        return amount - this.price;
    }

    @Override
    public double getFinalPrice(){
        return this.price;
    }
    @Override
    public boolean isPaid(){
        // Нужен персон
        return paid;
    }

    public int getPrice() {
        return price;
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(price, product.price) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(price);
    }

    @Override
    public String toString() {
        return "Название " + title +
                ", стоимость " + price +
                ", кол-во " + quant
                ;
    }


}
