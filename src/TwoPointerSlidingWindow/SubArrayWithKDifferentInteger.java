package TwoPointerSlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class SubArrayWithKDifferentInteger {
    public static void main(String[] args) {
//        int[] arr = {1, 2, 1, 3, 4};
        int[] arr = {1, 2, 1, 2, 3}; //7
//        int[] arr = {4, 5, 4, 5, 6}; //7
//        int[] arr = {1, 2, 1}; //3
        int k = 2;
        findSubArrayWithKDifferentIntegerBrute(arr, k);
        System.out.println(
                findSubArrayWithKDifferentIntegerOptimal(arr, k) - findSubArrayWithKDifferentIntegerOptimal(arr, k - 1)
        );
    }

    private static int findSubArrayWithKDifferentIntegerOptimal(int[] arr, int k) {
        int count = 0;
        int left = 0;
        int right = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (right < arr.length) {
            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);

            while (map.size() > k) {
                map.put(arr[left], map.get(arr[left]) - 1);
                if (map.get(arr[left]) <= 0) {
                    map.remove(arr[left]);
                }
                left++;
            }
            count += right - left + 1;
            right++;
        }
        return count;
    }

    /**
     * Time Complexity O (n * n)
     *
     * @param arr
     * @param k
     */
    private static void findSubArrayWithKDifferentIntegerBrute(int[] arr, int k) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);
                if (map.size() == k) {
                    count++;
                } else if (map.size() > k) {
                    break;
                }
            }
            map.clear();
        }
        System.out.println(count);
    }
}
