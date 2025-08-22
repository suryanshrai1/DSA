class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class BSTFromLevelOrder {

    // Function to construct the BST from its given level order traversal.
    public Node constructBST(int[] arr) {
        Node root = null;
        for (int val : arr) {
            root = insert(root, val);
        }
        return root;
    }

    private Node insert(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }
        if (key < root.data) {
            root.left = insert(root.left, key);
        } else {
            root.right = insert(root.right, key);
        }
        return root;
    }

    // Function to print preorder traversal of BST
    public void preorderTraversal(Node root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    // Main method to test the code
    public static void main(String[] args) {
        BSTFromLevelOrder bstBuilder = new BSTFromLevelOrder();

        int[] arr = {7, 4, 12, 3, 6, 8, 1, 5, 10};
        Node root = bstBuilder.constructBST(arr);

        System.out.println("Preorder traversal of constructed BST:");
        bstBuilder.preorderTraversal(root);
    }
}
