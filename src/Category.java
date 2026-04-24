import java.util.ArrayList;
import java.util.List;

public class Catalog implements Comparable<Catalog>{
    private String catalogName;

    private List<Category> subCategories;
    private static int totalCatalogs = 0;
    private int subCount = 0;
    private int id = 0;

    public Catalog(String name) {
        this.catalogName = name;
        this.subCategories = new ArrayList<>();
        totalCatalogs++;
        this.id = totalCatalogs;
    }

    @Override
    public int compareTo(Catalog other) {
        return Integer.compare(this.id, other.id);
    }

    public Category getSub(int id){
        return id;
    }

    public void addSubCategory(String name) {
        Category newCat = new Category(name);
        subCategories.add(newCat);
        subCount++;
    }

    public void showStats() {
        System.out.println("Каталог: " + catalogName);
        System.out.println("Всего каталогов: " + totalCatalogs);
        System.out.println("Подкатегорий в '" + catalogName + "': " + subCount);
    }



    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "catalogName='" + catalogName + '\'' +
                ", subCategories=" + subCategories +
                ", subCount=" + subCount +
                '}';
    }
}
