package com.topics.stackAndQueue;

import java.util.Stack;

public class Experiment {
    public static void main(String[] args) {
        int[] arr = {4, 2, 8, 6, 5, 3};
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= arr.length - 1; i++) {
            stack.push(arr[i]);
        }
        System.out.println(stack);
        for (int j = 0; j <= arr.length -1; j++) {
            System.out.println("Popped Item: " + stack.pop());
            if (!stack.isEmpty())
                System.out.println("Last Item Now: " + stack.peek());
        }


    }
}
