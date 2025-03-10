package com.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        int n = 5; //Number of nodes
        int adjMatrix[][] = new int[n+1][n+1];

        int edges[][] = {
            {1, 2},
            {1, 3},
            {2, 4},
            {2, 5},
            {3, 4},
            {4, 5}
        };

        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            adjMatrix[u][v] = 1;
            adjMatrix[v][u] = 1; //Graph is undirected

        }


        // Print the matrix
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }


    }
}