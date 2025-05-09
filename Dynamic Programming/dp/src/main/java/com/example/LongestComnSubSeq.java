package com.example;


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
            return dp[i][j] = 1 + longCmnSubSeq(i-1, j-1, s1, s2, dp);
        }

        // If not equal
        return dp[i][j] = Math.max(longCmnSubSeq(i-1, j, s1, s2, dp), longCmnSubSeq(i, j-1, s1, s2, dp));
    
    }


    public static int longCmnSubSeqTabulation(String s1, String s2){

        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n+1][m+1];

        for(int i=1; i<=n; i++ ){
            for(int j=1; j<= m; j++){

                // If equal
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    // If not equal
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }

            }
        }
        // The below line prints LCS
        System.out.println(printLcs(dp, s1, s2));
        return dp[n][m];

    }

    public static StringBuilder printLcs(int[][] dp, String s1, String s2){

        int n = s1.length();
        int m = s2.length();
        StringBuilder answer = new StringBuilder();

        int i = n;
        int j = m;

        while (i > 0 && j > 0) {
            if (s1.charAt(i-1) == s2.charAt(j-1)) {
                answer.append(s1.charAt(i-1));
                i--;
                j--;

            }else if (dp[i-1][j] > dp[i][j-1]) {
                i--;
            }else{
                j--;
            }
        }
        
        return answer.reverse();
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

        System.out.println(longCmnSubSeqTabulation(s1, s2));

    }
    
}
