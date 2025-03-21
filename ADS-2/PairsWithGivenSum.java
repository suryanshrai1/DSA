import java.util.ArrayList;

class Node {
    int data;
    Node prev;
    Node next;

    Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class Solution {
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {
        ArrayList<ArrayList<Integer>> lst = new ArrayList<>();

        Node temp1 = head;

        // Outer loop to iterate through each node
        while (temp1 != null) {
            Node temp2 = temp1.next; // Start temp2 from the next node of temp1

            // Inner loop to find pairs
            while (temp2 != null && temp1.data+ temp2.data <= target) {
                // Check if the sum of temp1 and temp2 equals the target
                if (temp1.data + temp2.data == target) {
                    ArrayList<Integer> pair = new ArrayList<>();
                    pair.add(temp1.data);
                    pair.add(temp2.data);
                    lst.add(pair);
                }
                temp2 = temp2.next;
            }
            temp1 = temp1.next;
        }

        return lst;
    }
}

public class PairsWithGivenSum {
    public static void main(String[] args) {
        // Create a doubly linked list: 1 <-> 2 <-> 3 <-> 4 <-> 5
        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);

        // Linking nodes
        head.next = second;
        second.prev = head;
        second.next = third;
        third.prev = second;
        third.next = fourth;
        fourth.prev = third;
        fourth.next = fifth;
        fifth.prev = fourth;

        // Define the target sum
        int target = 5;

        // Call the method to find pairs
        ArrayList<ArrayList<Integer>> pairs = Solution.findPairsWithGivenSum(target, head);

        // Print the result
        System.out.println("Pairs with sum " + target + ":");
        for (ArrayList<Integer> pair : pairs) {
            System.out.println(pair);
        }
    }
}