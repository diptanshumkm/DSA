import java.util.*;

public class MergeKSrtdLst {
    

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

    public static ListNode mergeKLinkedList(ListNode[] arr){

        //Priority queue with type <integer, listnode> and priority is determined by key type
        PriorityQueue<Map.Entry<Integer, ListNode>> pq = new PriorityQueue<>(Comparator.comparing(Map.Entry::getKey));

        for(ListNode head: arr){
            if (head!=null) {
                pq.add(new AbstractMap.SimpleEntry<>(head.data, head));
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        while (!pq.isEmpty()) {
            
            Map.Entry<Integer, ListNode> dum =  pq.poll();

            if (dum.getValue().next!=null) {
                
                pq.add(new AbstractMap.SimpleEntry<>(dum.getValue().next.data,  dum.getValue().next));
            }

            current.next = dum.getValue();
            current = current.next;
        }

        return dummy.next;

    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(100))));
        ListNode l3 = new ListNode(6, new ListNode(7, new ListNode(8)));

        ListNode[] arr= {l1, l2, l3};
        
        ListNode result = mergeKLinkedList(arr);

        while (result!=null) {
            System.out.print(result.data);
            if (result.next != null) {
                System.out.print(" -> ");
            }
            result = result.next;
        }

    }
}
