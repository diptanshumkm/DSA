import java.util.*;

public class mergeTwoSrtList {

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

    // public static ArrayList<Integer> arrList(ListNode l1, ListNode l2){
    //     ArrayList<Integer> listData = new ArrayList<>();

    //     while (l1!=null) {
    //         listData.add(l1.data);
    //         l1 = l1.next;
    //     }
    //     while (l2!=null) {
    //         listData.add(l2.data);
    //         l2 = l2.next;
    //     }
    //     Collections.sort(listData);
    //     return listData;
    // } 

    // public static ListNode MergeTwoListBrute(ListNode l1, ListNode l2){
    //     ListNode dummy = new ListNode(-1);
    //     ListNode current = dummy;
    //     ArrayList<Integer> arr = arrList(l1, l2);
    //     for(int num: arr){
    //         current.next = new ListNode(num);
    //         current = current.next;
    //     }

    //     return dummy.next;
    // }
    

    public static ListNode MergeTwoListOptmized(ListNode l1, ListNode l2){

        ListNode dummyNode = new ListNode(-1);
        ListNode current = dummyNode;
        ListNode temp1 = l1;
        ListNode temp2 = l2;

        while (temp1!=null && temp2!=null) {
            if (temp1.data < temp2.data) {
                current.next = temp1;
                current = current.next;
                temp1 = temp1.next;
            }else{
                current.next = temp2;
                current = current.next;
                temp2 = temp2.next;
            }
        }

        if (temp1!=null) {
            current.next = temp1;
        }
        if (temp2!=null) {
            current.next = temp2;
        }
        return dummyNode.next;
    }


    public static void main(String[] args) {
        
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        ListNode result = MergeTwoListOptmized(l1, l2);

        while (result!=null) {
            System.out.print(result.data);
            if (result.next != null) {
                System.out.print(" -> ");
            }
            result = result.next;
        }

    }
}