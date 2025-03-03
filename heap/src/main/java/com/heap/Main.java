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

        BankAcc shivAcc = new BankAcc(12345, "Shivam");
        shivAcc.displayAccInfo();
       
        
        shivAcc.deposit(500);
        System.out.println( shivAcc.getBalance() );
    }

    
}