package StacksAndQueue;

import java.security.KeyPair;
import java.util.Stack;

public class MinStack {
    Stack<Value> stack = null;

    MinStack() {
        stack = new Stack<>();
    }

    private static class Value {
        private int first;
        private int second;

        Value(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(new Value(val, val));
        } else {
            stack.push(new Value(val, Math.min(val, stack.peek().second)));
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().first;
    }

    public int getMin() {
        return stack.peek().second;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        minStack.top();    // return 0
        System.out.println(minStack.getMin()); // return -2
    }

}
