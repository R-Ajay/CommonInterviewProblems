package Arrays;

public class KadaneAlgorithmMaximumSubarraySum {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4}; //Output: 6
//        int[] nums = {5,4,-1,7,8}; //Output: 23
        System.out.println(brute(nums)); //Time: O(N) and Space O(N)
        System.out.println(optimal(nums)); // Time: O(N) and Space O(1)
    }

    private static int brute(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int currentSum = 0;
            for (int j = i; j < nums.length; j++) {
                currentSum += nums[j];
                max = Math.max(max, currentSum);
            }
        }
        return max;
    }

    /**
     * Applying Kadane's Algorithm
     * @param nums
     * @return
     */
    private static int optimal(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (max < sum)
                max = sum;

            if (sum < 0)
                sum = 0;
        }
        return max;
    }
}
