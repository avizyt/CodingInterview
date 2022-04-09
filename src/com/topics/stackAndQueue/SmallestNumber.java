package com.topics.stackAndQueue;

import java.util.Stack;

public class SmallestNumber {
    public static void main(String[] args) {
        String num = "4514327";
        int k = 4;
        smallest(num, k);
    }

    public static void smallest(String num, int k){
        int i = 0;
        Stack<Character> stack = new Stack<>();
        while (i < num.length()) {
            while (k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i)){
                stack.pop();
                k--;
            }

            stack.push(num.charAt(i));
            i++;
        }
        while (k > 0){
            stack.pop();
            k--;
        }
        System.out.println(stack);
    }
}
