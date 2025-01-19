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


public class Main {
    public static List<MyMaps<String, Integer>> listOfKeys = new ArrayList<>();

    public static void main(String[] args) {
        MyMaps<String, Integer> myMaps = new MyMaps<>();
        myMaps.put("a", 1);
        myMaps.put("b", 2);

        String s = myMaps.getKeyByValue(1);
        assert s.equals("a"); //программа проверяет, что s точно содержит a и вылетит, если это не так
        System.out.println(s);

        Integer i = myMaps.getValueByKey("a");
        assert i == 1;
        System.out.println(i);

    }
}

