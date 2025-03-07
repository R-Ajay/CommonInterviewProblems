package Searching;


/**
 * Arrays contain duplicate elements
 */
public class SearchArrayInSortedArray_2 {
    public static void main(String[] args) {
//        int[] arr = {1, 0, 1, 1, 1};
//        int target = 0;

        int[] arr = {4, 5, 6, 7, 8, 1, 2, 3, 3, 3, 4, 4, 4};
        int target = 5;
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
    private static boolean optimal(int[] arr, int target) {
        boolean result = false;
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                return !result;
            } else if (arr[low] == arr[mid] && arr[mid] == arr[high]) {
                low = low + 1;
                high = high - 1;
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
        return result;
    }

    /**
     * Time Complexity O(N)
     *
     * @param arr
     * @param target
     * @return
     */
    private static boolean bruteforce(int[] arr, int target) {
        boolean result = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target)
                return !result;
        }
        return result;
    }
}
