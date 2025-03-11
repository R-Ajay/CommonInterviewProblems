package TwoPointerSlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class BinarySubArraysWithSumK {
    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 0, 1};
        int k = 2;
//        findBinarySubArraysWithSumKBrute(arr, k);
        findBinarySubArraysWithSumKBetter(arr, k);
    }

    /**
     * Time Complexity O (n)
     *
     * @param arr
     * @param k
     */
    private static void findBinarySubArraysWithSumKBetter(int[] arr, int k) {
        int left = 0;
        int sum = 0;
        int count = 0;
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1); // To handle the case when subarray starts from index 0
        for (int right = 0; right < arr.length; right++) {
            sum += arr[right];
            // Check if there is a prefix sum that we can subtract to get the sum k
            if (prefixSumCount.containsKey(sum - k)) {
                count += prefixSumCount.get(sum - k); // Increment count by the number of times (sum - k) has occurred
            }

            // Update the prefix sum count
            prefixSumCount.put(sum, prefixSumCount.getOrDefault(sum, 0) + 1);
        }
        System.out.println(count);
    }

    /**
     * Time Complexity O (n * n)
     *
     * @param arr
     * @param k
     */
    private static void findBinarySubArraysWithSumKBrute(int[] arr, int k) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
