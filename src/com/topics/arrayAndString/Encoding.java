package com.topics.arrayAndString;

public class Encoding {

    public static char[] encodeWhitespace(char[] str) {
        // count whitespaces
        int countWhitespaces = 0;
        for (int i = 0; i < str.length; i++) {
            if (Character.isWhitespace((str[i]))) {
                countWhitespaces++;
            }
        }
        if (countWhitespaces > 0){
            // create the encoded char[]
            char[] encodedStr = new char[str.length + countWhitespaces * 2];

            // populate the encoded char[]
            int index = 0;
            for (int i = 0; i < str.length; i++) {
                if (Character.isWhitespace(str[i])) {
                    encodedStr[index] = '0';
                    encodedStr[index + 1] = '2';
                    encodedStr[index + 2] = '%';
                    index = index + 3;
                } else {
                    encodedStr[index] = str[i];
                    index++;
                }
            }
            return encodedStr;
        }
        return str;
    }

    public static void main(String[] args) {
        char[] str = " i am a good programmer ".toCharArray();

        char[] ans = Encoding.encodeWhitespace(str);
        System.out.println(ans);

    }
}
