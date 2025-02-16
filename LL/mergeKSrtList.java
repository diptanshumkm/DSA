import java.util.*;
public class mergeKSrtList {    
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

    // public static ListNode mergeKSrtListBrute(ListNode arr[]){
    //     ArrayList<Integer> list = new ArrayList<>();
    //     ListNode dummy = new ListNode(-1);
    //     ListNode current = dummy;
    //     for(ListNode head:arr){
    //         ListNode temp = head;
    //         while (temp!=null) {
    //             list.add(temp.data);
    //             temp = temp.next;
    //         }
    //     }
    //     Collections.sort(list);

    //     for(int x: list){
    //         current.next = new ListNode(x);
    //         current = current.next;
    //     }

    //     return dummy.next;
    // }

    public static ListNode mergeKSrtListOptm(ListNode arr[]){
        PriorityQueue<Map.Entry<Integer, ListNode>>pq = new PriorityQueue<>(
            Comparator.comparingInt(Map.Entry::getKey));

        for(ListNode head : arr){
            if (head!=null) {
                pq.add(new AbstractMap.SimpleEntry<>(head.data, head));
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        while (!pq.isEmpty()) {
            
            Map.Entry<Integer, ListNode> it = pq.poll();

            if (it.getValue().next != null) {
                pq.add(new AbstractMap.SimpleEntry<>(it.getValue().next.data, it.getValue().next));
            }

            current.next = it.getValue();
            current = current.next;
        }
        return dummy.next;
    }
        

    public static void main(String[] args) {
        
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(100))));
        ListNode l3 = new ListNode(6, new ListNode(7, new ListNode(8)));

        ListNode arr[]= {l1, l2, l3};
        
        ListNode result = mergeKSrtListOptm(arr);

        while (result!=null) {
            System.out.print(result.data);
            if (result.next != null) {
                System.out.print(" -> ");
            }
            result = result.next;
        }

    }
}

