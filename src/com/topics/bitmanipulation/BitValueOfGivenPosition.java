package com.topics.bitmanipulation;

/* Consider a 32-bit integer, n. Write a snippet of code that returns the bit value of
n at the given position, k.

 */

public class BitValueOfGivenPosition {
    public static void main(String[] args) {
        int n = 423;
        int k = 7;
        System.out.println(getValueApproachOne(n,k));
        System.out.println(getValueApproachTwo(n,k));

    }
    public static char getValueApproachOne(int n, int k){
        int result = n & (1 << k);

        if (result == 0){
            return '0';
        }
        return '1';
    }

    public static char getValueApproachTwo(int n , int k){
        int intermediate = n >> k;
        int result = intermediate & 1;
        if (result == 0){
            return '0';
        }
        return '1';
    }

}
