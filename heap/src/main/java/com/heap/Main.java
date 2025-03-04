package com.heap;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");

        MaxHeap maxHeap = new MaxHeap();
        maxHeap.insert(50);
        maxHeap.insert(40);
        maxHeap.insert(45);
        maxHeap.insert(30);
        maxHeap.insert(20);
        maxHeap.insert(35);
        maxHeap.insert(10);
        maxHeap.insert(60);

        maxHeap.display();
        System.out.println(  maxHeap.getMax() );

        maxHeap.extractMax();
        maxHeap.display();

        

    }

    
}