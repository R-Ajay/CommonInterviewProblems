package StacksAndQueue;

public class QueueImplUsingArray {
    private int[] arr;
    private int start = -1;
    private int end = -1;

    private int size = 0;

    QueueImplUsingArray() {
        arr = new int[10];
    }

    public boolean push(int element) {
        if (start == -1) {
            start++;
            end++;
            arr[start] = element;
        } else {
            arr[++end] = element;
        }
        size++;
        return true;
    }

    public int pop() {
        int temp = -1;
        if (start == -1) {
            return temp;
        } else if (start == end) {
            temp = arr[start];
            start = -1;
            end = -1;
        } else {
            temp = arr[start];
            start++;
        }
        size--;
        return temp;
    }

    public int peek() {
        if (start == -1) return -1;
        return arr[start];
    }

    public int size() {
        return size;
    }
}
