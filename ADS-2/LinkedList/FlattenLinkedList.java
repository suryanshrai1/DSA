class Node {
    int data;
    Node next;
    Node bottom;

    Node(int x) {
        data = x;
        next = null;
        bottom = null;
    }
}

public class FlattenLinkedList {

    // Merge two sorted lists using bottom pointer
    private static Node merge(Node a, Node b) {
        if (a == null) return b;
        if (b == null) return a;

        Node result;

        if (a.data < b.data) {
            result = a;
            result.bottom = merge(a.bottom, b);
        } else {
            result = b;
            result.bottom = merge(a, b.bottom);
        }

        result.next = null; // next pointer not used
        return result;
    }

    // Flatten the linked list
    public static Node flatten(Node root) {
        if (root == null || root.next == null)
            return root;

        root.next = flatten(root.next);
        root = merge(root, root.next);

        return root;
    }

    // Print flattened list using bottom pointer
    private static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.bottom;
        }
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {

        /*
           Creating the following linked list:
           5 -> 10 -> 19 -> 28
           |    |     |     |
           7    20    22    40
           |          |     |
           8          50    45
        */

        Node head = new Node(5);
        head.bottom = new Node(7);
        head.bottom.bottom = new Node(8);

        head.next = new Node(10);
        head.next.bottom = new Node(20);

        head.next.next = new Node(19);
        head.next.next.bottom = new Node(22);
        head.next.next.bottom.bottom = new Node(50);

        head.next.next.next = new Node(28);
        head.next.next.next.bottom = new Node(40);
        head.next.next.next.bottom.bottom = new Node(45);

        Node flattenedHead = flatten(head);

        System.out.println("Flattened linked list:");
        printList(flattenedHead);
    }
}
