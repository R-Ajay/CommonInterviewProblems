package TwoPointerSlidingWindow;

public class MaximumConsectiveZerosWithK {
    public static void main(String[] args) {
        int k = 2;
        int[] arr = {1, 1, 1, 0, 0, 1, 1, 1, 1, 0};
        findMaximumConsectiveZerosWithK(arr, k);
    }

    private static void findMaximumConsectiveZerosWithK(int[] arr, int k) {
        int left = 0;
        int right = 0;
        int maxlength = 0;
        int zeros = 0;
        while(right < arr.length){
            if(arr[right] == 0){
                zeros++;
            }
            while(zeros > k){
                if(arr[left] == 0){
                    zeros--;
                }
                left++;
            }
            maxlength = Math.max(right - left + 1, maxlength);
            right++;
        }
        System.out.println("Maximum consective subarrays: " + maxlength);
    }
}
