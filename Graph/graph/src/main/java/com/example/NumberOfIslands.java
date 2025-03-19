package com.example;

import java.util.*;

public class NumberOfIslands {
  
    public static class Pairs{
        int first;
        int second;
        public Pairs(int first, int second){
            this.first = first;
            this.second = second;
        }
    }

    public static void bfs(char[][] grid, int row, int col, boolean visArr[][]){

        visArr[row][col] = true;

        int n = grid.length;
        int m = grid[0].length;
        Queue<Pairs> queue = new LinkedList<>();
        queue.add(new Pairs(row, col));

        while (!queue.isEmpty()) {
            Pairs dummy = queue.poll();
            int first = dummy.first;
            int second = dummy.second;

            for(int delRow = -1; delRow <=1; delRow++){
                for(int delCol = -1; delCol <=1; delCol++){
                    int nrow = first + delRow;
                    int ncol = second + delCol;

                    if (nrow>=0 && ncol >= 0 && nrow < n && ncol < m && 
                    grid[nrow][ncol] == '1' && !visArr[nrow][ncol]) {
                        visArr[nrow][ncol] = true;
                        queue.add(new Pairs(nrow, ncol));
                    }
                }
            }


        }

    }


    public static int numberOfIsland(char[][] grid){

        int count = 0;
        int n = grid.length;
        int m = grid[0].length;
        boolean visArr[][] = new boolean[n][m]; 
        
        for(int row =0; row < n; row++){
            for(int col=0; col < m; col++){
                if (!visArr[row][col] && grid[row][col] == '1') {
                    count++;
                    bfs(grid, row, col, visArr);
                }
            }
        }

        return count;

    }


    public static void main(String[] args) {
        
        char[][] grid = {
            {'0', '1', '1', '0'},
            {'0', '1', '1', '0'},
            {'0', '0', '1', '0'},
            {'0', '0', '0', '0'},
            {'1', '1', '0', '1'}
        };

        System.out.println(numberOfIsland(grid));

    }


}
