package com.example;

import java.util.ArrayList;

public class CombinationSumI {
    
    public static void findCombination(int index, int target, int[] arr, ArrayList<Integer> ds, ArrayList<ArrayList<Integer>> answer){

        if (index == arr.length) {
            if (target == 0 ) {
                answer.add(new ArrayList<>(ds));
            }
            return;
        }

        // Picked
        if (arr[index] <= target) {
            ds.add(arr[index]);
            findCombination(index, target-arr[index], arr, ds, answer);
            ds.remove(ds.size() - 1);
        }


        // Not picked
        findCombination(index+1, target, arr, ds, answer);

    }


    public static ArrayList<ArrayList<Integer>> combinationSum(int target, int[] arr){
        ArrayList<ArrayList<Integer>> answer = new ArrayList<>();
        findCombination(0, target, arr, new ArrayList<>(), answer);
        return answer;
    }


    public static void main(String[] args) {
        int arr[] = {2,3,6,7};
        int target = 7;


        System.out.println( combinationSum(target, arr) );

    }

}
