package StacksAndQueue;

import java.util.Arrays;
import java.util.Stack;

public class Next_Greatest_Element_2_Circular_Array {
    public static void main(String[] args) {
//        int[] nums = {1, 2, 1}; // Output: [2, -1, 2]
//        int[] nums = {1,2,3,4,3}; // Output: [2,3,4,-1,4]
        int[] nums = {1, 5, 3, 6, 8}; // Output: [5,6,6,8,-1]
//        System.out.println("Brute: " + Arrays.toString(brute1(nums)));
//        System.out.println("Brute: " + Arrays.toString(brute2(nums)));
        System.out.println("Optimal: " + Arrays.toString(optimal(nums)));
    }

    /**
     * Time Complexity O(N * N)
     *
     * @param nums
     * @return
     */
    private static int[] brute1(int[] nums) {
        int[] nextGreater = new int[nums.length];
        Arrays.fill(nextGreater, -1);

        for (int i = 0; i < nums.length; i++) {
            boolean found = true;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    nextGreater[i] = nums[j];
                    found = false;
                    break;
                }
            }
            if (found)
                for (int j = 0; j < i; j++) {
                    if (nums[i] < nums[j]) {
                        nextGreater[i] = nums[j];
                        break;
                    }
                }
        }
        return nextGreater;
    }

    /**
     * Time Complexity O(N * N)
     *
     * @param nums
     * @return
     */
    private static int[] brute2(int[] nums) {
        int[] nextGreater = new int[nums.length];
        Arrays.fill(nextGreater, -1);

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length - 1 + i; j++) {
                int index = j % nums.length;
                if (nums[i] < nums[index]) {
                    nextGreater[i] = nums[index];
                    break;
                }
            }
        }
        return nextGreater;
    }


    /**
     * Time Complexity O(N)
     *
     * @param nums
     * @return
     */
    private static int[] optimal(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] nextGreater = new int[nums.length];
        for (int i = 2 * nums.length - 1; i >= 0; i--) {
            int index = i % nums.length;
            while (!stack.isEmpty() && stack.peek() <= nums[index]) {
                stack.pop();
            }
            nextGreater[index] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[index]);
        }

        return nextGreater;
    }
}
