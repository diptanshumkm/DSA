/*Given the head of a linked list, remove the nth node from the end of the list and return its head. */

import javax.swing.text.html.ListView;

public class removeNode {

    public static class ListNode{
        int data;
        ListNode next;
        ListNode(int val){
            this.data = val;
        }
        ListNode(int val, ListNode next){
            this.data = val;
            this.next = next;
        }
    }

    // public static ListNode removeNodeBrute(ListNode l1, int k){

    //     ListNode temp =l1;
    //     int length=0;

    //     while (temp!=null) {
    //         length++;
    //         temp=temp.next;
    //     }

    //     if (k == length) {
    //         l1 = l1.next;
    //         return l1;
    //     }

    //     int nodeRemove = (length-k);

    //     temp = l1;
    //     while (temp!=null) {
    //         nodeRemove--;
    //         if (nodeRemove==0) {
    //             break;
    //         }
    //         temp=temp.next;
    //     }

    //     ListNode delNode = temp.next;
    //     temp.next = temp.next.next;
    //     delNode = null;

    //     return l1;

    // }

    public static ListNode remNodeOptm(ListNode l1, int k){
        ListNode dummy = new ListNode(-1);
        dummy.next=l1;
        ListNode fast = dummy;
        ListNode slow = dummy;

        for(int i =0; i<k; i++){
            fast=fast.next;
        }
        
        if (fast==null) {
            return dummy.next.next;
        }

        while (fast.next!=null) {
            slow = slow.next;
            fast = fast.next;
        }

        ListNode delNode = slow.next;
        slow.next=slow.next.next;
        delNode = null;

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(8, new ListNode(10))));
        
        ListNode result = remNodeOptm(l1, 3);

        while (result!=null) {
            System.out.print(result.data);
            if (result.next != null) {
                System.out.print(" -> ");
            }
            result=result.next;
        }

    }

}
