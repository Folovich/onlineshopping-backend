import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;
public class SubCategory extends Product {
    private List<Product> products;
    private static int counter = 0;
    private int id;
    public SubCategory(String title) {
        super(title, 0,0);
        this.products = new ArrayList<>();
        this.id = counter;
        counter++;
    }
    public void viewProduct(){
        System.out.println("----- Все Продукты -----");
        int counter = 1;
        System.out.println("0. ВЫХОД");
        for(Product er : products){
            System.out.println(counter + ". " + er.getTitle());
            counter++;
        }
    }
    public void addProduct(String title, int price, int quant){
        Product newCat = new Product(title, price, quant);
        products.add(newCat);
    }
    public void sortName() {
        // Используем стандартный compareTo из класса Product
        Collections.sort(products);
        System.out.println("Список отсортирован по названию.");
    }
    public void sortPriceUp() {
        // Используем Comparator для сравнения по цене
        products.sort(Comparator.comparingDouble(Product::getPrice));
        System.out.println("Список отсортирован по цене.  Дешевые-Дорогие");
    }

    public void sortPriceDown() {
        // Используем Comparator для сравнения по цене
        products.sort(Comparator.comparingDouble(Product::getPrice).reversed());
        System.out.println("Список отсортирован по цене. Дорогие-Дешевые");
    }

    public Product getProduct(int id){
        return this.products.get(id);
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
