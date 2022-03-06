package com.topics.bitmanipulation;

public class ClearBitFromPosition {
    public int clearBit(int n, int k){

        /*
        Step1: Left shift 1 with k
        Step2: subtracting 1 from it
        Step3: apply unary operation on the value to get the reverse of it.
        Step4: Do AND operation with n.
         */
        return n & ~ ((1 << k) - 1);
    }

    public static void main(String[] args) {
        int n = 423;
        int k = 6;
        ClearBitFromPosition clear = new ClearBitFromPosition();
        System.out.println(clear.clearBit(n, k));
    }
}
