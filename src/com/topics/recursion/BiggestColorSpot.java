package com.topics.recursion;

import java.util.Random;

public class BiggestColorSpot {
    private static int currentColorSpot;

    void determineBiggestColorSpot(int rows, int cols, int[][] a){
        if (a == null){
            throw new IllegalArgumentException("The board cannot be null!!");
        }
        if (rows <= 0 || cols <= 0){
            throw new IllegalArgumentException("Grid can't have 0 row and 0 cols!!");
        }

        int biggestColorSpot = 0;
        int color = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (a[i][j] > 0){
                    currentColorSpot =0;

                    computeColorSpot(i, j, rows, cols, a , a[i][j]);
                    if ( currentColorSpot > biggestColorSpot){
                        biggestColorSpot = currentColorSpot;
                        color = a[i][j] * (-1);
                    }
                }
            }
        }
        System.out.println("\nColor: " + color + " Biggest spot: " + biggestColorSpot);
    }

    private void computeColorSpot(int i, int j, int rows, int cols, int[][] a, int color) {
        a[i][j] = -a[i][j];
        currentColorSpot++;

        if (i > 1 && a[i-1][j] == color){
            computeColorSpot(i-1,j,rows,cols,a,color);
        }

        if ((i+1) < rows && a[i+1][j] == color){
            computeColorSpot(i+1,j,rows,cols,a,color);
        }

        if (j > 1 && a[i][j-1] == color){
            computeColorSpot(i,j-1,rows,cols,a,color);
        }

        if ((j+1) < cols && a[i][j+1] == color){
            computeColorSpot(i,j+1,rows,cols,a,color);
        }
    }

    public static void main(String[] args) {
        int cols = 5;
        int rows = 5;
        int colors = 3;

        Random rnd = new Random();

        int[][] a = new int[rows][cols];

        // add random colors
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                a[i][j] = 1+ rnd.nextInt(colors);
            }
        }
        // show the surface on screen
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf(a[i][j] + " ");
            }
            System.out.println();
        }
        BiggestColorSpot spots = new BiggestColorSpot();
        spots.determineBiggestColorSpot(rows, cols, a);
    }


}
