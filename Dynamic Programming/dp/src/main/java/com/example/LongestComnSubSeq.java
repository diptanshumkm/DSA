package com.example;

import java.util.Arrays;

public class LongestComnSubSeq {


    public static int longCmnSubSeq(int i, int j, String s1, String s2, int[][] dp){

        // Base case 
        if (i < 0 || j < 0) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // If equal
        if (s1.charAt(i) == s2.charAt(j)) {
            return 1 + longCmnSubSeq(i-1, j-1, s1, s2, dp);
        }

        // If not equal
        return dp[i][j] = Math.max(longCmnSubSeq(i-1, j, s1, s2, dp), longCmnSubSeq(i, j-1, s1, s2, dp));
    }

    public static void main(String[] args) {
        String s1 = "acdee";
        String s2 = "cedee";

        int i = s1.length() - 1;
        int j = s2.length() - 1;

        int[][] dp = new int[s1.length()][s2.length()];
        for(int x =0; x<=i; x++){
            for(int z=0; z<=j; z++){
                dp[x][z] = -1;
            }
        }

        System.out.println(longCmnSubSeq(i, j, s1, s2, dp));
    }
    
}
