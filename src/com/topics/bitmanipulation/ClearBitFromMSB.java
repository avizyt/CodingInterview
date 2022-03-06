package com.topics.bitmanipulation;

/* Problem:
Consider a 32-bit integer, n. Write a snippet of code that clears the bits of n (sets
their value to 0) between the MSB and the given k.
 */

import java.util.Calendar;

public class ClearBitFromMSB {
    public int clearBit(int n, int k){
        /*
         step1: Left shifting 1 with k position
         Step2: then subtracting 1 from it will give us the bit-mask
         Step3: then AND with n.

         */
        return n & ((1 << k) - 1);
    }

    public static void main(String[] args) {
        int n = 423;
        int k = 6;
        ClearBitFromMSB clear = new ClearBitFromMSB();
        System.out.println(clear.clearBit(n, k));
    }
}
