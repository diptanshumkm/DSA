package com.heap;
import java.util.*;

public class SlidingWindowMax {
    
    public static ArrayList<Integer> maxInSlidingWindow(int k, int[] arr){

        ArrayList<Integer> answer = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<k; i++){
            pq.add(arr[i]);
        }
        answer.add(pq.peek());

        for(int i = k; i<arr.length; i++){
            pq.remove(arr[i-k]);
            pq.add(arr[i]);
            answer.add(pq.peek());
        }

        
        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,-1,-3,5,3,6,7};

        ArrayList<Integer> ans =  maxInSlidingWindow(3, arr);
        System.out.println(ans);
    }

}
