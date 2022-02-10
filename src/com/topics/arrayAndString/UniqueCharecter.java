package com.topics.arrayAndString;

import java.util.HashMap;
import java.util.Map;

public class UniqueCharecter {
    private static final int MAX_CODE = 65535;

    private UniqueCharecter() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static boolean isUnique(String str){
        if (str == null || str.isBlank()){
            return false;
        }

        Map<Character, Boolean> chars = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {

            if (str.codePointAt(i) <= MAX_CODE) {
                char ch = str.charAt(i);
                if (!Character.isWhitespace(ch)){
                    if (chars.put(ch, true) != null){
                    return false;
                }
            }
            } else {
                System.out.println("The given string contains unallowed charecters.");
                return false;
            }

    }
        return true;
}

    public static void main(String[] args) {
        String text = "a b c d";
        String unicode = "豈 更 車 賈 滑 更"; // 更 is repeated
        String mixed = "a 豈 b 更 ￦";

        boolean resultText = UniqueCharecter.isUnique(text);
        boolean resultUnicode = UniqueCharecter.isUnique(unicode);
        boolean resultMixed = UniqueCharecter.isUnique(mixed);

        System.out.println("ASCII text has unique characters? " + resultText);
        System.out.println("Unicode text has unique characters? " + resultUnicode);
        System.out.println("Mixed text has unique characters? " + resultMixed);
    }
}
