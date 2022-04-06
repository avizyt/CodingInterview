package com.topics.stackAndQueue;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.EmptyStackException;


public final class MyStack<E> {
    public static void main(String[] args) {
        MyStack stk = new MyStack();
        int[] arr = {1,2,3,4,5,6,7,8,9,10};

        for (int i = 0; i < arr.length; i++) {
            int pushed = (int) stk.push(arr[i]);
            System.out.println("Item at the "+i+"-Position :"+pushed);
        }

        System.out.println("Size of Stack: " + stk.top);
        System.out.println("Is Empty?: " + stk.isEmpty());
        System.out.println("Is Full?: " + stk.isFull());

        for (int i = 0; i < arr.length; i++) {
            int poped = (int) stk.pop();
            System.out.println("Item at the " + i +"-Position : " + poped);

        }
        System.out.println("Is Empty?: " + stk.isEmpty());
        System.out.println("Is Full?: " + stk.isFull());


    }

    private static final int DEFAULT_CAPACITY = 10;

    private int top;
    private E[] stack;

    MyStack() {
        stack = (E[])Array.newInstance(
                Object[].class.getComponentType(),
                DEFAULT_CAPACITY);

        top = 0; // the initial size is 0
    }

    // pushing an element to the end of the stack or top of the stack
    public E push(E e) {
        // if the stack is full, we double its capacity
        if (isFull()){
            ensureCapacity();
        }

        // adding element at the top of the stack
        stack[top++] = e;
        return e;
    }

    // pop the end element or the top element from the stack
    public E pop() {
        // if the stack is empty just throw an exception
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        // extract the top element from the stack
        E e = stack[--top];

        stack[top] = null;

        return  e;
    }

    // Peeking an element from the stack means returning the element
    // that was added last the underlying array but without removing it from this array.

    public E peek() {
        if (isEmpty()){
            throw new EmptyStackException();
        }
        return stack[top - 1];
    }
    public int size() {
        return stack.length;
    }
    public boolean isEmpty() {
        return top == 0;
    }
    public boolean isFull() {
        return top == DEFAULT_CAPACITY;
    }
    private void ensureCapacity() {
        int newSize = stack.length * 2;
        stack = Arrays.copyOf(stack, newSize);
    }
}
