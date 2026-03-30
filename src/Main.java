import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, String> l = new HashMap<Integer, String>();
        l.put(42,"dsf");
        Product product1 = new Elcetronic("Комп",42,l);
        Product product2 = new Elcetronic("телефон",42,l);
        Product product3 = new Elcetronic("Эпштейн",142,l);

        System.out.println(product1);
        System.out.println(product2);
        System.out.println(product3);

    }
}