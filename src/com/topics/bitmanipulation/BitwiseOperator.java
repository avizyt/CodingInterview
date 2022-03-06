package com.topics.bitmanipulation;

public class BitwiseOperator {
    public static void main(String[] args) {
        int x = 24;
        int xLeftShift = x << 3;
        int xRightShift = x >> 1;
        System.out.println("Binary of " + x +" is "+ Integer.toBinaryString(x));
//        System.out.println("Left Shift one: "+ xLeftShift);
//        System.out.println("Binary of " + xLeftShift +" is "+ Integer.toBinaryString(xLeftShift));
        System.out.println("Right Shift one: "+ xRightShift);
        System.out.println("Binary of " + xRightShift +" is "+ Integer.toBinaryString(xRightShift));

    }
}
