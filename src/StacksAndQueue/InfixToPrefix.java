package StacksAndQueue;

import java.util.Stack;

public class InfixToPrefix {
    public static void main(String[] args) {
        String s = "(a-b/c)*(a/k-l)";
        s = reverseTheString(s);
        s = infixToPostfix(s);
        s = reverseTheString(s);
        System.out.println(s);
    }

    private static String reverseTheString(String s) {
        StringBuilder result = new StringBuilder(s.length());
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch == '(') {
                result.append(')');
            } else if (ch == ')') {
                result.append('(');
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }

    public static String infixToPostfix(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9')) {
                result.append(ch);
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')' && !stack.isEmpty()) {
                while (stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && priority(ch) < priority(stack.peek())) {
                    result.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.toString();
    }

    private static int priority(char ch) {
        switch (ch) {
            case '^':
                return 3;
            case '/':
            case '*':
                return 2;
            case '-':
            case '+':
                return 1;
            default:
                return -1;
        }
    }
}
