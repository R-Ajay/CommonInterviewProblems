package Searching;

public class CountFrequencyInSortedArray {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 2, 2, 3};
        int target = 2;
        System.out.println("Brute: " + findFrequencyInSortedArrayBrute(arr, target));
        System.out.println("Two Pointer: " + findFrequencyInSortedArrayTwoPointer(arr, target));
        System.out.println("Optimal: " + findFrequencyInSortedArrayOptimal(arr, target));
    }

    /**
     * Tow Pointer Approach O(N)
     *
     * @param arr
     * @param target
     * @return
     */
    private static int findFrequencyInSortedArrayTwoPointer(int[] arr, int target) {
        int count = 0;
        int left = 0;
        int right = 0;
        while (right < arr.length) {
            if (arr[right] != target)
                left++;
            else if (arr[right] == target)
                count = right - left + 1;
            right++;
        }
        return count;

    }

    /**
     * Time Complexity O(N)
     *
     * @param arr
     * @param target
     * @return
     */
    private static int findFrequencyInSortedArrayBrute(int[] arr, int target) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target)
                count++;
        }
        return count;
    }

    /**
     * Time Complexity O(Log N)
     *
     * @param arr
     * @param target
     * @return
     */
    public static int findFrequencyInSortedArrayOptimal(int[] arr, int target) {
        //Find elements in the left side
        int first = -1;
        int last = -1;
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                first = mid;
                high = mid - 1;
            } else if (target < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        //Find elements in the Right side
        low = 0;
        high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                last = mid;
                low = mid + 1;
            } else if (target > arr[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        if (first == -1) {
            return 0;
        }
        return last - first + 1;

    }
}
