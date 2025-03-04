package Searching;

public class LowerBound {
    public static void main(String[] args) {
         int[] arr = {1, 2, 2, 3};
         int x = 0;
        System.out.println(lowerBound(arr, arr.length, 0));
    }

    public static int lowerBound(int []arr, int n, int x) {
        // Write your code here
        int low = 0;
        int high = n - 1;
        int index = n;
        while(low<=high){
            int mid = low + ( high - low) / 2;
            if(arr[mid]>=x){
                index = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return index;
    }
}
