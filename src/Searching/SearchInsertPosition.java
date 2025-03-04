package Searching;

public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] arr = {1, 4, 7, 9, 10, 12, 16};
//        int target = 12;
        int target = 18;
        System.out.println("Brute " + searchInsertBrute(arr, target));
        System.out.println("Optimal " + searchInsertOptimal(arr, target));
    }

    /**
     * //Time Complexity O(Log n)
     *
     * @param arr
     * @param target
     * @return
     */
    public static int searchInsertOptimal(int[] arr, int target) {

        int low = 0;
        int high = arr.length - 1;
        int ans = arr.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] >= target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    /**
     * Time Complexity O(N)
     *
     * @param arr
     * @param target
     * @return
     */
    public static int searchInsertBrute(int[] arr, int target) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target || target < arr[i])
                return i;
        }
        return arr.length;
    }
}
