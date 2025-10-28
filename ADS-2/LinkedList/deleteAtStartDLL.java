class Node {
    int data;
    Node next, prev;

    Node(int newData) {
        data = newData;
        next = prev = null;
    }
}

public class deleteAtStartDLL {
    public static Node delHead(Node head){
        if(head == null){
            return null;
        }

        head = head.next;
        if(head.next != null){
            head.prev = null;
        }
        return head;
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

        // Create a hardcoded doubly linked list:
        // 1 <-> 2 <-> 3
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.prev = head;
        head.next.next = new Node(3);
        head.next.next.prev = head.next;

        System.out.print("Original Linked List: ");
        printList(head);

        System.out.print("After Deletion at the beginning: ");
        head = delHead(head);

        printList(head);
    }
}