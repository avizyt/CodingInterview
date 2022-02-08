package com.topics.recursion;

public class TowerOfHanoi {
    public static void main(String[] args) {
        int n = 3;
        TowerOfHanoi.moveDisk(3,'A','B', 'C');

    }

    public static void  moveDisk(int n, char origin, char target, char middle) {

        int count = 0;
        if (n <= 0){
            return;
        }

        if (n == 1){
            System.out.println("move disk 1 from rod "+origin+ " to rod "+ target);
            return;
        }

        // move top n-1 disks from origin to middle.
        // using target as a middle
        moveDisk(n-1, origin, middle, target);
        System.out.println("Move disk "+ n + " from rod "+ origin +" to rod "+ target);
        count++;

        // move top n-1 disks from middle
        // using origin as a middle
        moveDisk(n-1, middle, target, origin);
    }
}
