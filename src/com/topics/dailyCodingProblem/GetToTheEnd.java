package com.topics.dailyCodingProblem;


/**
You are given an array of non-negative integers. Let's say you start at the
beginning of the array and are trying to advance to the end. You can advance
at most, the number of steps that you're currently on. Determine whether you
can get to the end of the array.

 E.g 1
 input: [1, 3, 1, 2, 0, 1]
 process: 0 -> 1 -> 3 -> 5
 output: true

 E.g 2
 input: [1, 2, 1, 0, 0]
 process: 1 -> 2 -> 0
 output: false

**/


public class GetToTheEnd {
    public static void main(String[] args) {
        int[] arr = {1,3,1,2,0,5};
        int[] arr1 = {1,2,1,0,0};
        int[] arr2 = {0, 2, 3};
        int[] arr3 = {1, 2, 0};
        int[] arr4 = {3,0,2,3,1,2,1,3,3,2,1,2,1,0,0,4,0,2,0,3};
        Boolean ans = isToTheEnd(arr);
        System.out.println(ans);
    }

    public static boolean isToTheEnd(int[] arr) {
        int step = 0;
        int lastVal = 0;
        int len = arr.length -1;
        for (int j = 0; j <= arr.length; j++) {
            int temp = arr[step];
            step = temp;
            lastVal = temp;
        }
        if (lastVal == arr[len]){
            return true;
        }
        return false;
    }
}
