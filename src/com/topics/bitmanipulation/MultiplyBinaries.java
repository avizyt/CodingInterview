package com.topics.bitmanipulation;

public class MultiplyBinaries {
    public static void main(String[] args) {
        int q = 5;
        int p = 2;
        System.out.println(multiply(q, p));
    }
    public static int multiply(int q, int p) {
        int result = 0;

        while( p != 0){
            // compute the value of q only when the LSB of p is 1
            if ((p & 1) != 0) {
                result = result + q;
            }

            q = q << 1;   // q is left shifted with 1 position
            p = p >>> 1;  // p is logical right shifted with 1 position
        }
        return result;
    }
}
