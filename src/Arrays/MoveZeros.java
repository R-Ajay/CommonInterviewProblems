package Arrays;

import java.util.Arrays;

public class MoveZeros {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 0, 2, 2, 2, 0, 0, 4, 5, 1};
        moveZeros(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void moveZeros(int[] arr) {
        int j = -1;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 0){
                j = i;
                break;
            }
        }

        if(j != -1){
            for (int i = j + 1; i < arr.length; i++) {
                if(arr[i] != 0){
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                    j++;
                }
            }
        }
    }
}
