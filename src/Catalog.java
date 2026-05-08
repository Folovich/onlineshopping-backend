import java.util.ArrayList;
import java.util.List;

public class Catalog{
    private static int totalCategory = 0;
    private static List<Category> CategoryArr;

    public Catalog(){CategoryArr = new ArrayList<>();}

    public void addCategory(Category cat){
        CategoryArr.add(cat);
        totalCategory++;
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
