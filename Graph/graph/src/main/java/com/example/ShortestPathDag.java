package com.example;
import java.util.*;

public class ShortestPathDag {
    
    static class Pair {
        int first;
        int second;
        public Pair(int x, int y){
            this.first = x;
            this.second = y;
        }
        
    }

    static void dfs(ArrayList<ArrayList<Pair>> adjList, Stack<Integer> stack, int[] visArr, int node ){
        visArr[node] = 1;
        for(Pair i : adjList.get(node)){
            if (visArr[i.first] == 0 ) {
                dfs(adjList, stack, visArr, i.first);
            }
        }
        stack.add(node);
    }

    static Stack<Integer> topoSort(ArrayList<ArrayList<Pair>> adjList, int totalNode){
    
        Stack<Integer> stack = new Stack<>();
        int[] visArr = new int[totalNode];

        for(int i = 0; i < totalNode; i++){
            if (visArr[i]==0) {
                dfs(adjList, stack, visArr, i);
            }
        }

        return stack;
    }

    static void relaxEdgesInTopoOrder(Stack<Integer> stack, int[] distance, ArrayList<ArrayList<Pair>> adjList){

        while (!stack.isEmpty()) {
            int node = stack.pop();

            for(Pair i: adjList.get(node)){
                int tempDistance = distance[node] + i.second;
                if (distance[i.first] > tempDistance) {
                    distance[i.first] = tempDistance;
                }
            }
        }

        
    }

    public static int[] shortestPathDAG(int N, int[][] edges, int source){

        if (N == 1) {
            return new int[1];
        }
        
        ArrayList<ArrayList<Pair>> adjList = new ArrayList<>();


        for(int i=0; i<N; i++){
            adjList.add(new ArrayList<>());
        }


        for(int i =0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];

            adjList.get(u).add(new Pair(v, wt));
        }

        Stack<Integer> stack = topoSort(adjList, N);

        int[] distance = new int[N];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;

        relaxEdgesInTopoOrder(stack, distance, adjList);

        for(int i = 0; i<N; i++){
            if (distance[i] == Integer.MAX_VALUE) {
                distance[i] = -1;
            }
        }

        return distance;
    }

    public static void main(String[] args) {
        // int N = 6;  // Number of nodes
        // int[][] edges = {
        //     {0, 1, 2},
        //     {0, 2, 4},
        //     {1, 2, 1},
        //     {1, 3, 7},
        //     {2, 4, 3},
        //     {3, 5, 1},
        //     {4, 5, 5}
        // };
        // int source = 0;  // Starting node

        int N = 6;  
        int[][] edges = {
            {0, 1, 2},
            {0, 2, 4},
            {1, 2, 1},
            {1, 3, 7},
            {2, 4, 3}
            // Node 5 is disconnected
        };
        int source = 0;
        int [] answer = shortestPathDAG(N, edges, source);
        System.out.println(Arrays.toString(answer));

    }

}
