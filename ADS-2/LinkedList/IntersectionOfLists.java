class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class IntersectionOfLists {
    public Node intersectPoint(Node head1, Node head2) {
        Node p1 = head1;
        Node p2 = head2;

        while (p1 != p2) {
            if (p1 == null) {
                p1 = head2;
            } else {
                p1 = p1.next;
            }

            if (p2 == null) {
                p2 = head1;
            } else {
                p2 = p2.next;
            }
        }
        return p1;
    }

    public static void main(String[] args) {
        // Creating the first linked list
        Node head1 = new Node(10);
        head1.next = new Node(20);
        head1.next.next = new Node(30);

        // Creating the second linked list
        Node head2 = new Node(15);
        head2.next = new Node(25);

        // Creating the intersection point
        Node intersect = new Node(35);
        head1.next.next.next = intersect; // Add intersection
        head2.next.next = intersect; // Add intersection

        // Continue the intersection list
        intersect.next = new Node(40);

        // Finding intersection point
        IntersectionOfLists solution = new IntersectionOfLists();
        Node result = solution.intersectPoint(head1, head2);

        // Printing the intersection node's data if there is an intersection
        if (result != null) {
            System.out.println("The intersection point is at node with data: " + result.data);
        } else {
            System.out.println("There is no intersection point.");
        }
    }
}
