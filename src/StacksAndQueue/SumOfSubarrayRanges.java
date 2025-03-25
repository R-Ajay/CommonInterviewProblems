package StacksAndQueue;

import java.util.Stack;

public class SumOfSubarrayRanges {
    public static void main(String[] args) {
        int[] nums = {1, 3, 3}; //Output:4
        System.out.println("Brute: " + findSumOfSubarrayRangesBrute(nums));
        System.out.println("Optimal: " +
                (findSumOfSubarrayRangesMaxOptimal(nums) - findSumOfSubarrayRangesMinOptimal(nums)));
    }

    /**
     * Time Complexity O(3N)
     * Space Complexity O(2N)
     *
     * @param nums
     * @return
     */
    private static int findSumOfSubarrayRangesMinOptimal(int[] nums) {
        int MOD = 1_000_000_007;
        int[] previousMinNumber = findPreviousMinimumNumber(nums);
        int[] nextMinNumber = findNextMinimumNumber(nums);
        ;
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int left = i - previousMinNumber[i];
            int right = nextMinNumber[i] - i;
            sum = (long)(sum + (left * right * nums[i]) % MOD) % MOD; // MOD is used to control the overflow(Integer.MAX_VALUE)
        }
        return (int) sum;
    }

    private static int findSumOfSubarrayRangesMaxOptimal(int[] nums) {
        int MOD = 1_000_000_007;
        int[] previousGreaterNumber = findpreviousGreaterNumber(nums);
        int[] nextGreaterNumber = findnextGreaterNumber(nums);
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int left = i - previousGreaterNumber[i];
            int right = nextGreaterNumber[i] - i;
            sum = (long)(sum + (left * right * nums[i]) % MOD) % MOD; // MOD is used to control the overflow(Integer.MAX_VALUE)
        }
        return (int) sum;
    }


    /**
     * This method is used to track the next smallest indices
     *
     * @param nums
     * @return
     */
    private static int[] findNextMinimumNumber(int[] nums) {
        int[] nextMinNumber = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i])
                stack.pop();
            nextMinNumber[i] = stack.isEmpty() ? nums.length : stack.peek();
            stack.push(i);
        }

        return nextMinNumber;
    }

    /**
     * This method is used to track the prev smallest indices (One condition, we
     * need to find the minimum once so for that we changed condition
     * to >)
     *
     * @param nums
     * @return
     */
    private static int[] findPreviousMinimumNumber(int[] nums) {
        int[] prevMinNumber = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i])
                stack.pop();
            prevMinNumber[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        return prevMinNumber;
    }


    private static int[] findnextGreaterNumber(int[] nums) {
        int[] nextGreaterNumber = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i])
                stack.pop();
            nextGreaterNumber[i] = stack.isEmpty() ? nums.length : stack.peek();
            stack.push(i);
        }
        return nextGreaterNumber;
    }

    private static int[] findpreviousGreaterNumber(int[] nums) {
        int[] previousGreaterNumber = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i])
                stack.pop();
            previousGreaterNumber[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return previousGreaterNumber;
    }

    /**
     * Time Complexity O(N * N)
     *
     * @param nums
     * @return
     */
    private static int findSumOfSubarrayRangesBrute(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int j = i; j < nums.length; j++) {
                min = Math.min(nums[j], min);
                max = Math.max(nums[j], max);
                sum += max - min;
            }
        }
        return sum;
    }
}
