package com.topics.bitmanipulation;

public class SetTheBitValue {
    public static int setValueToZero(int n, int k) {
        int intermediate = ~(1 << k);
        return n & intermediate;
    }
    public static int setValueToOne(int n, int k){
        return n | (1 << k);
    }

    public static void main(String[] args) {
        int n1 = 423;
        int n2 = 295;
        int k = 7;
        System.out.println(setValueToZero(n1, k));
        System.out.println(setValueToOne(n2, k));

    }
}
