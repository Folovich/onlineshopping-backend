import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    static Catalog catalog42 = new Catalog();
    static Scanner scanner = new Scanner(System.in);

    // В обычном main просто запускаем логику
    public static void main(String[] args) {
        // Подготовка данных
        catalog42.addCategory(new Category("electronics"));
        catalog42.addCategory(new Category("cars"));

        runApp(); // Запуск основного цикла
    }

    static void runApp() {
        // Карта действий на основе нашего интерфейса
        Map<Integer, MenuAction> actions = new HashMap<>();

        // Наполняем лямбдами
        actions.put(1, () -> mainCatalog());
        actions.put(2, () -> System.out.println("Личный кабинет"));
        actions.put(3, () -> System.out.println("Корзина пуста"));
        actions.put(4, () -> System.exit(0));

        while (true) {
            System.out.println("\n1. Каталог | 2. Аккаунт | 3. Корзина | 4. Выход");
            int choice = scanner.nextInt();

            // Извлекаем действие и запускаем наш метод execute()
            MenuAction action = actions.get(choice);
            if (action != null) {
                action.execute();
            } else {
                System.out.println("Нет такого пункта");
            }
        }
    }

    static void mainCatalog() {
        catalog42.viewAllCategory();
        System.out.println("0. Назад");
        int choice = scanner.nextInt();
        if (choice != 0) mainCategory(choice);
    }

    static void mainCategory(int i) {
        catalog42.getCategory(i).showStats();
        System.out.println("0. Назад");
        while (scanner.nextInt() != 0);
    }
}
