package com.example;

import java.util.ArrayList;

public class NumberOfProvinces {

    public static void dfs( int node, ArrayList<ArrayList<Integer>> adjList, int[] visArr){
        visArr[node] = 1;

        for(int i: adjList.get(node)){
            if (visArr[i] == 0) {
                dfs(i, adjList, visArr);
            }
        }

    }
    
    public static int numOfProvinces(ArrayList<ArrayList<Integer>> adjList, int totalNode){

        int[] visArr = new int[totalNode+1];
        for(int i=0; i<totalNode; i++){
            visArr[i] = 0;
        }
        
        int count =0;
        for(int j=1; j<=totalNode; j++){
            if (visArr[j] == 0) {
                count = count+1;
                dfs(j, adjList, visArr);
            }
        }

        return count;
    }


    public static void main(String[] args) {

        int totalNode = 5;

        // Initialize adjacency list
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= totalNode; i++) {
            adjList.add(new ArrayList<>());
        }

        // Province 1: {1, 2, 5}
        adjList.get(1).add(2); adjList.get(2).add(1);
        adjList.get(2).add(5); adjList.get(5).add(2);

        // Province 2: {3, 4}
        adjList.get(3).add(4); adjList.get(4).add(3);

        System.out.println(numOfProvinces(adjList, totalNode));
    }
}
