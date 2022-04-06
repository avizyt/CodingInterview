package com.topics.stackAndQueue;

import java.util.Stack;

public class QueueViaStack<E> {
    public static void main(String[] args) {

    }
    private final Stack<E> stackEnqueue;
    private final Stack<E> stackDequeue;

    public QueueViaStack() {
        stackEnqueue = new Stack<E>();
        stackDequeue = new Stack<E>();
    }

    public void enqueue(E e){
        stackEnqueue.push(e);
    }

    public E dequeue() {
        reverseStackEnqueue();
        return stackDequeue.pop();
    }

    public int peek() {
        return stackEnqueue.size() + stackDequeue.size();
    }

    private void reverseStackEnqueue() {
        if (stackDequeue.isEmpty()) {
            while (!stackEnqueue.isEmpty()) {
                stackDequeue.push(stackEnqueue.pop());
            }
        }
    }
}
