import java.util.ArrayList;
import java.util.List;

public class Catalog {
    private String catalogName;
    private static List<String> listCategory = new ArrayList<>();
    private List<Category> subCategories;
    private static int totalCatalogs = 0;
    private int subCount = 0;
    public Catalog(String name) {
        listCategory.add(name);
        this.catalogName = name;
        this.subCategories = new ArrayList<>();
        totalCatalogs++;
    }

    public Category addSubCategory(String name) {
        Category newCat = new Category(name);
        subCategories.add(newCat);
        subCount++;
        return newCat;
    }

    public void showStats() {
        System.out.println("Каталог: " + catalogName);
        System.out.println("Всего каталогов: " + totalCatalogs);
        System.out.println("Подкатегорий в '" + catalogName + "': " + subCount);
    }

    public static void showCategories() {
        System.out.println("--- Глобальный список всех каталогов ---");
        for (String name : listCategory) {
            System.out.println("Каталог в системе: " + name);
        }
    }
}
