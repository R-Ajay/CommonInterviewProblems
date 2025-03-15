package Arrays;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class RemoveDuplicateElements {
    public static void main(String[] args) {
        int[] arr = {1,2,2,3,3,4,4,4,5,5};
        int[] arr1 = {1,2,2,3,3,4,4,4,5,5};
//        int[] arr = {4,4,5,6,8,9,6};
        System.out.println("Better Unique Element length is: " + removeDuplicateBetter(arr));
        System.out.println("Brute Unique Element length is: " + removeDuplicateBrute(arr));
        System.out.println("Stream Unique Element length is: " + Arrays.toString(removeDuplicateUsingStream(arr1)));
    }

    private static int removeDuplicateBrute(int[] arr) {
        Set<Integer> set = new LinkedHashSet<>();
        for(int i : arr){
            set.add(i);
        }
        int index = 0;
       for(int i : set){
           arr[index++] = i;
       }
        System.out.println( Arrays.toString(arr));
        return set.size();
    }

    private static int[] removeDuplicateUsingStream(int[] arr1) {
        return Arrays.stream(arr1).distinct().toArray();
    }

    private static int removeDuplicateBetter(int[] nums) {
        int i = 0;
        for(int j = 1; j< nums.length;j++){
            if(nums[j]!=nums[i]){
                nums[i+1] = nums[j];
                i++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return i + 1;
    }
}
