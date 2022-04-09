package com.topics.stackAndQueue;

import java.util.Stack;

public class MaxHistogramArea {
    public static void main(String[] args) {
        int[] hist = {4, 2, 8, 6, 5, 3};
        int maxArea = maxAreaUsingStack(hist);
        System.out.println(maxArea);

    }
    public static int maxAreaUsingStack(int[] histogram){
        Stack<Integer> stack = new Stack<>();

        int maxArea = 0;
        for (int bar = 0; bar <= histogram.length; bar++) {

            int barHeight;
            if (bar == histogram.length){
                barHeight = 0;
            } else {
                barHeight = histogram[bar];
            }

            while (!stack.empty() && barHeight < histogram[stack.peek()]) {
                int top = stack.pop();

                int left = stack.isEmpty() ? -1 : stack.peek();

                int areaRectWidth = bar - left -1;

                int area = areaRectWidth * histogram[top];
                maxArea = Integer.max(area, maxArea);
            }

            stack.push(bar);

        }

        return maxArea;
    }



}
