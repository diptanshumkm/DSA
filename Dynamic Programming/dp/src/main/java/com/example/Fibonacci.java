package com.example;

public class Fibonacci {

    // public static int calculateFibonacci(int n, int[] dp){
    //     if (n<=1) {
    //         return n;
    //     }

    //     if (dp[n] != -1) {
    //         return dp[n];    
    //     }

    //     return dp[n] = calculateFibonacci(n-1, dp) + calculateFibonacci(n-2, dp);
    // }


    public static int calculateFibonacciTabulation(int n){

        if (n == 0) {return 0;}
        if (n == 1) {return 1;}

        int prev2 = 0;
        int prev1 = 1;

        for(int i =2; i<=n; i++){
            int current = prev1+prev2;
            prev2 = prev1;
            prev1 = current;

        }
        return prev1;
    }

    public static int fibonacci(int n){
        // int[] dp = new int[n+1];

        // for(int i=0; i<dp.length; i++){
        //     dp[i] = -1;
        // }

        // int result = calculateFibonacci(n, dp);

        int result1 = calculateFibonacciTabulation(n);

        return result1;

    }

    public static void main(String[] args) {
        
        System.out.println(fibonacci(8));

    }

}
