package com.topics.TreeAndGraph;

import java.util.ArrayDeque;
import java.util.Queue;

public class Node<T> {
    private final Node left;
    private final Node right;

    private final T element;

    public Node(T element) {
        this.element = element;
        this.left = null;
        this.right = null;
    }

    public Node(Node left, Node right, T element) {
        this.left = left;
        this.right = right;
        this.element = element;
    }

    // BFS or level-order traversal
    private void printLevelOrder(Node node){
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            // step 1
            Node cur = queue.poll();

            //step 2
            System.out.println(" " + cur.element);

            //step 3
            if (cur.left != null){
                queue.add(cur.left);
            }

            // step 4
            if (cur.right != null){
                queue.add(cur.right);
            }
        }
    }

    // DFS has three variation Pre-order, In-order, and Post-order
    // Pre Order : Visit the current node before its child nodes.
    private void printPreOrder(Node node){
        if (node != null){
            System.out.println(" "+ node.element);
            printLevelOrder(node.left);
        }
    }

    //In Order: visit the left branch, then current node, the right branch
    private void printInOrder(Node node){
        if (node != null){
            printPreOrder(node.left);
            System.out.println(" " + node.element);
            printPreOrder(node.right);
        }
    }

    // Post Order: visit current node after its child nodes
    private void printPostOrder(Node node){
        if (node != null){
            printPostOrder(node.left);
            printPostOrder(node.right);
            System.out.println(" " + node.element);
        }
    }

}
