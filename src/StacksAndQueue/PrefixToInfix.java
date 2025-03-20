package StacksAndQueue;

import java.util.Stack;

public class PrefixToInfix {
    public static void main(String[] args) {
        String s = "*-A/BC-/AKL";
        System.out.println(prefixToInfix(s));
    }

    private static String prefixToInfix(String s) {
        Stack<String> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                stack.push(String.valueOf(s.charAt(i)));
            } else {
                String top1 = stack.pop();
                String top2 = stack.pop();
                result.append("(" + top1 + s.charAt(i) + top2 + ")");
                stack.push(result.toString());
                result.delete(0, result.length());
            }
        }
        return stack.pop();
    }
}
