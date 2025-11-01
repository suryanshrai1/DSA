import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class DeleteNodesFromLinkedListPresentInArray {
    public static ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        // Remove nodes from the start if their values are in the set
        while (head != null && set.contains(head.val)) {
            head = head.next;
        }

        ListNode curr = head;
        while (curr != null && curr.next != null) {
            if (set.contains(curr.next.val)) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }

    // Helper method to create a linked list from an array
    public static ListNode createList(int[] arr) {
        if (arr.length == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode curr = head;
        for (int i = 1; i < arr.length; i++) {
            curr.next = new ListNode(arr[i]);
            curr = curr.next;
        }
        return head;
    }

    // Helper method to print a linked list
    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + (curr.next != null ? " -> " : ""));
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int[] listValues = {1, 2, 3, 4, 5};

        ListNode head = createList(listValues);

        System.out.println("Original list:");
        printList(head);

        head = modifiedList(nums, head);

        System.out.println("Modified list:");
        printList(head);
    }
}
