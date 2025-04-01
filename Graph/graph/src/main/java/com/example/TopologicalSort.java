package com.example;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {
    static void dfs(ArrayList<ArrayList<Integer>> adjList, Stack<Integer> stack, int[] visArr, int node ){
        visArr[node] = 1;
        for(int i : adjList.get(node)){
            if (visArr[i] == 0 ) {
                dfs(adjList, stack, visArr, i);
            }
        }
        stack.add(node);
    }

    static ArrayList<Integer> topoSort(ArrayList<ArrayList<Integer>> adjList, int totalNode){
        ArrayList <Integer> answer = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int[] visArr = new int[totalNode+1];

        for(int i = 0; i < totalNode; i++){
            if (visArr[i]==0) {
                dfs(adjList, stack, visArr, i);
            }
        }

        while (!stack.isEmpty()) {
            answer.add(stack.pop());
        }
        return answer;
    }


    public static void main(String[] args) {
        int totalNode = 6;  // Total number of nodes

        // Initialize adjacency list
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < totalNode; i++) {
            adjList.add(new ArrayList<>());
        }

        // Adding directed edges for DAG
        adjList.get(5).add(0);
        adjList.get(5).add(2);
        adjList.get(4).add(0);
        adjList.get(4).add(1);
        adjList.get(2).add(3);
        adjList.get(3).add(1);

        System.out.println(topoSort(adjList, totalNode));

    }
    
}
