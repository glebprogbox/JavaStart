package productshash;


import java.text.ParseException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    HashMap<String, Product> products = new HashMap<>();

    public static void main(String[] args) {
        while (1 == 1) {
            System.out.println("""
                    "Привет! Что вы хотите сделать?
                    add - добавить продукт, delete - удалить продукт, get - получить список продуктов.""");
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("add")) {
                readProduct();
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
        String category = addToken.nextToken();
        try {
            int price = Integer.parseInt(addToken.nextToken());
            try {
                Product product = new Product(name, price, category);
            } catch (Exception e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        } catch (NumberFormatException e) {
            System.out.println("Ошибка преобразования цены!");
        }
    }




}
