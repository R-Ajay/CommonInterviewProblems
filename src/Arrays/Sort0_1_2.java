package Arrays;

import java.util.Arrays;

public class Sort0_1_2 {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 0, 1, 2, 1, 2, 0, 0, 0, 1};
//        bruteForce(arr);
        optimal(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * Time Complexity O(N)
     * National Dutch Flag Algorithm
     *
     * @param arr
     */
    private static void optimal(int[] arr) {
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;
        while(mid<=high){
            if(arr[mid] == 1){
                mid++;
            }else if (arr[mid] == 0){
                swap(arr, low, mid);
                low++;
                mid++;
            }else{
                swap(arr, mid, high);
                high--;
            }
        }
    }

    private static void swap(int[] arr, int low, int high){
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
    }

    /**
     * Time Complexity O(N * Log N)
     *
     * @param arr
     */
    private static void bruteForce(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int low, int high) {
        if (low >= high)
            return;
        int mid = (low + high) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, mid + 1, high);
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[mid + high];
        int k = 0;
        int left = low;
        int right = mid;
        while (left < mid && right <= high) {
            if (arr[left] < arr[right]) {
                temp[k++] = arr[left++];
            } else {
                temp[k++] = arr[right++];
            }
        }

        while (left < mid) {
            temp[k++] = arr[left++];
        }

        while (right <= high) {
            temp[k++] = arr[right++];
        }

        for (int i = low; i <= high; i++) {
            arr[i] = temp[i - low];
        }
    }
}
