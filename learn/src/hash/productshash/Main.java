package hash.productshash;


import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
+ еще одна таска:
есть сущность товар с атрибутами: название, категория, стоимость
пользователь вручную добавляет товары
товары могут быть с одинаковыми названиями, но связка «название + категория» уникальна
нужно уметь по названию + категории мгновенно выдать стоимость товара
 */

public class Main {
    static HashMap<String, Product> products = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("Привет! Что вы хотите сделать?");
        while (1 == 1) {
            System.out.println("""
                    add - добавить продукт, get - получить список продуктов, search - искать продукт.""");
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("add")) {
                readProduct();
            } else if (input.equalsIgnoreCase("get")) {
                getAllProducts(products);
            } else if (input.equalsIgnoreCase("search")) {
                searchProduct();
            }
        }
    }

    public static void readProduct() {
        System.out.println("Введите имя, цену, категорию продукта. Через запятую.");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        addProductAndValidate(input);
    }

    public static void addProductAndValidate(String input) {
        StringTokenizer addToken = new StringTokenizer(input, ", ");
        int tokenCount = addToken.countTokens();
        if (!(tokenCount == 3)) {
            System.out.println("Введено недопустимое кол-во параметров! Должно быть 3.");
        } else {
            addProduct(addToken);
        }
    }

    public static void addProduct(StringTokenizer addToken) {
        String name = addToken.nextToken();
        try {
            int price = Integer.parseInt(addToken.nextToken());
            try {
                String category = addToken.nextToken();
                Product product = new Product(
                        name,
                        price,
                        category);
                if (addProductToProducts(products, product) == null) {
                    System.out.println("Продукт с такой категорией и именем уже существует!");
                } else {
                    System.out.println("Продукт успешно добавлен в список!");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } catch (NumberFormatException e) {
            System.out.println("Ошибка преобразования цены!");
        }
    }

    public static HashMap<String, Product> addProductToProducts(HashMap<String, Product> products, Product product) {
        if (validateProductInHashMap(products, product) == null) {
            String id = product.getName().toUpperCase() + product.getCategory().toUpperCase();
            products.put(id, product);
            return products;
        } else {
            return null;
        }
    }

    public static HashMap<String, Product> validateProductInHashMap(HashMap<String, Product> products, Product product) {
        String id = product.getName().toUpperCase() + product.getCategory().toUpperCase();
        if (products.get(id) == null) {
            System.out.println("Продукт с таким хэшем не найден!");
            return null;
        } else {
            System.out.println("Продукт с таким хэшем найден и будет проверен на соответствие!");
            if (!products.get(id).equals(product)) {
                System.out.println("Продукт с таким же хэшем, но не равен переданному продукту!");
                return null;
            } else {
                System.out.println("Продукт с таким же хэшем, и равен переданному продукту!");
                return products;
            }
        }
    }

//    //  для примера, так бы мы удаляли продукт
//    public static void deleteProductFromProducts(HashMap<String, Product> products, Product product) {
//        String id = product.getName().toUpperCase() + product.getCategory().toUpperCase();
//        if (products.get(id) == null) {
//            System.out.println("Продукт не найден!");
//        }
//        products.remove(id);
//        System.out.println("Продукт успешно удален!");
//    }

    public static void getAllProducts(HashMap<String, Product> products) {
        if (products.isEmpty()) {
            System.out.println("Список продуктов пуст!");
        } else {
            for (Product product : products.values()) {
                System.out.println(product.toString());
            }
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
        String id = name.toUpperCase() + category.toUpperCase();
        Product product = products.get(id);
        if (product == null) {
            System.out.println("Продукт не найден!");
        } else {
            System.out.println(product);
        }
    }
}

