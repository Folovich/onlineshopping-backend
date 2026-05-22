import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public final class Menu {

    static final Catalog catalog42 = Catalog.getInstance();
    static final Scanner scanner = new Scanner(System.in);


    static final UserSystem systemUser = new UserSystem(TypeUser.GUEST);


    public static void start() {
        // ДОБАВЛЯЕМ КАТАЛОГИ И ТД

        catalog42.addCategory(new Category("electronics"));
        catalog42.getCategory(0).addSubCategory("computer");
        catalog42.getCategory(0).getSub(0).addProduct("HyperPc",100,1);

        catalog42.addCategory(new Category("transport"));
        catalog42.getCategory(1).addSubCategory("sport-car");
        catalog42.getCategory(1).getSub(0).addProduct("Formula-1",100000,1);
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
                        if (UserSystem.getCurrentUser().getType() == TypeUser.GUEST){
                            System.out.println("Вы гость, зайдите в аккаунт.");
                        }else{
                            UserSystem.getCurrentUser().getBasket().add(tittle,catalog42.getCategory(choice - 1).getSub(choiceTwo - 1).getProduct(choiceTree - 1));
                        }
                    }
                }
            }
        }
    }

    static void showBasket(){
        if(UserSystem.getCurrentUser().getType() == TypeUser.USER){
            UserSystem.getCurrentUser().getBasket().check();
            System.out.println("0. Выход | 1. Оплатить");
            int choice = scanner.nextInt();
            if (choice != 0) {
                System.out.println(UserSystem.getCurrentUser().getBasket().pay());
            }
        } else{
            System.out.println("Сначала войдите в аккаунт!");
        }

    }

    static void showUser() {
        if (UserSystem.getCurrentUser().getType() == TypeUser.GUEST) {

            Map<Integer, Command> actionsAcc = new HashMap<>();
            actionsAcc.put(1, () -> createUser());
            actionsAcc.put(2, () -> loginUser());
            while (true) {
                System.out.println("0. Выход | 1. Зарегистрировать аккаунт  | 2. Войти в аккаунт");
                int choice = scanner.nextInt();
                if(choice != 0){
                    if (actionsAcc.containsKey(choice)) {
                        actionsAcc.get(choice).execute();
                        break;
                    } else {
                        System.out.println("Ошибка: выберите от 0 до 2");
                    }
                }else{break;}
            }
        }else{
            System.out.println(UserSystem.getCurrentUser().toString());
            Map<Integer, Command> actionsAcc = new HashMap<>();
            actionsAcc.put(1, () -> UserSystem.setCurrentUser(new UserSystem(TypeUser.GUEST)));
            actionsAcc.put(2, () -> refilSystem());
            while (true) {
                System.out.println("0. Выход | 1. Выйти из аккаунта | 2. Пополнить баланс");
                int choice = scanner.nextInt();
                if(choice != 0){
                    if (actionsAcc.containsKey(choice)) {
                        actionsAcc.get(choice).execute();
                        break;
                    } else {
                        System.out.println("Ошибка: выберите от 0 до 1");
                    }
                }else{break;}
            }
        }
    }
    static void refilSystem(){
        System.out.println("Сумма пополнения: ");
        int money = scanner.nextInt();
        UserSystem.getCurrentUser().setBalance(money);
    }
    static void createUser(){
        scanner.nextLine();
        System.out.println("Введите имя: ");
        String name = scanner.nextLine();
        if(UserSystem.getUsers().containsKey(name)){
            System.out.println("Такое имя уже есть!");
            return;
        }

        System.out.println("Введите пароль: ");
        int passw = scanner.nextInt();
        scanner.nextLine();


        System.out.println(UserSystem.registr(name, passw));
    }

    static void loginUser(){
        scanner.nextLine();
        System.out.println("Введите имя: ");
        String name = scanner.nextLine();

        System.out.println("Введите пароль: ");
        int passw = scanner.nextInt();
        scanner.nextLine();

        if(UserSystem.getUsers().containsKey(name)){
            if(UserSystem.getUsers().get(name).checkPasswd(passw)){
                UserSystem.setCurrentUser(UserSystem.getUsers().get(name));
            } else{
                System.out.println("Неправильный пароль");
            }
        }else{
            System.out.println("Такого имени нету!");
        }
    }
}

