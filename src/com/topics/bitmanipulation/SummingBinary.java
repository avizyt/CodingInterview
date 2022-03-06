package com.topics.bitmanipulation;

public class SummingBinary {
    public int sum(int q, int p){
        int xor;
        int and;
        int t;

        and = q & p;
        xor = q ^ p;

        // force 'and' to return 0
        while (and != 0){
            and = and << 1;

            t = xor ^ and;
            and = and & xor;
            xor = t;
        }
        return  xor;
    }

    public static void main(String[] args) {
        int x = 23;
        int y = 45;
        SummingBinary s = new SummingBinary();
        System.out.println(x + " --> " +Integer.toBinaryString(x));
        System.out.println(y + " --> " +Integer.toBinaryString(y));
        System.out.println("------------------");
        int sumXY = s.sum(x, y);
        System.out.println(sumXY + " --> "+Integer.toBinaryString(sumXY));
    }
}
