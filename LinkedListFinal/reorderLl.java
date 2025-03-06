public class reorderLl {
    
    public static class ListNode {
        int data;
        ListNode next;
        ListNode(int data){
            this.data = data;
        }
        ListNode(int data, ListNode next){
            this.data = data;
            this.next = next;
        }
    }

    // public static ListNode reorderLlBrute(ListNode l1){
    //     if (l1 == null || l1.next == null) return l1;
    //     ArrayList<Integer> arr = new ArrayList<>();
    //     ListNode temp = l1;
    //     ListNode dummy = new ListNode(-1);
    //     ListNode current = dummy;

    //     // LinkedList added in array
    //     while (temp!= null) {
    //         arr.add(temp.data);
    //         temp=temp.next;
    //     }

    //     int i = 0;
    //     int j = (arr.size())-1;

    //     while (i <= j) {
    //         current.next = new ListNode(arr.get(i));
    //         current = current.next;
    //         if (i != j) {
    //             current.next = new ListNode(arr.get(j));
    //             current = current.next;
    //         }
    //         i++;
    //         j--;
    //     }
    //     return dummy.next;

    // }


    public static ListNode reorderLlOptm(ListNode l1){
        if (l1.next==null || l1 == null) {
            return l1;
        }

        ListNode fast = l1;
        ListNode slow = l1;
        // -----------------------------------------Find the MidPoint
        while (fast!=null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        //---------------------------------Reverse the LL from the mid point
        ListNode prevNode = null;
        while (slow!=null) {
            ListNode front = slow.next;
            slow.next = prevNode;
            prevNode = slow;
            slow = front;
        }

        //---------------------------------------------Rejoin LL

        ListNode first = l1;
        ListNode second = prevNode;

        while (second.next!=null) {
            
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            first.next =second;
            second.next = temp1;

            first = temp1;
            second = temp2;
        }

        return l1;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(8, new ListNode(10))));
        
        System.out.println("Input list: ");

        ListNode dum = l1;
        while (dum != null) {
            System.out.print(dum.data);
            if (dum.next != null) {
                System.out.print(" -> ");
            }
            dum = dum.next;
    
        }

        ListNode result = reorderLlOptm(l1);
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
