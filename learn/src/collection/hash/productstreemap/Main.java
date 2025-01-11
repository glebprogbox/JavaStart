package collection.hash.productstreemap;

/*
из файла считываю 10 продуктов, должен их вывести в соответствии с сортировкой. сортировка должна работать по всем
полям + ключу кат+имя осуществлять поиск конкретного продукта. подсказка - тримэп будет,
компаратор нужно написать и установить в тримэп
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static String filePath = "/Users/gleb/IdeaProjects/JavaStart/learn/src/collection/hash/productstreemap/products.txt";
    static TreeMap<String, Product> map = new TreeMap<>();

    public static void main(String[] args) {
        readFile();
        System.out.println("Продуктов в коллекции - " + map.size());
        while (1 == 1) {
            System.out.println("Что вы хотите сделать? get - вывести все с сортировкой, search - искать продукт.");
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("get")) {
                getSortedMap(map);
            } else if (input.equalsIgnoreCase("search")) {
                searchProduct();
            }
        }
    }

    public static void readFile() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line = null;
            int lineCount = 1;
            while ((line = br.readLine()) != null) {
                StringTokenizer addToken = new StringTokenizer(line, ", ");
                validateLine(addToken, lineCount);
                String name = addToken.nextToken();
                int price = getPrice(addToken);
                String category = addToken.nextToken();
                Product product = new Product(name, price, category);
                addProductInMap(product);
                lineCount++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден!");
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла!");
        }
    }

    private static int getPrice(StringTokenizer addToken) {
        try {
            return Integer.parseInt(addToken.nextToken());
        } catch (NumberFormatException e) {
            System.out.println("Ошибка преобразования цены! Программа будет завершена.");
            return 0;
        }
    }

    public static void addProductInMap(Product product) {
        String id = product.getCategory().toUpperCase() + "," + product.getName().toUpperCase();
        if (map.get(id) == null) {
            map.put(id, product);
            System.out.println("Продукт:" + product + " успешно добавлен!");
        } else {
            if (!map.get(id).equals(product)) {
                map.put(id, product);
                System.out.println("Продукт:" + product + " успешно добавлен!");
            } else {
                System.out.println("Найден повторяющийся продукт:" + product + ". Он будет пропущен!");
            }
        }
    }


    public static void validateLine(StringTokenizer line, int lineCount) {
        if (line.countTokens() != 3) {
            System.out.println("Неверное количество параметров на строке " + lineCount +
                    ". Программа будет приостановлена, поправьте файл.");
            System.exit(0);
        }
    }

    public static void searchProduct() {
        System.out.println("Введите имя и категорию продукта. Через запятую.");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        searchProductAndValidate(input);
    }

    public static void searchProductAndValidate(String input) {
        StringTokenizer addToken = new StringTokenizer(input, ", ");
        int tokenCount = addToken.countTokens();
        if (!(tokenCount == 2)) {
            System.out.println("Введено недопустимое кол-во параметров! Должно быть 2.");
        } else {
            searchProduct(addToken);
        }
    }

    public static void searchProduct(StringTokenizer addToken) {
        String name = addToken.nextToken();
        String category = addToken.nextToken();
        String id = category.toUpperCase() + "," + name.toUpperCase();
        Product product = map.get(id);
        if (product == null) {
            System.out.println("Продукт не найден!");
        } else {
            System.out.println(product);
        }
    }

    public static void getSortedMap(TreeMap<String, Product> map) {
        for (Product product : map.values()) {
            System.out.println(product);
        }
    }

}
