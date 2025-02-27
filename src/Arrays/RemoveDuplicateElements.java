package Arrays;

import java.util.Arrays;

public class RemoveDuplicateElements {
    public static void main(String[] args) {
       // int[] arr = {1,2,2,3,3,4,4,4,5,5};
        int[] arr = {4,4,5,6,8,9,6};
        System.out.println("Unique Element length is: " + removeDuplicate(arr));
    }

    private static int removeDuplicate(int[] arr) {
        int i = 0;
        int j = 1;
        while(j < arr.length && i+1 < arr.length){
            if(arr[i]!=arr[j]){
                int temp = arr[i+1];
                arr[i+1]=arr[j];
                arr[j]=temp;
                i++;
                j++;
            }else{
                j++;
            }
        }
        System.out.println(Arrays.toString(arr));
        return i + 1;
    }
}
