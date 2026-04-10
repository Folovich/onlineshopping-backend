public class Main {
    public static void main(String[] args) {

        Catalog electronics = new Catalog("electronics");
        Catalog cars = new Catalog("cars");

        Category phones = electronics.addSubCategory("Телефоны");

        Electronic iphone = new Electronic("iPhone 42", 1000);
        Electronic samsung = new Electronic("S42 Ultra", 1000);

        Electronic as = new Electronic("iPhone 42", 11);
        Electronic asd = new Electronic("S42 Ultra", 32);


        phones.addProduct(iphone);
        phones.addProduct(samsung);

        electronics.showStats();
        phones.showCategoryProducts();

        System.out.println(iphone.equals(samsung));
        System.out.println(as.equals(asd));
        Catalog.showCategories();
    }
}
