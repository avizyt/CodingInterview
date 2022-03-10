package com.topics.bitmanipulation;

public class SubtractBinary {
    public static void main(String[] args) {
        int q = 2345;
        int p = 324;
        System.out.println("Normal Subtract: " + (q - p));
        System.out.println("Bitwise Subtract: " + subtract(q, p));
    }

    public static int subtract(int q , int p){
        while ( p != 0){
            // borrow the unset bits of q AND set bits of p
            int borrow = (~q) & p;

            // subtraction of bits q and p
            // where at least one of the bits is not set
            q = q ^ p;

            // left shift borrow by one position
            p = borrow << 1;
        }
        return q;
    }
}
