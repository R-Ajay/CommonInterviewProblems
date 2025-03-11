package Searching;

public class FindPeakElement {
    public static void main(String[] args) {
//        int[] nums = {1,2,3,1};
        int[] nums = {1, 2, 1, 3, 5, 6, 4};
        System.out.println("Brute: " + bruteForce(nums));
        System.out.println("Optimal: " + optimal(nums));
    }

    private static int optimal(int[] nums) {
        int n = nums.length;
        // Check Array has One element
        if (n == 1) {
            return 0;
        }

        // Check First element is greater then next element
        if (nums[0] > nums[1]) {
            return 0;
        }

        // Check Last element is greater then previous element
        if (nums[n - 1] > nums[n - 2]) {
            return n - 1;
        }

        int low = 1;
        int high = n - 2;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[mid - 1] < nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    private static int bruteForce(int[] nums) {
        int n = nums.length;

        // Check Array has One element
        if (n == 1) {
            return 0;
        }

        // Check First element is greater then next element
        if (nums[0] > nums[1]) {
            return 0;
        }

        // Check Last element is greater then previous element
        if (nums[n - 1] > nums[n - 2]) {
            return n - 1;
        }

        // Iterate the Mid elements to find greater elements
        for (int i = 1; i < n - 1; i++) {
            if (nums[i - 1] < nums[i] && nums[i] > nums[i + 1]) {
                return i;
            }
        }
        return -1;
    }
}
