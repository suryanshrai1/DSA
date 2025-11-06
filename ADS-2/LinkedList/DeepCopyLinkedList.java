import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class DeepCopyLinkedList {
    
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        
        Map<Node, Node> mapping = new HashMap<>();
        
        // Step 1: Create all nodes
        Node curr = head;
        while (curr != null) {
            mapping.put(curr, new Node(curr.val));
            curr = curr.next;
        }
        
        // Step 2: Assign pointers
        curr = head;
        while (curr != null) {
            mapping.get(curr).next = mapping.get(curr.next);
            mapping.get(curr).random = mapping.get(curr.random);
            curr = curr.next;
        }
        
        return mapping.get(head);
    }

    // Helper method to print the list (for debugging)
    public void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            int randomVal = (curr.random != null) ? curr.random.val : -1;
            System.out.println("Node val: " + curr.val + ", Random points to: " + randomVal);
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        // Create test case
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);

        n1.next = n2;
        n2.next = n3;

        n1.random = n3;
        n2.random = n1;
        n3.random = n2;

        DeepCopyLinkedList solution = new DeepCopyLinkedList();
        
        System.out.println("Original list:");
        solution.printList(n1);

        Node copiedHead = solution.copyRandomList(n1);

        System.out.println("\nCopied list:");
        solution.printList(copiedHead);
    }
}
