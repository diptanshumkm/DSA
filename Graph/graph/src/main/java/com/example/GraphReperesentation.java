package com.example;

import java.util.ArrayList;

public class GraphReperesentation {
    
    public static void MatrixRepresentation(){
        
    }


    public static void main(String[] args) {
// --------------------------------------------------------ADJACENT MATRIX REPRESENTATION O(n^2)---------------------------------------------------
        // int n = 5; //Number of nodes
        // int adjMatrix[][] = new int[n+1][n+1];

        // int edges[][] = {
        //     {1, 2},
        //     {1, 3},
        //     {2, 4},
        //     {2, 5},
        //     {3, 4},
        //     {4, 5}
        // };

        // for(int[] edge: edges){
        //     int u = edge[0];
        //     int v = edge[1];
        //     adjMatrix[u][v] = 1;
        //     adjMatrix[v][u] = 1; //Graph is undirected

        // }


        // // Print the matrix
        // for(int i=1; i<=n; i++){
        //     for(int j=1; j<=n; j++){
        //         System.out.print(adjMatrix[i][j] + " ");
        //     }
        //     System.out.println();
        // }

// -----------------------------------------------------------ADJACENT LIST REPRESENTATION O(2m)-----------------------------------------------------

        int n =5;
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for(int i=0; i<=n;i++){
            adjList.add(new ArrayList<>());
        }

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

            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        System.out.println("Adjacency List Representation:");
        for (int i = 1; i <= n; i++) { // Start from 1 to maintain 1-based indexing
            System.out.print(i + " → " + adjList.get(i));
            System.out.println();
        }





    }

}
