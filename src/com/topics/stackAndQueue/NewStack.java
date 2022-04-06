package com.topics.stackAndQueue;

import java.util.EmptyStackException;
import java.util.Stack;

public class NewStack {
    public static void main(String[] args) {

    }

    private int min;
    private final Stack<Integer> stack = new Stack<>();

    public void push(int val){
        // we don't allow value that overflow int/2 range
        int r = Math.addExact(val, val);

        if (stack.empty()){
            stack.push(val);
            min = val;
        } else if (val > min) {
            stack.push(val);
        } else {
            stack.push(r - min);
            min = val;
        }
    }

    // pop() doesn't return the value since this may be a wrong
    // value (a value that was not pushed by the client)!
    public void pop() {
        if (stack.empty()) {
            throw new EmptyStackException();
        }

        int top = stack.peek();
        if (top < min) {
            min = 2 * min - top;
        }
        stack.pop();
    }
    public int min() {
        return min;
    }
}
