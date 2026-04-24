import java.util.ArrayList;
import java.util.List;

public class Category extends Product {
    private List<Product> products;
    
    public Category(String title) {
        super(title, 0);
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Товар '" + product.getTitle() + "' добавлен в категорию '" + this.getTitle() + "'");
    }

    public void showCategoryProducts() {
        System.out.println("Товары в категории " + getTitle() + ":");
        for (Product p : products) {
            System.out.println("  - " + p.getTitle());
        }
    }
}
