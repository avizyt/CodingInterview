package com.topics.stackAndQueue;

import java.util.Stack;

public class StockSpans {
    public static void main(String[] args) {
        int[] stockPrices = {55, 34, 22, 23, 27, 88, 70, 42, 51, 100};
        int[] span = stockSpan(stockPrices);
        System.out.printf(String.valueOf(span));
    }
    public static int[] stockSpan(int[] stockPrices){
        Stack<Integer> daysStack = new Stack<>();
        int[] spanRes = new int[stockPrices.length];

        spanRes[0] = 1;
        daysStack.push(0);

        for (int i = 0; i < stockPrices.length; i++) {
            // pop until we find a price on stack which is
            // greater than the current day's price or there
            // are no more days left
            while (!daysStack.empty()
                    && stockPrices[i] > stockPrices[daysStack.peek()]) {
                            daysStack.pop();
            }

            // if there is no price greater than the current
            // day's price then the stock span is the numbers of days
            if (daysStack.empty()){
                spanRes[i] = i + 1;
            } else {
                // if there is a price greater than the current
                // day's price than the stock span is the
                // difference between the current day and that
                spanRes[i] = i - daysStack.peek();
            }

            // push current day onto top of stack
            daysStack.push(i);
        }
        return spanRes;
    }
}
