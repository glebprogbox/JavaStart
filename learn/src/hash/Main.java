package hash;

import java.util.*;

public class Main {
    static int[] array = {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 2, 3, 6, 5, 7, 8, 9, 2, 2, 9};

    public static void main(String[] args) {
        TreeMap<Integer, String> mapOfInt = createHash(array);
        for (Map.Entry<Integer, String> entry : mapOfInt.entrySet()) {
            System.out.println("Ключ: " + entry.getKey() + ", Значение: " + entry.getValue());
        }

    }


    public static TreeMap<Integer, String> createHash(int[] nums) {
        TreeMap<Integer, String> hashSet = new TreeMap<>();
        int i = 0;
        for (int num : array) {
            i++;
            hashSet.put(num, "Число" + i);
        }
        return hashSet;
    }

}