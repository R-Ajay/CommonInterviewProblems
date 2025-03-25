package StacksAndQueue;

import java.util.Arrays;
import java.util.Stack;

public class Nearest_Smallest_Element {
    public static void main(String[] args) {
       int[] a = {4, 5, 2, 10, 8}; // Output: [-1, 4, -1, 2, 2]
//        int[] a = {3, 2, 1}; // Output: [-1, -1, -1]
        System.out.println("Optimal: " + Arrays.toString(optimal(a)));
    }

    public static int[] optimal(int[] a) {
        Stack<Integer> stack = new Stack<>();
        int[] nextSmallest = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            while (!stack.isEmpty() && stack.peek() >= a[i]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                nextSmallest[i] = stack.peek();
            }else{
                nextSmallest[i] = -1;
            }

            stack.push(a[i]);
        }

        return nextSmallest;
    }
}
