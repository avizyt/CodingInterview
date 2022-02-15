package com.topics.arrayAndString;

public class MinHeap {
    int data;
    int heapIdx;
    int currentIdx;

    public MinHeap (int data, int heapIdx, int currentIdx) {
        this.data = data;
        this.heapIdx = heapIdx;
        this.currentIdx = currentIdx;
    }

    @Override
    public String toString() {
        return data+"";
    }
}
