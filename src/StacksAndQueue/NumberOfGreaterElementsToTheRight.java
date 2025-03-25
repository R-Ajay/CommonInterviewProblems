package StacksAndQueue;

import java.util.Arrays;

//https://www.geeksforgeeks.org/problems/number-of-nges-to-the-right/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=number-of-nges-to-the-right
public class NumberOfGreaterElementsToTheRight {
    public static void main(String[] args) {
        int arr[] = {3, 4, 2, 7, 5, 8, 10, 6};
        int queries = 2;
        int indices[] = {0, 5}; //Output: [6, 1]
        System.out.println(Arrays.toString(count_NGEs_brute(arr, indices, queries)));
    }

    private static int[] count_NGEs_brute(int[] arr, int[] indices, int queries) {
        int[] result = new int[queries];
        for (int i = 0; i < queries; i++) {
            int count = 0;
            for (int j = indices[i] + 1, k = indices[i]; j < arr.length; j++) {
                if (arr[k] < arr[j]) {
                    count++;
                }
            }
            result[i] = count;
        }

        return result;
    }
}
