import java.util.HashMap;
import java.util.List;

public abstract class Category extends Product{
    private HashMap<Integer, String> category;
    private Category listCategory;
    Category(){}

    public abstract void addCategory(Integer id, String title){
        this.category.put(id,title);
    }

    public void showCategory(){
        System.out.println(this.category);
    }
}
