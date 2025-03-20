package StacksAndQueue;

public class StackImplUsingArray {
    private int top = -1;
    private int[] arr = null;

    StackImplUsingArray() {
        arr = new int[10];
    }

    public boolean push(int element) {
        top = top + 1;
        arr[top] = element;
        return true;
    }

    public int pop() {
        if (top == -1) return -1;
        int element = arr[top];
        top = top - 1;
        return element;
    }

    public int peek() {
        if (top == -1) return -1;
        return arr[top];
    }

    public int size() {
        return top + 1;
    }
}
