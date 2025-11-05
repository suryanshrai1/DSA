/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class IntersectionOfLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;

        ListNode temp1 = headA;
        ListNode temp2 = headB;

        while (temp1 != temp2) {
            // move pointers forward
            temp1 = (temp1 == null) ? headB : temp1.next;
            temp2 = (temp2 == null) ? headA : temp2.next;
        }

        return temp1; // either intersection node or null
    }

    // Main method to test the intersection logic
    public static void main(String[] args) {
        // Create two linked lists:
        // A: 1 -> 2 \
        //              -> 8 -> 10
        // B:     3 -> 4 /
        
        ListNode common = new ListNode(8);
        common.next = new ListNode(10);

        // List A
        ListNode headA = new ListNode(1);
        headA.next = new ListNode(2);
        headA.next.next = common;

        // List B
        ListNode headB = new ListNode(3);
        headB.next = new ListNode(4);
        headB.next.next = common;

        // Find intersection
        IntersectionOfLinkedLists solution = new IntersectionOfLinkedLists();
        ListNode intersection = solution.getIntersectionNode(headA, headB);

        if (intersection != null)
            System.out.println("Intersection Node Value: " + intersection.val);
        else
            System.out.println("No Intersection Found");
    }
}
