package StacksAndQueue;

import java.util.Stack;

public class InfixToPostfix {
    public static void main(String[] args) {
        String s = "h^m^q^(7-4)";
        System.out.println(infixToPostfix(s));
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
                while (!stack.isEmpty() && priority(ch) <= priority(stack.peek())) {
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
        if (ch == '^') {
            return 3;
        } else if (ch == '/' || ch == '*') {
            return 2;
        } else if (ch == '-' || ch == '+') {
            return 1;
        }
        return -1;
    }
}
