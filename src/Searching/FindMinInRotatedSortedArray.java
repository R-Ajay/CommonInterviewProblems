package Searching;

public class FindMinInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {12,13,14,4,7,8,10,11};
        System.out.println("Brute: " + bruteForce(nums));
        System.out.println("Optimal: " + optimal(nums));;
    }
    private static int optimal(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int low = 0;
        int high = nums.length - 1;
        int min = nums[low];

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] >= min) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
            min = Math.min(min, nums[mid]);
        }
        return min;
    }

    private static int bruteForce(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int min = nums[0];
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                min = Math.min(min, nums[i]);
            } else {
                min = Math.min(min, nums[i + 1]);
            }
        }

        return min;
    }
}
