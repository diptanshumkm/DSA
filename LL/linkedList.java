import java.util.*;

public class linkedList {

    // Node class
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // LinkedList implementation class
    class lL {
        private Node head;

        // 1. Insert at the beginning
        public void insertAtBeginning(int data) {
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
        }

        // 2. Insert at the end
        public void insertAtEnd(int data) {
            Node newNode = new Node(data);
            if (head == null) { // If the list is empty
                head = newNode;
                return;
            }
            Node temp = head;
            while (temp.next != null) { // Traverse to the last node
                temp = temp.next;
            }
            temp.next = newNode; // Link the last node to the new node
        }

        // 3. Insert at a specific position
        public void insertAtSpecificPosition(int data, int position) {
            if (position == 0) {
                insertAtBeginning(data);
                return;
            }

            Node newNode = new Node(data);
            Node temp = head;

            for (int i = 0; i < position - 1 && temp != null; i++) {
                temp = temp.next;
            }

            if (temp == null) {
                System.out.println("Position out of bounds");
                return;
            }

            newNode.next = temp.next;
            temp.next = newNode;
        }

        // 4. Delete from the beginning
        public void deleteFromBeginning() {
            if (head == null) {
                System.out.println("List is empty");
                return;
            }
            head = head.next;
        }

        // 5. Delete from the end
        public void deleteFromEnd() {
            if (head == null) {
                System.out.println("List is empty");
                return;
            }
            if (head.next == null) { // If the list has only one node
                head = null;
                return;
            }
            Node temp = head;
            while (temp.next.next != null) { // Traverse to the second last node
                temp = temp.next;
            }
            temp.next = null; // Unlink the last node
        }

        // 6. Delete a specific value
        public void deleteByVal(int value) {
            if (head == null) {
                System.out.println("List is empty");
                return;
            }

            if (head.data == value) { // If the value is in the head
                head = head.next;
                return;
            }

            Node temp = head;
            while (temp.next != null && temp.next.data != value) {
                temp = temp.next;
            }

            if (temp.next == null) {
                System.out.println("Value not found in the list");
                return;
            }

            temp.next = temp.next.next; // Unlink the node with the value
        }

        // 7. Search for an element
        public boolean searchEle(int value) {
            Node temp = head;

            while (temp != null) {
                if (temp.data == value) {
                    return true;
                }
                temp = temp.next;
            }
            return false;
        }

        // 8. Display the linked list
        public void display() {
            if (head == null) {
                System.out.println("List is empty");
                return;
            }

            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            }
            System.out.println("null");
        }

        // 9. Get the length of the linked list
        public int getLength() {
            int length = 0;
            Node temp = head;

            while (temp != null) {
                length++;
                temp = temp.next;
            }
            return length;
        }
    }

    public static void main(String[] args) {
        // Create an instance of the outer class
        linkedList outer = new linkedList();
        // Create an instance of the inner class 'lL'
        lL list = outer.new lL();

        // Test the linked list
        list.insertAtBeginning(10);
        list.insertAtBeginning(20);
        list.insertAtEnd(30);
        list.insertAtSpecificPosition(25, 2);

        list.display(); // Output: 20 -> 10 -> 25 -> 30 -> null

        list.deleteFromBeginning();
        list.deleteFromEnd();
        list.deleteByVal(25);

        list.display(); // Output: 10 -> null

        System.out.println("Length: " + list.getLength()); // Output: Length: 1
        System.out.println("Search 10: " + list.searchEle(10)); // Output: Search 10: true
    }
}
