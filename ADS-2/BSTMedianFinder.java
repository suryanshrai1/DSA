import java.util.*;

class BSTMedianFinder {

    // Helper function for in-order traversal
    private void inorder(Node root, List<Integer> inorderList) {
        if (root == null) {
            return;
        }
        inorder(root.left, inorderList);  // Traverse left subtree
        inorderList.add(root.data);        // Add current node's value
        inorder(root.right, inorderList); // Traverse right subtree
    }

    public int findMedian(Node root) {
        List<Integer> inorderList = new ArrayList<>();
        
        // Step 1: Perform in-order traversal and store the values
        inorder(root, inorderList);

        int n = inorderList.size();
        
        // Step 2: Check if number of nodes is odd or even
        if (n % 2 == 1) {
            // Odd number of nodes, return the middle element
            return inorderList.get(n / 2);  // Middle element (0-based index)
        } else {
            // Even number of nodes, return the (n/2)-th element
            return inorderList.get(n / 2 - 1);  // (n/2)-th element (0-based index)
        }
    }

    // Driver function to test the solution
    public static void main(String[] args) {
        // Creating a simple binary search tree
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);

        // Creating an instance of the BSTMedianFinder class
        BSTMedianFinder finder = new BSTMedianFinder();
        
        // Finding the median
        int median = finder.findMedian(root);
        
        // Output the result
        System.out.println("Median of the BST: " + median);  // Expected Output: 12
    }
}


