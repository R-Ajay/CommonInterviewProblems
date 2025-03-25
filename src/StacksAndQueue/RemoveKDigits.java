package StacksAndQueue;

import java.util.Stack;

public class RemoveKDigits {
    public static void main(String[] args) {
//        String num = "1432219";
//        int k = 3; //Output: 1219

//          String num = "10200";
//          int k = 1; //Output : 200

//        String num = "10";
//        int k = 2; //Output : 200

//        String num = "9";
//        int k = 1; //Output : 0

        String num = "1234567890";
        int k = 9; //Output : 0
        System.out.println(optimal(num, k));
    }

    private static String optimal(String num, int k) {
        if (num.length() == k) {
            return "0";
        }

        Stack<Character> stack = new Stack<>();
        for (char ch : num.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && stack.peek() > ch) {
                stack.pop();
                k--;
            }
            stack.push(ch);
        }
        //Remove remaining elements
        while (k > 0) {
            stack.pop();
            k--;
        }

        return reverse(stack);
    }

    private static String reverse(Stack<Character> stack) {
        StringBuilder result = new StringBuilder();

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        result.reverse();

        while (result.length() > 1 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }
        return result.toString();
    }
}
