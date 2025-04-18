package com.example;

import java.util.*;

public class RatMaze {
    

    public static void generatePath(int row, int col, int[][] maze,int[][] checkedArr, int n, List<Character> ds, List<List<Character>> answer){

        if (row == n-1 && col == n-1) {
            answer.add(new ArrayList<>(ds));
            return;
        }

        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};
        char[] dirChar = {'R', 'D', 'L', 'U'};

        for(int i =0; i< 4; i++){
            int newRow = row + dx[i];
            int newCol = col + dy[i];

            if (newRow>=0 && newRow < n && newCol>=0 && newCol<n 
            && maze[newRow][newCol] == 1 && checkedArr[newRow][newCol] == 0 ) {
                
                ds.add(dirChar[i]);
                checkedArr[newRow][newCol] = 1;

                // Recursion
                generatePath(newRow, newCol, maze, checkedArr, n, ds, answer);

                // Backtrack
                ds.remove(ds.size()-1);
                checkedArr[newRow][newCol] = 0;

            }


        }

    }

    public static List<List<Character>> findPath(int[][] maze, int n){
        List<List<Character>> answer = new ArrayList<>();
        int[][] checkedArr = new int[n][n];
        checkedArr[0][0] = 1;
        generatePath(0, 0, maze, checkedArr, n, new ArrayList<>(), answer);

        return answer;

    }

    public static void main(String[] args) {
        int[][] maze = {
            {1, 0, 0, 0},
            {1, 1, 1, 1},
            {0, 1, 0, 1},
            {1, 1, 1, 1}
        };
        int n = 4;        
    
        System.out.println(findPath(maze, n));
    }


}
