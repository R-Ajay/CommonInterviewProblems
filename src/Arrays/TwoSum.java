package Arrays;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {2, 6, 5, 11, 8, 3};
        int target = 11;
//        findTwoSumBrute(arr, target);
        findTwoSumOptimal(arr, target);
    }

    /**
     * Time Complexity O(n)
     *
     * @param arr
     * @param target
     */
    private static void findTwoSumOptimal(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int remaining = target - arr[i];
            if (map.containsKey(remaining)) {
                System.out.println("[" + arr[i] + ", " + remaining + "]");
            }
            map.put(arr[i], i);
        }
    }

    /**
     * Time Complexity O(n * n)
     *
     * @param arr
     * @param target
     */
    private static void findTwoSumBrute(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i] + arr[j] == target)
                    System.out.println("[" + arr[i] + ", " + arr[j] + "]");
            }
        }
    }
}
