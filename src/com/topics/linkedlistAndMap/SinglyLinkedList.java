package com.topics.linkedlistAndMap;

import java.util.HashSet;
import java.util.Set;

public final class SinglyLinkedList {

    public final class Node {

        private int data;
        private Node next;

        @Override
        public String toString() {
            return " " + data + " ";
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public void insertFirst(int data){
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = head;
        head = newNode;
        if (tail == null){
            tail = newNode;
        }
        size++;
    }
    // O(n) solution (time and space)
    public  void removeDuplicate() {
        Set<Integer> dataset = new HashSet<>();

        Node curNode = head;
        Node preNode = null;
        while (curNode != null){
            if (dataset.contains(curNode.data)){
                preNode.next = curNode.next;
                if (curNode == tail){
                    tail = preNode;
                }

                size--;
            } else {
                dataset.add(curNode.data);
                preNode = curNode;
            }
            curNode = curNode.next;
        }
    }

    public void print() {

        System.out.println("\nHead (" + head + ") ----------> Last (" + tail + "):");

        Node currentNode = head;
        while (currentNode != null) {

            System.out.print(currentNode);
            currentNode = currentNode.next;
        }

        System.out.println();
    }

    private int size() {
        return size;
    }

    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        
        sll.insertFirst(5);
        sll.insertFirst(2);
        sll.insertFirst(12);
        sll.insertFirst(2);
        sll.insertFirst(12);
        sll.insertFirst(5);
        sll.insertFirst(5);
        sll.insertFirst(12);
        sll.insertFirst(1);
        sll.insertFirst(4);
        sll.insertFirst(12);

        System.out.println("\nLinked list before removing duplicates:");
        sll.print();
        sll.removeDuplicate();
        // sll.removeDuplicates2();
        System.out.println("\nLinked list after removing duplicates:");
        sll.print();

        System.out.println("\nSize: " + sll.size());
    }


}
