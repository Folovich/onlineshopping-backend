import java.util.ArrayList;
import java.util.List;

public class Catalog{
    private static List<Category> CategoryArr;
    private  static Catalog instance;
    public Catalog(){}

    public static Catalog getInstance(){
        if(instance == null){
            CategoryArr = new ArrayList<>();
            instance = new Catalog();
        }
        return instance;
    }

    public void addCategory(Category cat){
        CategoryArr.add(cat);
    }

    public Category getCategory(int id){
        return CategoryArr.get(id);
    }

    public void viewAllCategory(){
        System.out.println("----- Все категории -----");
        int counter = 1;
        System.out.println("0. ВЫХОД");
        for(Category er : CategoryArr){
            System.out.println(counter + ". " + er.getCatalogName());
            counter++;
        }
    }
}
