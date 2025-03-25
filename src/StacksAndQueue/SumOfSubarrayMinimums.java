package StacksAndQueue;

import java.util.ArrayList;
import java.util.Stack;

public class SumOfSubarrayMinimums {
    public static void main(String[] args) {
//        int[] arr = {3, 1, 2, 4}; //Output: 17
        int[] arr = {11, 81, 94, 43, 3}; //Output: 444
//        System.out.println("Brute: " + findSumOfSubarrayMinimumsBrute(arr));
        System.out.println("Optimal: " + findSumOfSubarrayMinimumsOptimal(arr));
    }
    /**
     * Time Complexity O(3N)
     * Space Complexity O(2N)
     * @param arr
     * @return
     */
    private static int findSumOfSubarrayMinimumsOptimal(int[] arr) {
        int MOD = 1_000_000_007;
        int[] prevSmallestElement = prevSmallestElement(arr);
        int[] nextSmallestElement = nextSmallestElement(arr);

        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            long left = i - prevSmallestElement[i];
            long right = nextSmallestElement[i] - i;
            sum = (long)(sum + (left * right * arr[i]) % MOD) % MOD; // MOD is used to control the overflow(Integer.MAX_VALUE)
        }
        return (int)sum;
    }

    /**
     * This method is used to track the next smallest indices
     *
     * @param arr
     * @return
     */
    private static int[] nextSmallestElement(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] nextSmallestElement = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            nextSmallestElement[i] = stack.isEmpty() ? arr.length : stack.peek();
            stack.push(i);
        }
        return nextSmallestElement;
    }

    /**
     * This method is used to track the prev smallest indices (One condition, we need to find the minimum once so for that we changed condition
     * to >)
     *
     * @param arr
     * @return
     */
    private static int[] prevSmallestElement(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] prevSmallestElement = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            prevSmallestElement[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return prevSmallestElement;
    }

    /**
     * Time Complexity O(N * N)
     *
     * @param arr
     * @return
     */
    private static int findSumOfSubarrayMinimumsBrute(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = i; j < arr.length; j++) {
                min = Math.min(arr[j], min);
                sum += min;
            }
        }
        return sum;
    }
}
