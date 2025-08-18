public class deleteFromBST {

    // Node structure
    static class Node {
        int data;
        Node left, right;
        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    // Function to insert nodes into BST
    static Node insert(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }
        if (key < root.data) {
            root.left = insert(root.left, key);
        } else if (key > root.data) {
            root.right = insert(root.right, key);
        }
        return root;
    }

    // Inorder traversal to print the BST
    static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    // Function to delete a node from BST
    public static Node deleteNode(Node root, int X) {
        if (root == null) {
            return null;
        }
        if (X < root.data) {
            root.left = deleteNode(root.left, X);
        } else if (X > root.data) {
            root.right = deleteNode(root.right, X);
        } else {
            // Node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Node with two children: Get inorder successor
            Node succ = minValNode(root.right);
            root.data = succ.data;
            root.right = deleteNode(root.right, succ.data);
        }
        return root;
    }

    // Helper to find the node with the minimum value (inorder successor)
    static Node minValNode(Node node) {
        Node curr = node;
        while (curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }

    public static void main(String[] args) {
        /*
            Input BST:
                  5
                 / \
                3   8
               / \   \
              2   4   10
        */

        Node root = null;
        int[] values = {5, 3, 8, 2, 4, 10};
        for (int val : values) {
            root = insert(root, val);
        }

        System.out.print("Inorder before deletion: ");
        inorder(root);
        System.out.println();

        int x = 12; // to test different deletions
        root = deleteNode(root, x);

        System.out.print("Inorder after deletion of " + x + ": ");
        inorder(root);
        System.out.println();
    }
}
