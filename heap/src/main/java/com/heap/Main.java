package com.heap;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");

        // MaxHeap maxHeap = new MaxHeap();
        // maxHeap.insert(50);
        // maxHeap.insert(40);
        // maxHeap.insert(45);
        // maxHeap.insert(30);
        // maxHeap.insert(20);
        // maxHeap.insert(35);
        // maxHeap.insert(10);
        // maxHeap.insert(60);

        // maxHeap.display();
        
        // maxHeap.extractMax();
        // maxHeap.display();
        
        // System.out.println(  maxHeap.getMax() );

        kthElement ques = new kthElement();
        // int arr[] = {10, 5, 20, 8, 12, 15, 2};

        // int answer = ques.kthSmallestElement(3, arr);
        // System.out.println(answer);

        int arr[] = {12, 3, 5, 7, 19, 26, 15};

        int answer = ques.kthLargestElement(3, arr);
        System.out.println(answer);

    }

    
}