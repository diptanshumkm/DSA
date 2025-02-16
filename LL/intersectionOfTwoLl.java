import java.util.HashMap;

public class intersectionOfTwoLl {
    
    public static class ListNode {
        int data;
        ListNode next;

        public ListNode(int data){
            this.data = data;
        }
        public ListNode(int data, ListNode next){
            this.data = data;
            this.next = next;
        }
    }

    // public static void intersectionLlBrute(ListNode l1, ListNode l2){

    //     HashMap<ListNode, Integer> map = new HashMap<>();
    //     ListNode temp1 = l1;
    //     ListNode temp2 = l2;

    //     while (temp1!=null) {
    //         if (map.containsKey(temp1)) {
    //             map.put(temp1, map.get(temp1)+1);
    //         }else{
    //             map.put(temp1, 1);
    //         }
    //         temp1=temp1.next;
    //     }
    //     while (temp2!=null) {
    //         if (map.containsKey(temp2)) {
    //             System.out.println("Intersection Node: " + temp2.data);
    //             return;
    //         }
    //         temp2=temp2.next;
    //     }

    //     System.out.println("No intersection");
    // }


    // public static void collisionPoint(ListNode l1, ListNode l2, int d){

    //     ListNode temp1 = l1;
    //     ListNode temp2 = l2;

    //     while (d > 0 && (temp2 != null)) {
    //         d--;
    //         temp2 = temp2.next;
    //     }
    //     while (temp1 != null && temp2 != null) {
    //         if (temp1 == temp2) {
    //             System.out.println("Intersection point: " + temp1.data);
    //             return;
    //         }
    //         temp1 = temp1.next;
    //         temp2 = temp2.next;
    //     }
    //     System.out.println("No Intersection point");

    // }

    // public static void intersectionLlBetter(ListNode l1, ListNode l2){

    //     int length1 = 0;
    //     int length2 = 0;
    //     ListNode temp1=l1;
    //     ListNode temp2=l2;

    //     while (temp1!=null) {
    //         length1++;
    //         temp1=temp1.next;
    //     }
    //     while (temp2!=null) {
    //         length2++;
    //         temp2=temp2.next;
    //     }

    //     if (length1<length2) {
    //         collisionPoint(l1, l2, length2-length1);
    //     }else{
    //         collisionPoint(l1, l2, length1-length2);
    //     }
    // }


    public static void intersectionLlOptm(ListNode l1, ListNode l2){
        if (l1==null || l2==null) {
            System.out.println("No intersection, List Empty");
            return;
        }

        ListNode temp1 = l1;
        ListNode temp2 = l2;

        while (temp1 != temp2) {
            temp1 = (temp1 == null) ? l2 : temp1.next;
            temp2 = (temp2 == null) ? l1 : temp2.next;
        }
        if (temp1 == null) {
            System.out.println("No intersection point");
            
        }else{
            System.out.println("Intersection point: " + temp1.data);
        }

    }

    public static void main(String[] args) {

        // Creating common intersection node
        ListNode intersection = new ListNode(4, new ListNode(5));

        // Creating first linked list: 1 -> 2 -> 4 -> 5
        ListNode l1 = new ListNode(1, new ListNode(2, intersection));

        // Creating second linked list: 1 -> 3 -> 4 -> 5
        ListNode l2 = new ListNode(1, new ListNode(3, intersection));


        // ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        // ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        // intersectionLlBrute(l1, l2);
        intersectionLlOptm(l1, l2);            
    }
}
