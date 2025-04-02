package com.example;

import java.util.*;

public class KahnsAlgo {
        
    static void bfs(int[] inDegree, ArrayList<ArrayList<Integer>> adjList, int totalNode, ArrayList<Integer> answer){
        Queue<Integer> queue = new LinkedList<>();

        for(int i=0; i<inDegree.length;i++){
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {   
            int data = queue.poll();
            answer.add(data);

            for(int i: adjList.get(data)){
                inDegree[i]--;
                if (inDegree[i]==0) {
                    queue.add(i);
                }
            }
        }
    }

    public  ArrayList<Integer> topoSortBfs(ArrayList<ArrayList<Integer>> adjList, int totalNode){
        ArrayList<Integer> answer  = new ArrayList<>();
        int[] inDegree = new int[totalNode];

        for(int j=0; j<totalNode; j++){
            for(int i: adjList.get(j)){
                inDegree[i]++;
            }
        }

        bfs(inDegree, adjList, totalNode, answer);

        if (answer.size()!=totalNode) {
            System.out.println("Cycle detected, topological sort not possible.");
            return new ArrayList<>();
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

        // System.out.println(topoSortBfs(adjList, totalNode));
    }
}
