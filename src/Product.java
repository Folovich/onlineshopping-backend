import java.util.HashMap;
import java.util.Objects;

public abstract class Product {
    private long id;
    private static long counter = 0;
    private String title;
    private double price;

    public Product(String title, double price) {
        this.id = ++counter;
        this.title = title;
        this.price = price;
    }

    public Product() {
        this.id = ++counter;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
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
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}
