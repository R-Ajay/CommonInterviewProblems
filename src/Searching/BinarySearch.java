package Searching;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 4, 7, 9, 10, 12, 16};
        int target = 12;
        binarySearch(arr, target);
    }

    private static void binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2; // To avoid overflow
            if (arr[mid] == target) {
                System.out.println("The Element is found at: " + (mid + 1));
                break;
            }
            else if (target > arr[mid]) low = mid + 1;
            else high = mid - 1;
        }
    }
}
