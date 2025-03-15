package Arrays;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {

        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        // bruteForce(nums1, m, nums2, n);
//        better(nums1, m, nums2, n);  Space Complexity O (M + N)
        optimal(nums1, m, nums2, n);  // Space Complexity O (1)
    }

    private static void optimal(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0) return;
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        while (i >= 0) {
            nums1[k--] = nums1[i--];
        }

        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }

        System.out.println(Arrays.toString(nums1));
    }

    /**
     * Time Complexity O (M + N)
     * Space Complexity O (M + N)
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    private static void better(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;

        int left = 0;
        int right = 0;
        int k = 0;
        int[] temp = new int[m + n];
        while (left < m && right < n) {
            if (nums1[left] < nums2[right]) {
                temp[k++] = nums1[left++];
            } else {
                temp[k++] = nums2[right++];
            }
        }

        while (left < m) {
            temp[k++] = nums1[left++];
        }

        while (right < n) {
            temp[k++] = nums2[right++];
        }

        for (int i = 0; i < k; i++) {
            nums1[i] = temp[i];
        }

        System.out.println(Arrays.toString(nums1));
    }

    private static void bruteForce(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m, j = 0; i < nums1.length; i++, j++) {
            nums1[i] = nums2[j];
        }
        Arrays.sort(nums1);
    }
}
