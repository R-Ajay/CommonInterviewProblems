package Recursion;

import java.util.Arrays;

public class ReverseArrayUsingRecursion {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        reverseArrayUsingRecursion(0, args.length - 1, arr);
        reverseArrayUsingLoop(args.length - 1, arr);
        System.out.println("Recursion: " + Arrays.toString(arr));
        System.out.println("Loop: " + Arrays.toString(arr));
    }

    private static void reverseArrayUsingRecursion(int left, int right, int[] arr) {

        if (left >= right) return;

        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
        reverseArrayUsingRecursion(left + 1, right - 1, arr);
    }

    private static void reverseArrayUsingLoop(int n, int[] arr) {
        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
