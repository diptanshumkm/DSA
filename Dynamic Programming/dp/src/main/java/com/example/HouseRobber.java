package com.example;

import java.util.Arrays;

public class HouseRobber {

    // public static int solve(int i, int sum, int[] arr, int n){

    //     if (i >= n) {
    //         return sum;
    //     }

    //     // pick
    //     int left = solve(i+2, sum+arr[i], arr, n);

    //     // not pick
    //     int right = solve(i+1, sum, arr, n);
        	
    //     return Math.max(left, right);
    // }



    public static int maxAdjSum(int[] arr, int index, int dp[]){
        if (index == 0) {
            return arr[0];
        }
        if (index < 0) {
            return 0;
        }
        
        if (dp[index] != -1) {return dp[index];}

        int pick = arr[index] + maxAdjSum(arr, index-2,dp);
        int not_pick = maxAdjSum(arr, index-1, dp);
        
        return dp[index] = Math.max(pick, not_pick);
    }

    public static int maxAdjSumTabulation(int[] arr){
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        dp[0] = arr[0];
        for(int i = 1; i<n;i++){
            int pick = arr[i];
            if (i>1) {
                pick = pick += dp[i-2];
            }
            int not_pick = dp[i-1];
            dp[i] = Math.max(pick, not_pick);
        }

        return dp[n-1];
    }

    public static int maxAdjSumSpaceOptmz(int[] arr){
        int n = arr.length;
        int prev2 = 0;
        int prev = arr[0];

        for(int i= 1; i<n; i++){
            int pick = arr[i];
            if (i>1) {
                pick = pick += prev2;
            }
            int not_pick = prev;
            int current = Math.max(pick, not_pick);
            
            prev2 = prev;
            prev = current;    
        }

        return prev;

    }


    public static void main(String[] args) {
        int arr [] = {2,1,4,9};
        int n = arr.length;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);

        System.out.println(maxAdjSum(arr, n-1, dp));
        System.out.println(maxAdjSumTabulation(arr));
        System.out.println(maxAdjSumSpaceOptmz(arr));
    }

}
