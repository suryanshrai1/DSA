class PalindromeLinkedList {
    
    // Definition for a singly linked list node
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public boolean isPalindrome(Node head) {
        if (head == null || head.next == null) {
            return true;
        }

        // Find the middle of the linked list
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half
        Node secondHalfHead = reverseList(slow.next);
        Node firstHalfHead = head;

        // Compare the two halves
        Node tempSecond = secondHalfHead;
        boolean isPalindrome = true;
        while (tempSecond != null) {
            if (firstHalfHead.data != tempSecond.data) {
                isPalindrome = false;
                break;
            }
            firstHalfHead = firstHalfHead.next;
            tempSecond = tempSecond.next;
        }

        // Restore the list (optional)
        reverseList(secondHalfHead);

        return isPalindrome;
    }

    private Node reverseList(Node head) {
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

    // Main method to test the solution
    public static void main(String[] args) {
        PalindromeLinkedList solution = new PalindromeLinkedList();
        
        // Example to test the solution
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);

        boolean result = solution.isPalindrome(head);
        System.out.println("Is the linked list palindrome? " + result);
        
        // Another test case (should return false)
        Node head2 = new Node(1);
        head2.next = new Node(2);
        head2.next.next = new Node(3);

        boolean result2 = solution.isPalindrome(head2);
        System.out.println("Is the linked list palindrome? " + result2);
    }
}
