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
        Keys<String, Integer> keys = new Keys<>();
        keys.put("a", 1);
        keys.put("b", 2);

        String s = keys.getKeyByValue(1);
        assert s.equals("a"); //программа проверяет, что s точно содержит a и вылетит, если это не так
        System.out.println(s);

        Integer i = keys.getValueByKey("a");
        assert i == 1;
        System.out.println(i);

    }
}

