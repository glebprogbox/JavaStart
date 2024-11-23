package hash.hashOne;

import java.util.*;

public class Main {
    static int[] array = {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 2, 3, 6, 5, 7, 8, 9, 2, 2, 9};

    public static void main(String[] args) {
        HashSet<Integer> hashSetOne = createHashOne(array);
        printMapOne(hashSetOne);
        printMajorityElementOne(hashSetOne, array);
        System.out.println("А теперь другой подход.");
        HashMap<Integer, Integer> hashMapTwo = createHashTwo(array);
        printMapTwo(hashMapTwo);
        printMajorityElementTwo(hashMapTwo, array);

    }

    public static HashSet<Integer> createHashOne(int[] array) { //возьмем уникальные значения из массива
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : array) {
            hashSet.add(num);
        }
        return hashSet;
    }

    public static void printMapOne(HashSet<Integer> hashSet) {
        System.out.println("Уникальные значения массива их хэшсет..");
        for (int num : hashSet) {
            System.out.println("Значение: " + num);
        }
    }

    //решение с большой сложностью, m*n
    public static void printMajorityElementOne(HashSet<Integer> hashSet, int[] array) {
        for (int num : hashSet) {//берем по порядку элементы из хэша
            int count = 0; //сколько раз повторяется значение
            for (int j : array) { // берем по порядку элементы из массива
                if (j == num) { //сравниваем, если равны, прибавляем счетчик
                    count++;
                }
            }
            if (count > array.length / 2) {
                System.out.println("Значение " + num + " в массиве повторяется " + count +
                        " раз. Длима массива " + array.length + ".");
            }
        }
    }

    //другой подход, тк ключи совпадают, мы всегда в ключ со значением будем записывать каунт +1
    public static HashMap<Integer, Integer> createHashTwo(int[] array) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : array) {
            //берем значение или 0, если там null, и прибавляем 1
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }
        return hashMap;
    }

    public static void printMapTwo(HashMap<Integer, Integer> hashMap) {
        System.out.println("Значения массива с счетчиками из хэшмэп..");
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            System.out.println("Ключ: " + entry.getKey() + ". Значение: " + entry.getValue());
        }
    }

    //решение с простой сложностью, O(n)
    public static void printMajorityElementTwo(HashMap<Integer, Integer> hashMap, int[] array) {
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() > array.length / 2) {
                System.out.println("Значение " + entry.getKey() + " в массиве повторяется " + entry.getValue() +
                        " раз. Длима массива " + array.length + ".");
            }
        }
    }

}