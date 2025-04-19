package com.example;

public class MColoring {
    

    public static boolean isPossible(int node, boolean[][] graph, int[] color, int col, int v){
        
        for(int i=0; i<v; i++){
            if (graph[node][i] == true) {
                int checkForNode = i;
                if (color[checkForNode] == col) {
                    return false;
                }
            }
        }
        return true;

    }


    public static boolean solve(int node, int[] color, int v, int m, boolean[][] graph){
        if (node == v) {
            return true;
        }

        for(int i = 1; i <= m; i++){

            if (isPossible(node, graph, color, i, v)) {
                color[node] = i;

                if(solve(node+1, color, v, m, graph) == true) {return true;}
                
                // Backtrack
                color[node] = 0;
            }

        }
        return false;

    }
    
    public static void main(String[] args) {
        // int v = 4;
        // int[][] edges = {
        //     {0, 1},
        //     {1, 2},
        //     {2, 3},
        //     {3, 0},
        //     {0, 2}
        // };
        // int m = 3;

        int v = 4;
        int[][] edges = {
            {0, 1},
            {1, 2},
            {2, 3},
            {3, 0},
            {0, 2}
        };
        int m = 2;

        boolean[][] graph = new boolean[v][v];

        for(int[] edge: edges){
            int x = edge[0];
            int y = edge[1];
            graph[x][y] = true;
            graph[y][x] = true;
        }
        int[] color = new int[v];
        boolean result = solve(0, color, v, m, graph);
        System.out.println(result);

    }

}
