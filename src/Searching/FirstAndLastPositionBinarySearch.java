package Searching;

import java.util.Arrays;

public class FirstAndLastPositionBinarySearch {
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10}; int target = 8;
//        int[] nums = {2, 2}; int target = 2;
        System.out.println(Arrays.toString(searchRangeOptimal(nums, target)));
//        System.out.println(Arrays.toString(searchRangeBrute(nums, target)));
    }

    public static int[] searchRangeOptimal(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int first = -1;
        int last = -1;
        //Find the First occurence
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                first = mid;
                high = mid - 1;
            } else if (target < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if (first == -1) {
            return new int[]{-1, -1};
        }
        low = 0;
        high = nums.length - 1;
        //Find the Second occurence
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                last = mid;
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return new int[]{first, last};
    }

    /**
     * Time Complexity O(N)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] searchRangeBrute(int[] nums, int target) {
        int index[] = new int[2];
        index[0] = -1;
        index[1] = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if (index[0] == -1)
                    index[0] = i;
                index[1] = i;
            }
        }
        return index;
    }
}
