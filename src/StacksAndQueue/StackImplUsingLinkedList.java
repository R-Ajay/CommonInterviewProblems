package StacksAndQueue;

public class StackImplUsingLinkedList {
    private Node top;
    private int size;

    public void push(int element) {
        Node temp = new Node(element);
        temp.next = top;
        top = temp;
        size++;
    }

    public int pop() {
        if (top == null) {
            System.out.println("Stack is Empty");
            return -1;
        }
        int popedData = top.data;
        top = top.next;
        return popedData;
    }

    public int peek() {
        return top == null ? -1 : top.data;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void display() {
        if (top == null) {
            System.out.println("Stack is Empty");
            return;
        }
        Node current = top;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }

    class Node {
        private int data;
        private Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }


}
