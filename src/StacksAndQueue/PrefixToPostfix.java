package StacksAndQueue;

import java.util.Stack;

public class PrefixToPostfix {
    public static void main(String[] args) {
        String s = "*-A/BC-/AKL"; // ABC/-AK/L-*
        System.out.println(prefixToPostfix(s));
    }
    private static String prefixToPostfix(String s) {
        Stack<String> stack = new Stack<>();
        StringBuilder temp = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                stack.push(String.valueOf(s.charAt(i)));
            } else {
                String top2 = stack.pop();
                String top1 = stack.pop();
                temp.append(top2 + top1 + s.charAt(i));
                stack.push(temp.toString());
                temp.delete(0, temp.length());
            }
        }
        return stack.pop();
    }

}
