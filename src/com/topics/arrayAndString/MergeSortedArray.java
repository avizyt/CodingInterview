package com.topics.arrayAndString;

import java.util.Arrays;

public class MergeSortedArray{
    public static void main(String[] args) {

        int[][] arrs = {
                {1, 2, 32, 46},
                {-4, 5, 15, 18, 20},
                {3},
                {6, 8},
                {-2, -1, 0}
        };

        int[] result = MergeSortedArray.merge(arrs, arrs.length);
        System.out.println(Arrays.toString(result));
    }

    public static int[] merge(int[][] arrs, int k) {
        // compute the total length of the resulting array
        int len = 0;
        for (int i = 0; i < arrs.length; i++) {
            len += arrs[i].length;
        }
        // create the result array
        int[] result = new int[len];

        // create the min heap
        MinHeap[] heap = new MinHeap[k];

        // add in the heap first element form each array
        for (int i = 0; i < k; i++) {
            heap[i] = new MinHeap(arrs[i][0], i, 0);
        }

        // perform merging
        for (int i = 0; i < result.length; i++) {
            heapify(heap, 0, k);


            // add an element in the final result
            result[i] = heap[0].data;

            heap[0].currentIdx++;
            int[] subarray = arrs[heap[0].heapIdx];
            if (heap[0].currentIdx >= subarray.length){
                heap[0].data = Integer.MAX_VALUE;
            }
            else {
                heap[0].data = subarray[heap[0].currentIdx];
            }
        }
        return result;
    }

    // remove the minimum element from the heap, O(log n)
    private static void heapify(MinHeap[] heap, int root, int len) {
        int smallest = root;
        int leftIdx = left(root);
        int rightIdx = right(root);

        if (leftIdx < len && heap[smallest].data > heap[leftIdx].data) {
            smallest = leftIdx;
        }

        if (rightIdx < len && heap[smallest].data > heap[rightIdx].data){
            smallest = rightIdx;
        }

        // swap smallest with root
        if (smallest != root) {
            swap(heap, smallest, root);
            heapify(heap, smallest, len);
        }
    }

    private static void swap(MinHeap[] heap, int i, int j){
        MinHeap aux = heap[i];
        heap[i] = heap[j];
        heap[j] = aux;
    }

    // to get index of left child of node at index i
    private static int left(int i){
        return (2 * i + 1);
    }

    // to get index of right child of node at index i
    private static int right(int j){
        return (2 * j + 2);
    }
}
