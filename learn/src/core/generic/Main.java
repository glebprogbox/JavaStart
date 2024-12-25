/**
 * Задание: реализовать generic класс для хранения соответствия пар объектов и возможности получить
 * по любому объекту из пары ему соответствующий.
 * <p>
 * Пример:
 * Пара "key" - 1000
 * <p>
 * Дай соответствие для объекта 1000, результат key
 * Дай соответствие для объекта "key", результат 1000
 */

package core.generic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static List<Keys<String, Integer>> listOfKeys = new ArrayList<>();

    public static void main(String[] args) {
        Keys<String, Integer> keyOne = new Keys<>("key1", 500);
        listOfKeys.add(keyOne);
        Keys<String, Integer> keyTwo = new Keys<>("key2", 800);
        listOfKeys.add(keyTwo);
        Keys<String, Integer> keyThree = new Keys<>("key3", 1000);
        listOfKeys.add(keyThree);


        System.out.println("Укажите ключ key");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println("Значение для этого ключа = " + getValueByKey(input));
        System.out.println("Укажите значение value");
        Scanner scanner2 = new Scanner(System.in);
        Integer integer = scanner2.nextInt();
        System.out.println("Ключ для этого значения = " + getKeyByValue(integer));

    }

    public static Integer getValueByKey(String key) {
        for (Keys<String, Integer> keys : listOfKeys) {
            if (keys.getKey().equals(key)) {
                return keys.getValueByKey(key);
            }
        }
        return null;
    }

    public static String getKeyByValue(Integer value) {
        for (Keys<String, Integer> keys : listOfKeys) {
            if (keys.getValue().equals(value)) {
                return keys.getKeyByValue(value);
            }
        }
        return null;
    }
}

