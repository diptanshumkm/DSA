package com.heap;
import java.util.*;

public class TopKFreqElement {
    

    public static ArrayList<Integer> mostFreqKelement(int[] arr, int k){
        
        ArrayList<Integer> answer = new ArrayList<>();

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
            Comparator.comparing(Map.Entry::getValue, Collections.reverseOrder())
        );

        HashMap <Integer, Integer> map = new HashMap<>();

        for(int element: arr){
            if (map.containsKey(element)) {
                map.put(element, map.get(element)+1);
            }else{
                map.put(element, 1);
            }
        }

        for(Map.Entry<Integer, Integer> entry: map.entrySet() ){
            pq.add(entry);
        }

        for(int i=0; i<k; i++){
            Map.Entry<Integer, Integer> dummy = pq.poll();
            answer.add(dummy.getKey());
        }
        return answer;

    }
    public static void main(String[] args) {
        
        int[] arr ={1,1,1,2,2,3,3};

        System.out.println(mostFreqKelement(arr, 2));

    }

}
