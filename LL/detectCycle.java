import java.util.*;;

public class detectCycle {

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
    // public static boolean detectCycleBrute(ListNode l1){

    //     HashMap<ListNode, Integer> map = new HashMap<>();
    //     ListNode temp = l1;
        
    //     while (temp!=null) {
    //         if (map.containsKey(temp)) {
    //             return true;
    //         }else{
    //             map.put(temp, 1);
    //         }
    //         temp=temp.next;
    //     }

    //     return false;
    // }


    public static boolean detectCycleOptm(ListNode l1){

        ListNode fast = l1;
        ListNode slow = l1;

        while (fast!=null && fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(8, new ListNode(10))));
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(8, new ListNode(10))));
        l1.next.next.next.next = l1.next; // Creating a cycle (10 → 4)

        boolean result = detectCycleOptm(l1);
        System.out.println(result);
    }
    
}
