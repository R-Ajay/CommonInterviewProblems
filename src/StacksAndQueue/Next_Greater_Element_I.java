package StacksAndQueue;

import java.util.Arrays;

public class Next_Greater_Element_I {
    public static void main(String[] args) {
        int[] nums1 = {1, 3, 5, 2, 4};
        int[] nums2 = {6, 5, 4, 3, 2, 1, 7}; //Output: {7,-1,-1,-1,-1}
        System.out.println("Brute: " + Arrays.toString(brute(nums1, nums2)));
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
