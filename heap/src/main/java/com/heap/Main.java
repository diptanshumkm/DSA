package com.heap;

import com.heap.MergeKSrtdLst.ListNode;

public class Main {

    public static class ListNode{
        ListNode next;
        int data;
        ListNode(int data){
            this.data = data;
        }
        ListNode(int val, ListNode next){
            this.data = val;
            this.next = next;
        }
    }


    public static void main(String[] args) {
        System.out.println("Hello world!");

        
        MergeKSrtdLst mergeLl = new MergeKSrtdLst();

          
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(100))));
        ListNode l3 = new ListNode(6, new ListNode(7, new ListNode(8)));

        ListNode arr[]= {l1, l2, l3};
        
        ListNode result = mergeLl.mergeKLinkedList(arr);

        while (result!=null) {
            System.out.print(result.data);
            if (result.next != null) {
                System.out.print(" -> ");
            }
            result = result.next;
        }

    }

    
}