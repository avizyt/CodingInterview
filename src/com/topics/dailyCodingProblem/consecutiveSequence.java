package com.topics.dailyCodingProblem;

import java.util.ArrayList;
import java.util.HashSet;

/** Microsoft
 * Given an unsorted array of integers, find the length of the longest
 * consecutive elements sequence.
 * Input : [100, 4, 200, 1, 3, 2]
 * process : [1,2,3,4]
 * Output : 4 or length of process
 */

public class consecutiveSequence {
    public static void main(String[] args) {
        int[] arr = {100, 4, 200, 1, 3, 2};
        int ans = longestSeq(arr);
        System.out.println(ans);
    }

    public static int longestSeq(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        int seq = 0;
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }

        for (int j = 0; j < arr.length; j++) {
            if (!set.contains(arr[j] - 1)){
                int x = arr[j];
                while (set.contains(x))
                    x++;

                if (seq < x - arr[j])
                    seq = x - arr[j];
            }
        }
        return seq;
    }
}
