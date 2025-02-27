package Arrays;

import java.util.Arrays;

public class RotateTwoDimensionalArray90Degdree {
    public static void main(String[] args) {
//        int[][] arr ={
//                {1,2,3},
//                {4,5,6},
//                {7,8,9}
//        };
        int[][] arr = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        rotateArray90degree(arr);

    }

    private static void rotateArray90degree(int[][] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                //reverse
                int temp = arr[i][n - 1 - j];
                arr[i][n - 1 - j] = arr[i][j];
                arr[i][j] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                //Row to column
                int temp = arr[i][j];
                arr[i][j] = arr[n - 1 - j][n - 1 - i];
                arr[n - 1 - j][n - 1 - i] = temp;
            }
        }

        for (int[] result : arr) {
            System.out.println(Arrays.toString(result));
        }
    }


}
