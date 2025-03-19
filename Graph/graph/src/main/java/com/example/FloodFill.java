package com.example;

import java.util.Arrays;

public class FloodFill {
    
    public static void dfs(int iniColor, int[][] answer, int sr, int sc, int newColor, int[] delRow, int[] delCol, int[][] image){

        answer[sr][sc] = newColor;
        int n = image.length;
        int m = image[0].length;

        for(int i=0; i < 4; i++){
            int newRow = sr + delRow[i];
            int newCol = sc + delCol[i];

            if (newRow < n && newRow>=0 && newCol < m && newCol >=0 
            && answer[newRow][newCol] != newColor && image[newRow][newCol] == iniColor) {
                dfs(iniColor, answer, newRow, newCol, newColor, delRow, delCol, image);
            }

        }


    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor){

        int iniColor = image[sr][sc];

        int n = image.length;
        int m = image[0].length;
        int[][] answer = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                answer[i][j] = image[i][j];
            }
        }

        int[] delRow = {0,-1,0,1};
        int[] delCol = {-1,0,1,0};

        dfs(iniColor, answer, sr, sc, newColor, delRow, delCol, image);
        return answer;
    }


    public static void main(String[] args) {
        

        int[][] image = {
            {1, 1, 1, 2, 2},
            {1, 1, 0, 2, 2},
            {1, 0, 0, 2, 2},
            {3, 3, 0, 2, 2},
            {3, 3, 3, 3, 3}
        };

        // Start filling from (1, 2) with new color 9
        int sr = 1, sc = 2, newColor = 9;

        // Apply flood fill
        int[][] result = floodFill(image, sr, sc, newColor);

        // Print the modified image
        System.out.println("Modified Image:");
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }



    }


}
