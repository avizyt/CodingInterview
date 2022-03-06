package com.topics.recursion;


import java.awt.*;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * A robot is placed at the top-left corner of this grid of m * n
 * The robot can only move either right or down at any point in time,
 * but it is not allowed to move in certain cells. The robot's goal is
 * to find a path from the top-left corner to the bottom-right corner of the grid.
 */
public class RobotGrid {

    public static void main(String[] args) {

        // we define the maze
        boolean[][] maze = new boolean[6][6];
        maze[2][0]=true;
        maze[3][0]=true;
        maze[3][1]=true;
        maze[3][2]=true;
        maze[3][3]=true;

        // storing the plain recursion path in LinkedHashSet
        Set<Point> path = new LinkedHashSet<>();
        RobotGrid.robotPath(5,5,maze, path);
        System.out.println("=====Path in Plain Recursion=====");
        path.forEach(System.out::println);

        System.out.println("=====================================");
        // string the visited point of memo recursion in HashSet
        Set<Point> visited = new HashSet<>();

        RobotGrid.robotPathMemo(5,5, maze, path, visited);
        System.out.println("=====Path for Memo Recursive robot path=====");
        path.forEach(System.out::println);

    }

    private RobotGrid() {
        throw new AssertionError("Cannot be instantiated");
    }

    // path finding algorithm using plain recursion
    public static boolean robotPath(int row, int col, boolean[][] maze, Set<Point> path){
        // when row and col value out of the maze board
        if (row <0 || col < 0){
            return false;
        }

        // blocked cell so robot can not move there
        if (maze[row][col]) {
            return false;
        }

        // when we reached our target means (0,0) point on the maze
        if ( ((row == 0) && (col ==0))
        // or, try to go to the right
                || robotPath(row, col-1, maze, path)
        // or try to go to down
                || robotPath(row -1, col, maze, path)
        ){
            // adding the cell to the path
            path.add(new Point(row, col));
            return true;
        }
        return false;
    }

    // Path finding algorithm using Dynamic Programming called Memoization
    public static boolean robotPathMemo(
            int row, int col,
            boolean[][] maze,
            Set<Point> path,
            Set<Point> visit
    ){
        if (path == null || maze == null || visit == null){
            throw new IllegalArgumentException("Path, maze and Visit cannot be null");
        }

        if (row <0 || col < 0){
            return false;
        }
        if (maze[row][col]) {
            return false;
        }

        // creating cell value as point in grid
        Point cell = new Point(row, col);

        // check if we've already visited this cell or not
        if (visit.contains(cell)){
            return false;
        }
        if (((row == 0) && (col == 0) // at the  (0, 0) point
            || robotPathMemo(row, col-1, maze, path, visit) // for right
            || robotPathMemo(row-1, col, maze, path, visit) // for down
        )) {
            path.add(cell);
            return true;
        }
        visit.add(cell);
        return false;
    }
}
