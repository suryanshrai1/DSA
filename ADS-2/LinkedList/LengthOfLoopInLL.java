public class LengthOfLoopInLL {

    static class Node {
        int val;
        Node next;

        Node(int data) {
            val = data;
            next = null;
        }
    }

    // Optional traversal function (won't work correctly for looped lists)
    static void traversal(Node head) {
        Node temp = head;
        int count = 0; // prevent infinite loop for demonstration
        while (temp != null && count < 20) {
            System.out.print(temp.val + "->");
            temp = temp.next;
            count++;
        }
        System.out.println();
    }

    // Function to find length of loop
    static int lenLoop(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                while(slow != fast){
                    
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        Node temp = head.next.next;
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = temp; // creating a loop

        System.out.println(lenLoop(head)); // Output: 3
    }
}
