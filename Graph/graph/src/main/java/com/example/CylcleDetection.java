package com.example;

import java.util.ArrayList;

public class CylcleDetection {
    


    static boolean dfs(ArrayList<ArrayList<Integer>> adjList, int node, int[] visArr, int parent ){
        visArr[node] = 1;
        for(int i : adjList.get(node)){
            if (visArr[i] == 0) {
                if(dfs(adjList, i, visArr, node)==true){
                    return true;
                }
            }else if(i != parent){
                return true;
            }
        }
        return false;
    }


    static boolean isCyclic(ArrayList<ArrayList<Integer>> adjList, int totalNode, int startNode ){

        int[] visArr = new int[totalNode+1];
        
        boolean answer = dfs(adjList, startNode, visArr, -1);
        return answer;
    }





    public static void main(String[] args) {
        
        int totalNode = 3;
        int startNode = 1;

        // Initialize adjacency list
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= totalNode; i++) {
            adjList.add(new ArrayList<>());
        }

        // Adding edges for an Odd Cycle Graph (Non-Bipartite)
        adjList.get(1).add(2); adjList.get(2).add(1);
        adjList.get(2).add(3); adjList.get(3).add(2);
        adjList.get(3).add(1); adjList.get(1).add(3);

        System.out.println(isCyclic(adjList, totalNode, startNode));
    }
}
