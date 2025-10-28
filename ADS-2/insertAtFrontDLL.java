class Node {
    int data;
    Node next, prev;

    Node(int newData) {
        data = newData;
        next = prev = null;
    }
}

public class insertAtFrontDLL {
    public static Node insertAtFront(Node head, int newData) {
        Node newNode = new Node(newData);

        newNode.next = head;

        if (head != null) {
            head.prev = newNode;
        }
        return newNode;
    }

    public static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // a hardcoded doubly linked list:
        // 2 <-> 3 <-> 4 -> NULL
        Node head = new Node(2);
        head.next = new Node(3);
        head.next.prev = head;
        head.next.next = new Node(4);
        head.next.next.prev = head.next;

        System.out.println("Original Linked List: ");
        printList(head);

        // Insert a new node at the front of the list
        System.out.println(
                "After inserting Node at the front: ");
        int data = 1;
        head = insertAtFront(head, data);

        // Print the updated list
        printList(head);
    }
}
