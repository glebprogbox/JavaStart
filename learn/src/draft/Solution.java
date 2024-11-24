//package draft;
//
//import java.util.HashMap;
//import java.util.Map;
//
//class Solution {
//    public int majorityElement(int[] nums) {
//        HashMap<Integer, Integer> hashMap = new HashMap<>();
//        for (int num : nums) {
//            //берем значение или 0, если там null, и прибавляем 1
//            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
//        }
//
//        int majority = 0;
//        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
//            if (entry.getValue() > nums.length / 2) {
//                majority = entry.getValue();
//            }
//        }
//    }
//return int majority;
//}