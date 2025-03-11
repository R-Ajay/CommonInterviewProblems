package Searching;

public class FindSingleElementInDuplicateArray {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        System.out.println("Brute: " + bruteForce(nums));
        System.out.println("Optimal: " + optimal(nums));
    }

    public static int optimal(int[] nums) {
        int result = -1;

        // Check Array has One element
        if (nums.length == 1) {
            return nums[0];
        }

        // Check First element is Not Equal to next element
        if (nums[0] != nums[1]) {
            return nums[0];
        }

        // Check Last element is Not Equal to previous element
        if (nums[nums.length - 1] != nums[nums.length - 2]) {
            return nums[nums.length - 1];
        }

        int low = 1;
        int high = nums.length - 2;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid - 1] != nums[mid] && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            } else if ((mid % 2 == 1) && nums[mid - 1] == nums[mid]
                    || ((mid % 2 == 0) && nums[mid] == nums[mid + 1])) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }
        return result;
    }

    public static int bruteForce(int[] nums) {
        for (int i = 0; i < nums.length - 1; i = +2) {
            if (nums[i] != nums[i + 1])
                return nums[i];
        }
        return -1;
    }
}
