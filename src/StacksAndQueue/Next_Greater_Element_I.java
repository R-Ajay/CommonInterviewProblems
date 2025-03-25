package StacksAndQueue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Next_Greater_Element_I {
    public static void main(String[] args) {
//        int[] nums1 = {1, 3, 5, 2, 4};
//        int[] nums2 = {6, 5, 4, 3, 2, 1, 7}; //Output: {7, 7, 7, 7, 7}

        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2}; //Output: {-1, 3, -1}
//        System.out.println("Brute: " + Arrays.toString(brute(nums1, nums2)));
        System.out.println("Optimal: " + Arrays.toString(optimal(nums1, nums2)));
    }

    /**
     * Time Complexity O (N)
     * @param nums1
     * @param nums2
     * @return
     */
    private static int[] optimal(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }
        Stack<Integer> stack = new Stack<>();
        int[] nextGreater = new int[nums2.length];
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }
            nextGreater[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums2[i]);
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = nextGreater[map.get(nums1[i])];
        }

        return nums1;
    }

    /**
     * Time Complexity O (N + N * M * M)
     * Space Complexity O (N)
     */
    private static int[] brute(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = -1;
        }
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    for (int k = j + 1; k < nums2.length; k++) {
                        if (nums1[i] < nums2[k]) {
                            ans[i] = nums2[k];
                            break;
                        }
                    }
                }
            }
        }
        return ans;
    }
}
