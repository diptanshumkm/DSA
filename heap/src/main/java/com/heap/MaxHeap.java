package com.heap;
import java.util.*;

public class MaxHeap {
    private ArrayList<Integer> heap;

    public MaxHeap(){
        heap = new ArrayList<>();
    }

    public void insert(int val){
        heap.add(val);
        heapifyUp(heap.size()-1);
    }
    private void heapifyUp(int index){
        int parent = 

    }



}
