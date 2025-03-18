package com.example;

import java.util.ArrayList;

public class DfsTraversal {


    static ArrayList<Integer> dfsTraversal(int node, boolean visArr[], ArrayList<ArrayList<Integer>> adjList, ArrayList<Integer> answer){

        visArr[node] = true;
        answer.add(node);

        for(int neighbour: adjList.get(node)){
            if (!visArr[neighbour]) {
                dfsTraversal(neighbour, visArr, adjList, answer);
            }

        }

        return answer;

    }

    public static void main(String[] args) {

        int V = 9; // Number of vertices (1 to 8)
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        // Initialize adjacency list
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }

        // Adding edges based on the given graph
        adjList.get(1).add(2); adjList.get(1).add(3);
        adjList.get(2).add(1); adjList.get(2).add(5); adjList.get(2).add(6);
        adjList.get(3).add(1); adjList.get(3).add(4); adjList.get(3).add(7);
        adjList.get(4).add(3); adjList.get(4).add(8);
        adjList.get(5).add(2);
        adjList.get(6).add(2);
        adjList.get(7).add(3); adjList.get(7).add(8);
        adjList.get(8).add(4); adjList.get(8).add(7);

        boolean[] visArr = new boolean[V]; // Visited array
        ArrayList<Integer> answer = new ArrayList<>();

        // Start DFS traversal from node 1
        dfsTraversal(1, visArr, adjList, answer);

        System.out.println("DFS Traversal: " + answer);

    }



}
