class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

public class insertNodeInBST {
    // Function to insert a node in a BST.
    Node insert(Node root, int Key) {
        if (root == null) {
            return new Node(Key);
        } else if (Key < root.data) {
            root.left = insert(root.left, Key);
        } else if (Key > root.data) {
            root.right = insert(root.right, Key);
        }
        return root; // if key already exists
    }

    // Helper function to do inorder traversal of the tree
    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    public static void main(String[] args) {
        insertNodeInBST bst = new insertNodeInBST();
        Node root = null;

        // Insert nodes into BST
        int[] keys = {50, 30, 20, 40, 70, 60, 80};
        for (int key : keys) {
            root = bst.insert(root, key);
        }

        // Print inorder traversal of the BST
        System.out.println("Inorder traversal of the BST:");
        bst.inorder(root);
    }
}
