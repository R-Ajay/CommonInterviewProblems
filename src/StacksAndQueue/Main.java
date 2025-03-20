package StacksAndQueue;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
//        printStackUsingArray();
//        printQueueUsingArray();
       printStackUsingLinkedList();
//        printQueueUsingArray();
    }

    private static void printStackUsingLinkedList() {
        System.out.println("Stack Using LinkedList");
        StackImplUsingLinkedList stack = new StackImplUsingLinkedList();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.display();
        stack.pop();
        stack.pop();
        System.out.println("Peek Element: " + stack.peek());
        stack.pop();
        stack.pop();
        stack.push(10);
        stack.display();
    }

    private static void printQueueUsingArray() {
        System.out.println("Queue Using Array");
        QueueImplUsingArray queue = new QueueImplUsingArray();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        while (queue.size() > 0) {
            System.out.print(queue.pop() + " ");
        }
    }

    private static void printStackUsingArray() {
        System.out.println("Stack Using Array");
        StackImplUsingArray stack = new StackImplUsingArray();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        while (stack.size() > 0) {
            System.out.print(stack.pop() + " ");
        }
    }

}
