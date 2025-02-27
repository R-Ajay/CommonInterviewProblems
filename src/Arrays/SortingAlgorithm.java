package Arrays;

import java.util.Arrays;

public class SortingAlgorithm {

    public static void main(String[] args) {
        int[] arr = {6, 9, 14, 15, 8, 10, 11, 12, 13, 7};
//        selectionSort(arr);
//        bubbleSort(arr);
        mergeSorts(arr, 0, arr.length - 1);
        System.out.println("Merge Sort" + Arrays.toString(arr));
    }

    private static void mergeSorts(int[] arr, int low, int high) {
        if (low == high)
            return;
        int mid = (low + high) / 2;
        mergeSorts(arr, low, mid); //left
        mergeSorts(arr, mid + 1, high); //Right
        merge(arr, low, mid + 1, high);
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        int k = 0;
        int[] temp = new int[mid + high];
        int left = low;
        int right = mid;
        while (left < mid && right <= high) {
            if (arr[left] < arr[right]) {
                temp[k++] = arr[left++];
            } else {
                temp[k++] = arr[right++];
            }
        }
        while (left < mid){
            temp[k++] = arr[left++];
        }
        while (right <= high){
            temp[k++] = arr[right++];
        }

        for (int i = low; i <= high ; i++) {
            arr[i] = temp[i - low];
        }

    }

    private static void bubbleSort(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j <= i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

}
