package com.example;

import java.util.ArrayList;
import java.util.Arrays;

public class SubsetSum2 {

    
    public static void generateSubset(int index, ArrayList<Integer> ds, int[] arr, ArrayList<ArrayList<Integer>> answer){

        answer.add(new ArrayList<>(ds));

        for(int i=index; i<arr.length; i++){
            if (i>index && arr[i] == arr[i-1]) {continue;}
            ds.add(arr[i]);
            generateSubset(i+1, ds, arr, answer);
            ds.remove(ds.size()-1);
        }

    }

    public static ArrayList<ArrayList<Integer>> subsestSum2(int[] arr){
        ArrayList<ArrayList<Integer>> answer = new ArrayList<>();
        Arrays.sort(arr);
        generateSubset(0, new ArrayList<>(), arr, answer);
        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2};

        System.out.println(subsestSum2(arr));
        
    }
}
