package collection.hash.intersectionoftwoarrays;

import java.util.*;

public class Main {

    static int[] nums1 = {1,2,2,1};
    static int[] nums2 = {2,2};

    public static void main(String[] args) {
    System.out.println(Arrays.toString(intersect(nums1, nums2)));
    }

    public static int[] intersect(int[] a, int[] b) {
        Set<Integer> set1 = new HashSet<>();
        List<Integer> resultArray = new ArrayList<>();
        for (int num : nums1) {
            set1.add(num);
        }

        for (int num : nums2) {
            if (set1.contains(num)) {
                resultArray.add(num);
                set1.remove(num);
            }
        }
        return resultArray.stream().mapToInt(i -> i).toArray();
    }
}
