import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    static User guest = new User(TypeUser.GUEST);
    static Basket basket = new Basket();
    static Catalog catalog42 = new Catalog();
    static Scanner scanner = new Scanner(System.in);

    public static void start() {
        // ДОБАВЛЯЕМ КАТАЛОГИ И ТД

        catalog42.addCategory(new Category("electronics"));
        catalog42.getCategory(0).addSubCategory("computer");
        catalog42.getCategory(0).getSub(0).addProduct("HyperPc",100,1);

        catalog42.addCategory(new Category("cars"));
        //
        Map<Integer, Command> actions = new HashMap<>();

        actions.put(1, () -> showCatalog());
        actions.put(2, () -> showUser());
        actions.put(3, () -> showBasket());
        actions.put(4, () -> System.exit(0));

        while (true) {
            System.out.println("\n1. Каталог | 2. Аккаунт | 3. Корзина | 4. Выход");
            int choice = scanner.nextInt();

            if (actions.containsKey(choice)) {
                actions.get(choice).execute();
            } else {
                System.out.println("Ошибка: выберите от 1 до 4");
            }
        }
    }

    static void showCatalog() {
        catalog42.viewAllCategory();
        System.out.println("Введите номер категории (0 для выхода):");
        int choice = scanner.nextInt();

        if (choice != 0) {
            catalog42.getCategory(choice - 1).viewSubCategory();
            System.out.println("Введите номер саб-категории (0 для выхода):");
            int choiceTwo = scanner.nextInt();

            if (choiceTwo != 0){
                catalog42.getCategory(choice - 1).getSub(choiceTwo - 1).viewProduct();
                System.out.println("Введите номер продукта (0 для выхода):");
                int choiceTree = scanner.nextInt();

                if (choiceTree != 0){
                    System.out.println(catalog42.getCategory(choice - 1).getSub(choiceTwo - 1).getProduct(choiceTree - 1));
                    System.out.println("0 - для выхода");
                    System.out.println("1 - добавить в корзину");
                    int choiceFour = scanner.nextInt();

                    if(choiceFour != 0){
                        String tittle = catalog42.getCategory(choice - 1).getCatalogName() + " " + catalog42.getCategory(choice - 1).getSub(choiceTwo - 1).getTitle() ;
                        basket.add(tittle,catalog42.getCategory(choice - 1).getSub(choiceTwo - 1).getProduct(choiceTree - 1));
                    }
                }
            }
        }
    }

    static void showBasket(){
        basket.check();
        System.out.println("0. Выход | 1. Оплатить");
        int choice = scanner.nextInt();
        if (choice != 0) {
            basket.pay();
        }
    }

    static void showUser(){

    }
}
