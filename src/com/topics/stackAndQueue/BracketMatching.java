package com.topics.stackAndQueue;

import java.util.Stack;

public class BracketMatching {
    public static void main(String[] args) {
        String bracesStr = "{{{}{}{}{}}";
        System.out.println(matcher(bracesStr));
    }

    public static boolean matcher(String bracesStr){
        Stack<Character> stackBraces = new Stack<>();

        int len = bracesStr.length();
        for (int i = 0; i < len; i++) {
            switch (bracesStr.charAt(i)){
                case '{':
                    stackBraces.push(bracesStr.charAt(i));
                    break;

                case '}':
                    if (stackBraces.isEmpty()){
                        return false;
                    }

                    // for every match we pop the corresponding '{'
                    stackBraces.pop();
                    break;

                default:
                    return false;
            }
        }
        return stackBraces.empty();
    }
}
