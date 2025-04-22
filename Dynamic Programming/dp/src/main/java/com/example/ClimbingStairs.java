package com.example;

public class ClimbingStairs {

    
    // Memoization
    public static int calculateSol(int index, int [] dp){
        if (index == 0) {
            return 1;
        }
        if (index == 1) {
            return 1;
        }   

        if (dp[index] != -1) {return dp[index];}

        int left = calculateSol(index-1, dp);
        int right = calculateSol(index-2, dp);
        return dp[index] = left+right;

    }
    
    public static int climbingStairs(int n){
        int answer;
        int [] dp = new int[n+1];
        for(int i=0; i<dp.length; i++){
            dp[i] = -1;
        }

        answer = calculateSol(n-1,dp);
        
        return answer;
    }


    public static void main(String[] args) {
        int n=20;
        System.out.println(climbingStairs(n));
    }
}
