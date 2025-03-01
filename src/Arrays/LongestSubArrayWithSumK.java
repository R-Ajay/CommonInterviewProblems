package Arrays;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithSumK {
    public static void main(String[] args) {
//         int[] arr = {1, 2, 3, 1, 1, 1, 1};
         int[] arr = {1, -1, 0};
//        int[] arr = {8, 15, 17, 0, 11};
        //int[] arr = {1, 2, 1, 3};
        int k = 0;
        findLongestSubArrayWithSumKPositiveBrute(arr, arr.length, k);
        findLongestSubArrayWithSumKPositiveBetter(arr, arr.length, k); //Only work if array contain positive and zeros
    }

    private static void findLongestSubArrayWithSumKPositiveBetter(int[] arr, int length, int k) {
        int left = 0;
        int right = 0;
        int currentSum = 0;
        int maxLength = Integer.MIN_VALUE;
        while(right < arr.length){
            currentSum+=arr[right];
            while(left <= right && currentSum > k){
                currentSum-=arr[left];
                left++;
            }
            if(currentSum == k)
                maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        System.out.println("Maximum SubArray Length: " + maxLength);
    }

    private static void findLongestSubArrayWithSumKPositiveBrute(int[] arr, int length, int k) {
        long currentSum = 0;
        int maxLength = 0;
        Map<Long, Integer> prefixSum = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            currentSum+=arr[i];
            if(currentSum == k){
                maxLength = Math.max(maxLength, i+1);
            }
            long remainingSum = currentSum - k;
            if(prefixSum.containsKey(remainingSum)){
                int len = i - prefixSum.get(remainingSum);
                maxLength = Math.max(maxLength, len);
            }
            prefixSum.putIfAbsent(currentSum, i);
        }
        System.out.println("Maximum SubArray Length: " + maxLength);
    }
}
