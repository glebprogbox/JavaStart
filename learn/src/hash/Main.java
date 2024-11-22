package hash;

import java.util.*;

public class Main {
    static int[] array = {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 2, 3, 6, 5, 7, 8, 9, 2, 2, 9};

    public static void main(String[] args) {
        TreeMap<String, Integer> mapOfInt = createHash(array);
        printMap(mapOfInt);

    }

    public static TreeMap<String, Integer> createHash(int[] nums) {
        TreeMap<String, Integer> hashSet = new TreeMap<>();
        int i = 0;
        for (int num : nums) {
            i++;
            Random random = new Random();
            int randomInt = random.nextInt();
            hashSet.put("Число" + num + " " + randomInt, num);
        }
        return hashSet;
    }

    public static void printMap(TreeMap<String, Integer> hashSet) {
        for (Map.Entry<String, Integer> entry : hashSet.entrySet()) {
            System.out.println("Ключ: " + entry.getKey() + ", Значение: " + entry.getValue());
        }
    }

    public static void printMajorityElement(TreeMap<String, Integer> hashSet) {
        int majorityElement = hash
    }

}