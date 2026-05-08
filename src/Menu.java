import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    static Catalog catalog42 = new Catalog();
    static Scanner scanner = new Scanner(System.in);

    public static void start() {
        // ДОБАВЛЯЕМ КАТАЛОГИ И ТД
        catalog42.addCategory(new Category("electronics"));
        catalog42.addCategory(new Category("cars"));
        //
        Map<Integer, Command> actions = new HashMap<>();

        actions.put(1, () -> showCatalog());
        actions.put(2, () -> System.out.println("Раздел 'Аккаунт' в разработке"));
        actions.put(3, () -> System.out.println("Корзина пока пуста"));
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
            catalog42.getCategory(choice).showStats();
        }
    }

}
