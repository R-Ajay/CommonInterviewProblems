package Searching;

/**
 * Arrays contain distinct elements
 */
public class SearchArrayInSortedArray_1 {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println("Brute: " + bruteforce(arr, target));
        System.out.println("Optimal: " + optimal(arr, target));
    }

    /**
     * Time Complexity O(Log N)
     *
     * @param arr
     * @param target
     * @return
     */
    private static int optimal(int[] arr, int target) {
        int index = -1;
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[low] <= arr[mid]) {
                if (arr[low] <= target && target <= arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (arr[mid] <= target && target <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return index;
    }

    /**
     * Time Complexity O(N)
     *
     * @param nums
     * @param target
     * @return
     */
    private static int bruteforce(int[] nums, int target) {
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target)
                index = i;
        }
        return index;
    }
}
