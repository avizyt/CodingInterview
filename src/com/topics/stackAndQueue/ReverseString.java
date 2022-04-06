package com.topics.stackAndQueue;

import java.util.Stack;

public class ReverseString {
    public static void main(String[] args) {
        String str = "Dougong doing it long";
        String reversed = reverse(str);
        System.out.println(reversed);
    }

    public static String reverse(String str){
        Stack<Character> stack = new Stack<>();

        // push chars of the string into the stack
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            stack.push(chars[i]);
        }

        //pop all characters from the stack and
        // put then back to the input string
        for (int i = 0; i < str.length(); i++) {
            chars[i] = stack.pop();
        }

        return new String(chars);
    }
}
