package com.topics.stackAndQueue;

import java.util.LinkedList;
import java.util.Stack;

public class StackOfPlates {
    public static void main(String[] args) {

    }

    public static final int STACK_SIZE = 3;

    private final LinkedList<Stack<Integer>> stacks = new LinkedList<>();

    public void push(int val) {
        // if there is no stack or the last stack is full
        if (stacks.isEmpty() || stacks.getLast().size() >= STACK_SIZE){

            // create a new stack and push the value into it
            Stack<Integer> stack = new Stack<>();
            stack.push(val);

            // add the new stack into the list of stacks
            stacks.add(stack);
        } else {
            // add the value in the last stack
            stacks.getLast().push(val);
        }
    }

    public Integer pop() {
        // find the last stack
        Stack<Integer> lastStack = stacks.getLast();

        // pop the value from the last stack
        int val = lastStack.pop();

        // if last stack is empty, remove it form the list of stacks
        removeStackIfEmpty();

        return val;
    }
    private void removeStackIfEmpty() {
        if (stacks.getLast().isEmpty()) {
            stacks.removeLast();
        }
    }

    public Integer popAt(int stackIndex) {
        // get the value from the corresponding stack
        int val = stacks.get(stackIndex).pop();

        // pop an element -> must shift the remaining elements
        shift(stackIndex);

        removeStackIfEmpty();

        return val;
    }

    private void shift(int index) {
        for (int i = 0; i < stacks.size() - 1; i++) {
            Stack<Integer> curStack = stacks.get(i);
            Stack<Integer> nextStack = stacks.get(i + 1);

            curStack.push(nextStack.remove(0));
        }
    }
}
