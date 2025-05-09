package com.example;

public class Knapsack {
   
    public static int solve(int index, int wt, int[] weight, int[] value, int[][] dp ){
        //Base case
        if(index < 0 || wt == 0){return 0;}

        if (dp[index][wt] != -1) {
            return dp[index][wt];
        }
        //Take
        int pick = Integer.MIN_VALUE;
        if (weight[index] <= wt) {
            pick = value[index] + solve(index-1, wt-weight[index], weight, value, dp);
        }
        //Not take
        int not_pick = solve(index-1, wt, weight, value, dp);

        return dp[index][wt] = Math.max(pick, not_pick);
    }
    
    public static int solveMemoization(int n, int bag_wt, int[] weight, int[] value){

        int[][] dp = new int[n][bag_wt+1];
        
        for(int i=0; i <n; i++){
            for(int j = 0; j <= bag_wt; j++){
                dp[i][j] = -1;
            }
        }

        return solve(n-1, bag_wt, weight, value, dp);
    }

    public static int solveTabulation(int n, int bag_wt, int[] weight, int[] value){
        int[][] dp = new int[n+1][bag_wt+1];

        for(int j = 0; j<=bag_wt; j++){
            dp[0][j] = 0;
        }
        for(int i = 0; i<=n; i++){
            dp[i][0] = 0;
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=bag_wt; j++){
                //Take
                int pick = Integer.MIN_VALUE;
                if (weight[i-1] <= j) {
                    pick = value[i-1] + dp[i-1][j-weight[i-1]];
                }
                //Not take
                int not_pick = dp[i-1][j];

               dp[i][j] = Math.max(pick, not_pick);
            }
        }

        return dp[n][bag_wt];
    }
    public static void main(String[] args) {

        int[] weight = {1,2,4,5};
        int[] value = {5,4,8,6};
        int bag_wt = 5;
        int n = value.length;

        System.out.println(solveMemoization(n, bag_wt, weight, value));
        System.out.println(solveTabulation(n, bag_wt, weight, value));
    }
}