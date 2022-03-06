//package com.topics.TreeAndGraph;
//
//import java.lang.reflect.Array;
//import java.util.Arrays;
//
//public class MaxHeap<T extends Comparable<T>> {
//    private static final int DEFAULT_CAPACITY = 5;
//
//    private int capacity;
//    private int size;
//    private T[] heap;
//
//    public MaxHeap() {
//        capacity = DEFAULT_CAPACITY;
//        this.heap = (T[]) Array.newInstance(
//                Comparable[].class.getComponentType(), DEFAULT_CAPACITY);
//    }
//
//    // adding is done is O(log n) time
//    public void add(T element){
//        ensureCapacity();
//        heap[size] = element;
//        size++;
//
//        heapifyUp();
//    }
//
//    private void ensureCapacity() {
//        if (size == capacity){
//            heap = Arrays.copyOf(heap, capacity * 2);
//            capacity = capacity * 2;
//        }
//    }
//    // heapifyUp()
//    private void heapifyUp() {
//        int index = size - 1;
//
//        while (hasParent(index) && parent(index).compareTo(heap[index]) < 0) {
//            swap(getParentIndex(index), index);
//            index = getParentIndex(index);
//        }
//    }
//}
