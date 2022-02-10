package com.topics.arrayAndString;

public class UniqueCharcterAZ {
    private static final char A_CHAR = 'a';

    private UniqueCharcterAZ() {
        throw new AssertionError("Cannot be instantiated.");
    }

    public static boolean isUnique(String str) {
        if (str == null || str.isBlank()) {
            return false;
        }

        int marker = 0;
        for (int i = 0; i < str.length(); i++) {
            int s = str.charAt(i) - A_CHAR;
            int mask = 1 << s;

            if ((marker & mask) > 0){
                return false;
            }

            marker = marker | mask;
        }

        return true;
    }

    public static void main(String[] args) {
        String text1 = "abcdefhzqoc";
        String text2 = "abcdefhzqw";

        boolean resultText1 = UniqueCharcterAZ.isUnique(text1);
        boolean resultText2 = UniqueCharcterAZ.isUnique(text2);

        System.out.println("Text1 has unique characters? " + resultText1);
        System.out.println("Text2 has unique characters? " + resultText2);
    }
}
