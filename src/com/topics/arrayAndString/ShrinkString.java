package com.topics.arrayAndString;

import java.util.HashMap;
import java.util.Map;

public class ShrinkString {
    public static void main(String[] args) {
        String str = "abbb vvv rttt s rr eeee f";
        System.out.println(shrink(str));
    }

    public static String shrink(String str) {
        StringBuilder result = new StringBuilder();

        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            count++;

            // don't count white space , jsu copy them
            if (!Character.isWhitespace(str.charAt(i))){
                if ((i + 1) >= str.length()
                    || str.charAt(i) != str.charAt(i + 1)) {

                    result.append(str.charAt(i)).append(count);

                    // reset the counter
                    count = 0;
                }
            } else {
                result.append(str.charAt(i));
                count = 0;
            }
        }
        return result.length() > str.length() ? str : result.toString();
    }
}
