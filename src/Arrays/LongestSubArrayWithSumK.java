package Arrays;

public class LongestSubArrayWithSumK {
    public static void main(String[] args) {
       // int[] arr = {1, 2, 3, 1, 1, 1, 1};
        int[] arr = {8, 15, 17, 0, 11};
        //int[] arr = {1, 2, 1, 3};
        int k = 17;
        findLongestSubArrayWithSumKPositive(arr, arr.length, k);
    }

    private static void findLongestSubArrayWithSumKPositive(int[] arr, int length, int k) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < arr.length ; i++) {
            for(int j = i; j < arr.length; j++){
                sum += arr[j];
                count++;
                if(sum > k){
                    sum-= arr[j];
                }
                if(sum == k ){
                    if( count > max){
                        max = count;
                    }
                    sum = 0;
                    count =0;
                }else if(sum > k){
                    break;
                }
            }
            sum = 0;
            count =0;
        }
        System.out.println("Maximum SubArray Length: " + max);
    }
}
