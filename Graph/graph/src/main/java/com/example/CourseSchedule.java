package com.example;

import java.util.*;

public class CourseSchedule {
    

    public static boolean canFinish1(int numCourses, int[][] prerequisites){

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for(int i = 0; i < numCourses; i++){
            adjList.add(new ArrayList<>());
        }
        
        int m = prerequisites.length;
        
        for(int i=0; i<m; i++){
            int course = prerequisites[i][0];
            int prerequisiteCourse = prerequisites[i][1];

            adjList.get(prerequisiteCourse).add(course);
        }

        KahnsAlgo topo = new KahnsAlgo();
        ArrayList<Integer> answer = topo.topoSortBfs(adjList, numCourses);

        if (answer.size() == numCourses) {
            return true;
        }else{
            return false;
        }

    }
    public static ArrayList<Integer> canFinish2(int numCourses, int[][] prerequisites){

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for(int i = 0; i < numCourses; i++){
            adjList.add(new ArrayList<>());
        }
        
        int m = prerequisites.length;
        
        for(int i=0; i<m; i++){
            int course = prerequisites[i][0];
            int prerequisiteCourse = prerequisites[i][1];

            adjList.get(prerequisiteCourse).add(course);
        }

        KahnsAlgo topo = new KahnsAlgo();
        ArrayList<Integer> answer = topo.topoSortBfs(adjList, numCourses);

        return answer;

    }

    public static void main(String[] args) {

        // int numCourses = 4;
        // int[][] prerequisites = {
        //     {1, 0},  // To take course 1, you must complete course 0
        //     {2, 1},  // To take course 2, you must complete course 1
        //     {3, 2}   // To take course 3, you must complete course 2
        // };

        
        // CYCLIC GRAPH        
        int numCourses = 3;
        int[][] prerequisites = {
            {0, 1},  // Course 0 requires 1
            {1, 2},  // Course 1 requires 2
            {2, 0}   // Course 2 requires 0 (Forms a cycle)
        };
        System.out.println(canFinish2(numCourses, prerequisites));
        
    }
}
