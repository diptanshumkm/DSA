import java.util.*;

public class reverseLl {
    
    public static class ListNode {
        int data;
        ListNode next;

        public ListNode(int val){
            this.data = val;
        }
        public ListNode(int val, ListNode next){
            this.data = val;
            this.next=next;
        }
    }

    // public static ListNode revLinkdLstBrute(ListNode l1){
    //     Stack<Integer> stack = new Stack<>();
    //     ListNode temp1 = l1;
    //     ListNode dummyNode = new ListNode(-1);
    //     ListNode current = dummyNode;

    //     //------------------------TC: O(n)
    //     while (temp1 != null) {
    //         stack.push(temp1.data);
    //         temp1 = temp1.next; 
    //     }

    //     //--------------------TC: O(n) SC: O(n)
    //     while (!stack.isEmpty()) {
    //         current.next = new ListNode(stack.pop());
    //         current = current.next;
    //     }
    //     return dummyNode.next;

    //     //------------------Total TC:- O(n) SC: O(n)
    // }


    public static ListNode revLinkdLstOptm1(ListNode l1){
        ListNode temp = l1;
        ListNode prev = null;
    
        while (temp!=null) {
            
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }

        return prev;

        //-------------------------- Total TC: O(n) SC: O(1)

    }
    public static void main(String[] args) {
        
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(8, new ListNode(10))));


        // Print LL
        System.out.println("Input list: ");
        ListNode dum = l1;
        while (dum!=null) {
            System.out.print(dum.data);
            if (dum.next != null) {
                System.out.print(" -> ");
            }
            dum=dum.next;
        }
        ListNode result = revLinkdLstOptm1(l1);
        System.out.println();
        System.out.println();

        System.out.println("Output list: ");

        while (result!=null) {
            System.out.print(result.data);
            if (result.next != null) {
                System.out.print(" -> ");
            }
            result=result.next;
        }
    }
}
