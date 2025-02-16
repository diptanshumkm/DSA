public class addTwoNum {

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int data) {
            this.val = data;
        }

        public ListNode(int data, ListNode next) {
            this.val = data;
            this.next = next;
        }
    }

    public static ListNode addNum(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(-1); 
        ListNode current = dummy; 

        while (l1 != null || l2 != null) {
            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;
            int digit = sum % 10;

            current.next = new ListNode(digit); // Add the digit as a new node
            current = current.next;
        }

        if (carry > 0) {
            current.next = new ListNode(carry); 
        }

        return dummy.next; // Return the result list (skipping the dummy node)
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));

        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        ListNode result = addNum(l1, l2);

        while (result != null) {
            System.out.print(result.val);
            if (result.next != null) {
                System.out.print(" -> ");
            }
            result = result.next;
        }
        
    }
}
