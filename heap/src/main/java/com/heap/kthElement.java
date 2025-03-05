package com.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class kthElement {
    
    public int kthSmallestElement(int k, int[] arr){

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int i =0; i<k; i++){
            maxHeap.add(arr[i]);
        }


        for(int j = k; j<arr.length; j++){
            if (arr[j] < maxHeap.peek()) {
                maxHeap.poll(); 
                maxHeap.add(arr[j]);
            }
        }
        return maxHeap.peek();
    }
    public int kthLargestElement(int k, int[] arr){

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int i =0; i<k; i++){
            minHeap.add(arr[i]);
        }


        for(int j = k; j<arr.length; j++){
            if (arr[j] > minHeap.peek()) {
                minHeap.poll(); 
                minHeap.add(arr[j]);
            }
        }
        return minHeap.peek();
    }


}
