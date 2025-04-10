package com.example;

import java.util.ArrayList;

public class PermutationArr {

    public static void generatePermutation(int[] map, ArrayList<Integer> ds, int[] arr, int N, ArrayList<ArrayList<Integer>> answer){
        if (ds.size() == N) {
            answer.add(new ArrayList<>(ds));
            return;
        }

        for(int i = 0; i < map.length; i++){
            if (map[i]!=1) {
                ds.add(arr[i]);
                map[i] = 1;
                generatePermutation(map, ds, arr, N, answer);
                map[i] = 0;
                ds.remove(ds.size()-1);
            }
        }
    }
    
    public static ArrayList<ArrayList<Integer>> permutationOfArr(int[] arr, int N){
        ArrayList<ArrayList<Integer>> answer = new ArrayList<>();
        int[] map = new int[arr.length];
        generatePermutation(map, new ArrayList<>(),arr, N ,answer);
        return answer;
    }


    public static void main(String[] args) {        
        int[] arr = {1,2,3};
        int N = 3;

        System.out.println(permutationOfArr(arr, N));
    }

}
