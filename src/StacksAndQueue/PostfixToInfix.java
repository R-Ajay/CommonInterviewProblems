package StacksAndQueue;

import java.util.Stack;

public class PostfixToInfix {
    public static void main(String[] args) {
        String s = "ab*c+";
        System.out.println(postfixToInfix(s));
    }

    private static String postfixToInfix(String s) {
        Stack<String> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                stack.push(String.valueOf(ch));
            } else {
                String top2 = stack.pop();
                String top1 = stack.pop();
                result.append("(" + top1 + ch + top2 + ")");
                stack.push(result.toString());
                result.delete(0, result.length());
            }
        }
        return stack.pop();
    }
}
