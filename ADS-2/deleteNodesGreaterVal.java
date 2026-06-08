/* Structure of Linked list node
class Node {
    int data;
    Node next;
    
    Node(int d) {
        data = d;
        next = null;
    }
}
*/

public class deleteNodesGreaterVal {

    // Helper function to reverse L
    private Node reverse(Node head) {
        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    Node compute(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        head = reverse(head);

        Node current = head;
        int max_val = head.data;

        while (current != null && current.next != null) {
            if (current.next.data < max_val) {
                // Skip/delete the next node
                current.next = current.next.next;
            } else {
                max_val = current.next.data;
                current = current.next;
            }
        }
        head = reverse(head);

        return head;
    }
}
