package com.example;


public class FrogJump {

    public static int minEnergy(int index, int[] arr, int[] dp){
        if (index == 0) {
            return 0;
        }
   
        if (dp[index] != -1) {return dp[index];}
     
        int left = minEnergy(index-1, arr, dp) + Math.abs(arr[index] - arr[index-1]);
        int right = Integer.MAX_VALUE;
        if (index > 1) {
            right = minEnergy(index-2, arr, dp) + Math.abs(arr[index] - arr[index-2]);
        }
     
        return dp[index] = Math.min(left, right);
    }

    public static int frogJumpMemoization(int[] arr, int n){
        int answer;
        int[] dp = new int[n];
        
        for(int i=0; i< dp.length; i++){
            dp[i] = -1;
        }

        answer = minEnergy(n-1, arr, dp);
        return answer;
    }


    public static int frogJumpTabulation(int[] arr, int n){

        int[] dp = new int[n];
        dp[0] = 0; //Base case

        for(int i = 1; i < n; i++){

            int left = dp[i-1] + Math.abs(arr[i] - arr[i-1]);

            int right = Integer.MAX_VALUE;
            if(i > 1){
                right = dp[i-2] + Math.abs(arr[i] - arr[i-2]);
            }

            dp[i] = Math.min(left, right);
        }

        return dp[n-1];
    }
   

    public static int frogJumpTabulationOptzd(int[] arr, int n){
        if (n==1) {return 0;}
        int prev2 = 0;
        int prev1 = Math.abs(arr[1] - arr[0]);

        for(int i = 2; i < n; i++){

            int left = prev1 + Math.abs(arr[i] - arr[i-1]);

            int right = Integer.MAX_VALUE;
            if (i>1) {
                right = prev2 + Math.abs(arr[i] - arr[i-2]);
            }
            int current = Math.min(left, right);
            
            prev2 = prev1;
            prev1 = current;
            
        }

        return prev1;
        
    }
   
    public static void main(String[] args) {
        
        int [] arr = {10,20, 30, 10};
        int n = arr.length;
        System.out.println(frogJumpTabulationOptzd(arr, n));

    }

}
