package com.example;

import java.util.*;

public class Bipartite {

    public static boolean isBipartiteBfs(ArrayList<ArrayList<Integer>> adjList, int startNode, int totalNode){

        Queue<Integer> queue = new LinkedList<>();
        int [] coloredArr = new int[totalNode+1];

        // Mark all the arr elements to -1
        for(int i=0; i < coloredArr.length; i++){
            coloredArr[i] = -1;
        }

        queue.add(startNode);
        coloredArr[startNode] = 0;

        while (!queue.isEmpty()) {
            int data = queue.poll();
            
            for(int i: adjList.get(data)){
                if (i == -1) {
                    coloredArr[i] = 1 - coloredArr[data]; 
                    queue.add(i);
                    
                }else if (coloredArr[i] == coloredArr[data] ) {
                    return false;
                }
            }            
        }
        return true;
    }

    public static void main(String[] args) {

        int startNode = 1;
        int totalNode = 6;

        // Initialize adjacency list
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= totalNode; i++) {
            adjList.add(new ArrayList<>());
        }

        // Adding edges for an Even Cycle Graph (Bipartite)
        adjList.get(1).add(2); adjList.get(1).add(6);
        adjList.get(2).add(1); adjList.get(2).add(3);
        adjList.get(3).add(2); adjList.get(3).add(4);
        adjList.get(4).add(3); adjList.get(4).add(5);
        adjList.get(5).add(4); adjList.get(5).add(6);
        adjList.get(6).add(1); adjList.get(6).add(5);
        System.out.println(isBipartiteBfs(adjList, startNode, totalNode));
        
        
        // int startNode = 1;
        // int totalNode = 4;

        // // Initialize adjacency list
        // ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        // for (int i = 0; i <= totalNode; i++) {
        //     adjList.add(new ArrayList<>());
        // }
        
        // // Adding edges for Non-Bipartite Graph
        // adjList.get(1).add(2); adjList.get(1).add(3);
        // adjList.get(2).add(1); adjList.get(2).add(3);
        // adjList.get(3).add(1); adjList.get(3).add(2); adjList.get(3).add(4);
        // adjList.get(4).add(3);
        
    }

    
}