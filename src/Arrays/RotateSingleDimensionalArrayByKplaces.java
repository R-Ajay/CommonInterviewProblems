package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RotateSingleDimensionalArrayByKplaces {
    public static void main(String[] args) {
        int n = 3; //N places to rotate
        List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5);
        int k = n % arr.size() ;
        rotateTheArray(arr, 0, k - 1);
        rotateTheArray(arr, k, arr.size() - 1);
        rotateTheArray(arr, 0, arr.size() - 1);
        System.out.println(arr);
    }

    private static void rotateTheArray(List<Integer> arr, int start, int end){
        while(start < end){
            int temp = arr.get(start);
            arr.set(start, arr.get(end));
            arr.set(end, temp);
            start++;
            end--;
        }

    }
}
