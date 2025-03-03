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
        
        while (index>0) {
            int parent = (index-1)/2;

            if (heap.get(parent) < heap.get(index)) {
                swap(index, parent);
                index = parent;
            }else{
                break;
            }

        }

    }
    private void swap(int x, int y){
        int temp = heap.get(x);
        heap.set(x, heap.get(y));
        heap.set(y, temp);
    }

    public void extractMax(){

        heap.set(0, heap.get(heap.size()-1));
        heap.remove(heap.size()-1);

        heapifyDown();

    }            
    private void heapifyDown(){
        int index=0;
        int leftChild, rightChild, largest;

        while (2*index+1 < heap.size()) {
            
            leftChild = 2*index + 1;
            rightChild = (2*index + 2);
            largest=index;

            if (heap.get(index) < heap.get(leftChild)) {
                largest = leftChild;
            }
            if (rightChild < heap.size()&&heap.get(index) < heap.get(rightChild) ) {
                largest = leftChild;
            }

            swap(index, largest);

            index = largest;

        }

    }



    public void display(){
        System.out.println(heap);
    }


    

}
