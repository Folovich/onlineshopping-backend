import java.util.*;
// todo   Категори - два оля, 1 поле - name, 2 поле -
//    В этом классе есть два метода aadCotegory, showCategory
//   Новый класс catalog - список основынх категорий, два счетчика - 1 счетчик кол-во категорий,  2 - в главнйо категории сколько саб категорий.
//   Tostring equals hashcode

// todo category должна автоматически сортировать категории comparable должен работать с категориями --ГОТОВО--
//  есть товары работают с comparator и с помощю него можно сортировать по цене или по названию и тд. Не стоит забывать нужен ли дополнительеый класс
//  создаем меню первая команда для получания категории 2 - для 3 - для критерии сортировки по убыванию по вохврастанию и тд, 4 - для сравнения двух товаров должна быть защита чтобы не сравнивалось с другим категорией и сравнение по критериям должно быть


// todo enum для статуса заказа, enum-мы прмиенить, добавить функциональный интерфейс что бы работал с товарами и заказами
//  (реалтзовать с помощью лямбда выражения) расширяем пользовательское меню.

// todo рмиеняем enum fuctionalInteface, lambda. 1. Прмиеняемы енамы. 2. Добавить как минимум 1 функциональный интерфейс (применять все).
//  3. Добпаить лямбду выражение в нужных местах. 4. Оптимизация кода
public class Main {
    static Catalog catalog42 = new Catalog();
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Menu.start();

//        List<Category> CatalogArr = new ArrayList<>();
//
//
//        //Пред установленные штуки
//
//        // Добавляю в каталог категории
//        CatalogArr.add(new Category("electronics"));
//        CatalogArr.add(new Category("cars"));
//
//        // Добавляю в категории саб-категории
//        CatalogArr.get(0).addSubCategory("Телефоны");
//
//
//        // Добавляю продукты в саб-категорию Телефоны
//        CatalogArr.get(0).getSub(0).addProduct(new Product("iPhone 42", 42000));
//        CatalogArr.get(0).getSub(0).addProduct(new Product("S42 Ultra", 420));
//
//        // Информация, что хранит категория электроники
//        System.out.println();
//        CatalogArr.get(0).showStats();
//
//        // Проверка, что хранить саб категория телефоны и проверка сортировок
//        CatalogArr.get(0).getSub(0).sortPriceDown();
//        CatalogArr.get(0).getSub(0).showCategoryProducts();
//
//        System.out.println();
//        CatalogArr.get(0).getSub(0).sortName();
//        CatalogArr.get(0).getSub(0).showCategoryProducts();
//
//        System.out.println();
//        CatalogArr.get(0).getSub(0).sortPriceUp();
//        CatalogArr.get(0).getSub(0).showCategoryProducts();
//
//        Persona mister = new Persona(1000,"mister");
//
//
//
//        System.out.println();
//
//        System.out.println(mister.checkBalance());
//        System.out.println(mister.getFinancialStatus());
//        System.out.println(mister.havelsNowMoney(42));
//
//
//
//        Collections.sort(CatalogArr);
    }
}
