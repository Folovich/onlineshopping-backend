import java.util.ArrayList;
import java.util.List;

public class Category implements Comparable<Category>{
    private String catalogName;

    private List<SubCategory> subCategories;
    private static int totalCategory = 0;
    private int subCount = 0;
    private int id = 0;

    public Category(String name) {
        this.catalogName = name;
        this.subCategories = new ArrayList<>();
        totalCategory++;
        this.id = totalCategory;
    }

    public void viewSubCategory(){
        System.out.println("----- Все саб-категории -----");
        int counter = 1;
        System.out.println("0. ВЫХОД");
        for(SubCategory er : subCategories){
            System.out.println(counter + ". " + er.getTitle());
            counter++;
        }
    }
    @Override
    public int compareTo(Category other) {
        return Integer.compare(this.id, other.id);
    }

    public SubCategory getSub(int id){
        return subCategories.get(id);
    }

    public void addSubCategory(String name) {
        SubCategory newCat = new SubCategory(name);
        subCategories.add(newCat);
        subCount++;
    }

    public void showStats() {
        System.out.println("Каталог: " + catalogName);
        System.out.println("Всего каталогов: " + totalCategory);
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
