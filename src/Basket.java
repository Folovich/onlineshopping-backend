import java.util.ArrayList;
import java.util.List;

public class Basket {
    private List<Product> product;
    private ArrayList<Object> list = new ArrayList<>();
    public void add(String title, Product product){
        list.add(title);
        list.add(product);
    }
}
