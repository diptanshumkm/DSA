package com.example;

import java.util.Arrays;

public class FrogKJumps {

    public static int minEnergy(int index, int[] arr, int n, int k, int[] dp){
        if (index == 0) {
            return 0;
        }
        if (dp[index]!=-1) {
            return dp[index];
        }

        int minEnergy = Integer.MAX_VALUE;

        for(int j = 1; j <= k; j++){
            if (index - j >= 0 ) {
                int cost = minEnergy(index - j, arr, n, k, dp) + Math.abs(arr[index] - arr[index-j]);
                minEnergy = Math.min(minEnergy, cost);
            }
        }
        
        return dp[index] = minEnergy;
    }

    public static int frogKjumpMemoization(int[] arr, int n, int k){
        int answer;
        int[] dp = new int[n+1];
         
        Arrays.fill(dp, -1);

        answer = minEnergy(n-1, arr, n, k, dp);
        return answer; 

    }


    public static int frogKJumpsTabulation(int [] arr, int n, int k){
        int[] dp = new int[n];

        dp[0] = 0;
        for(int i = 1; i<n; i++){
            
            int minEnergy = Integer.MAX_VALUE;
            for(int j = 1; j <= k; j++){
                if (i-j >= 0) {
                    int cost = dp[i-j] + Math.abs(arr[i] - arr[i-j]);
                    minEnergy = Math.min(minEnergy, cost);
                }
            }
            dp[i] = minEnergy;
        }

        return dp[n-1];
    }
    public static void main(String[] args) {
        int [] arr = {10,20, 30, 10};
        int n = arr.length;
        int k = 2;

        System.out.println(frogKJumpsTabulation(arr, n, k));
    }    
}
