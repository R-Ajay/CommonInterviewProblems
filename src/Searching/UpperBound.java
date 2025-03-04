package Searching;

public class UpperBound {
    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 7};
        int x = 5;
        System.out.println(upperBound(arr, x, arr.length));
    }

    public static int upperBound(int[] arr, int x, int n) {
        // Write your code here.
        int low = 0;
        int high = n - 1;
        int index = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > x) {
                index = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return index;
    }
}
