package com.example;

import java.util.ArrayList;
import java.util.Collections;

public class SubsetSum {
   
    // ------------------------------------------------------STORES SUBSET AND RETURN SUM----------------------------------------------------------------
    // public static void generateSubset(int index, int[] arr, int N, ArrayList<Integer> ds, ArrayList<ArrayList<Integer>> subsets){
    //     if (index == N) {
    //         subsets.add(new ArrayList<>(ds));
    //         return;
    //     }

    //     // Pick
    //     ds.add(arr[index]);
    //     generateSubset(index+1, arr, N, ds, subsets);
    //     ds.remove(ds.size()-1);

    //     // Not pick 
    //     generateSubset(index+1, arr, N, ds, subsets);

    // }

    // public static ArrayList<Integer> subsetSum1(int[] arr, int N){
    //     ArrayList<ArrayList<Integer>> subsets = new ArrayList<>();
        
    //     generateSubset(0, arr,N, new ArrayList<>(), subsets);
        
    //     ArrayList<Integer> answer = new ArrayList<>();

    //     for(ArrayList<Integer> i : subsets){
    //         int sum = 0;
    //         for(Integer j: i){
    //             sum = sum +j;
    //         }
    //         answer.add(sum);
    //     }
    //     Collections.sort(answer);
    //     return answer;
    // }


    // ------------------------------------------------------GENERATES SUM WITHOUT SUBSET--------------------------------------
    public static void generateSum(int index, int sum, int[] arr, ArrayList<Integer> answer, int N){

        if (index == N) {
            answer.add(sum);
            return;
        }

        // Pick
        sum = sum + arr[index];
        generateSum(index+1, sum, arr, answer, N);
        sum = sum - arr[index];

        // not pick
        generateSum(index+1, sum, arr, answer, N);

    }

    public static ArrayList<Integer> subsetSum1(int[] arr, int N){

        ArrayList<Integer> answer = new ArrayList<>();
        generateSum(0, 0, arr, answer, N);
        Collections.sort(answer);
        
        return answer;
    }

    public static void main(String[] args) {
        int arr[] = {1};
        int N = 1;
        
        System.out.println(subsetSum1(arr, N));
    }
    
}
