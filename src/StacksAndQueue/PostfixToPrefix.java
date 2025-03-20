package StacksAndQueue;

import java.util.Stack;

public class PostfixToPrefix {
    public static void main(String[] args) {
        String s = "ABC/-AK/L-*"; //*-A/BC-/AKL
        System.out.println(postfixToPrefix(s));
    }

    private static String postfixToPrefix(String s) {
        StringBuilder temp = new StringBuilder();
        Stack<String> stack = new Stack<>();
        for (char ch : s.toCharArray()){
            if(Character.isLetterOrDigit(ch)){
                stack.push(String.valueOf(ch));
            }else{
                String top2 = stack.pop();
                String top1 = stack.pop();
                temp.append(ch + top1 + top2);
                stack.push(temp.toString());
                temp.delete(0, temp.length());
            }
        }
        return stack.pop();
    }
}
