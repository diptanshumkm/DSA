package com.example;

import java.util.*;

public class CombinationSumII {
   //------------------------------------------------------------------BRUTE FORCE------------------------------------------------------------------------- 
    // public static void findCombination(int index, int target, int[] arr, ArrayList<Integer> ds, HashSet<ArrayList<Integer>> set){
    //     if (arr.length == index) {
    //         if (target==0) {
    //             set.add(new ArrayList<>(ds));
    //         }
    //         return;
    //     }
    //     if (target >= arr[index]) {
    //         ds.add(arr[index]);
    //         findCombination(index+1, target-arr[index], arr, ds, set);
    //         ds.remove(ds.size() - 1);

    //     }
    //     findCombination(index+1, target, arr, ds, set);
    // }


    // public static ArrayList<ArrayList<Integer>> combinationSumBrute(int target, int[] arr){
    //     HashSet<ArrayList<Integer>> set = new HashSet<>();
    //     ArrayList<ArrayList<Integer>> answer = new ArrayList<>();

    //     findCombination(0, target, arr, new ArrayList<>(), set);

    //     for(ArrayList<Integer> element: set){
    //         answer.add(element);
    //     }
    //     return answer;
    // }



    // ---------------------------------------------------------------------OPTIMIZED SOLUTION-----------------------------------------------------------------------
    public static void findCombination(int index, int target, int[] arr, ArrayList<Integer> ds, ArrayList<ArrayList<Integer>> answer){

        if (target == 0) {
            answer.add(new ArrayList<>(ds));
        }

        for(int i = index; i<arr.length; i++){

            if (i > index && arr[i] == arr[i-1]) {continue;}
            if (arr[i]>target) {break;}

            ds.add(arr[i]);
            findCombination(index+1, target-arr[i], arr, ds, answer);
            ds.remove(ds.size()-1);
        }
    }


    public static ArrayList<ArrayList<Integer>> combinationSumOptimised(int[] arr, int target){
        ArrayList<ArrayList<Integer>> answer = new ArrayList<>();
        Arrays.sort(arr);

        findCombination(0, target, arr, new ArrayList<>(), answer);
        return answer;
    }



    public static void main(String[] args) {
        int[] arr = {10, 1, 2, 7, 6, 1, 5};
        int target = 8; 

        System.out.println(combinationSumOptimised(arr, target));

    }

}