package com.example;

import java.util.*;



// Assumes the graph is connected (i.e., all nodes are reachable from node 1).
public class Traversals {
    
    public static ArrayList<Integer> bfsTraversal(int nodes, ArrayList<ArrayList<Integer>> adjList){

        Queue<Integer> queue = new LinkedList<>();
        int visitedArr[] = new int[nodes+1];
        ArrayList<Integer> answer = new ArrayList<>();

        queue.add(1);
        visitedArr[1] = 1;

        while (!queue.isEmpty()) {
            
            int data = queue.poll();
            answer.add(data);

            ArrayList<Integer> list = adjList.get(data);

            for(int i: list){
                if(visitedArr[i] != 1){
                    queue.add(i);
                    visitedArr[i] = 1;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 9; // Number of nodes
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        // Initialize adjacency list
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        // Add edges based on the given tree
        adjList.get(1).add(2);
        adjList.get(1).add(6);

        adjList.get(2).add(1);
        adjList.get(2).add(3);
        adjList.get(2).add(4);

        adjList.get(3).add(2);

        adjList.get(4).add(2);
        adjList.get(4).add(5);
        adjList.get(4).add(8);

        adjList.get(5).add(4);
        adjList.get(5).add(8);

        adjList.get(6).add(1);
        adjList.get(6).add(7);
        adjList.get(6).add(9);

        adjList.get(7).add(6);

        adjList.get(8).add(4);
        adjList.get(8).add(5);

        adjList.get(9).add(6);


        ArrayList<Integer> result = bfsTraversal(n, adjList);
        System.out.println(result);
    }



}
