package Arrays;

public class PrintSubarrayWithMaximumSubarraySum {
    public static void main(String[] args) {
        int arr[] = {4, 3, 1, 5, 6}; //Output: 11
//        int arr[] = {5, 4, 3, 1, 6} ; //Output: 9
        System.out.println(pairWithMaxSum(arr));
    }
    public static int pairWithMaxSum(int arr[]) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length - 1; i++){
            max = Math.max(arr[i] + arr[i+1], max);
        }
        return max;
    }
}
