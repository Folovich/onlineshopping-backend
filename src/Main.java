import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, String> l = new HashMap<Integer, String>();
        l.put(42,"dsf");
        // String title, double price, HashMap<Integer, String> category
        Product product42 = new Category("Комп", 42, l) ;

        product42.addCategory(1,"Зубачситки");
        product42.addCategory(2,"машины");
        product42.showCategory();
    }
}