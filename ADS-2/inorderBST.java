import java.util.ArrayList;

public class inorderBST {
    // Function to return a list containing the inorder traversal of the BST.
    ArrayList<Integer> inOrder(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        inorderHelper(root, res);
        return res;
    }

    private void inorderHelper(Node node, ArrayList<Integer> res) {
        if (node == null) {
            return;
        }
        inorderHelper(node.left, res);  
        res.add(node.data);             
        inorderHelper(node.right, res); 
    }

    // to test the inorder traversal
    public static void main(String[] args) {
        // Creating BST:
        /*
                 5
                / \
               2   7
                \    \
                 3    8
        */
        Node root = new Node(5);
        root.left = new Node(2);
        root.right = new Node(7);
        root.left.right = new Node(3);
        root.right.right = new Node(8);

        // Create an object of inorderBST
        inorderBST tree = new inorderBST();

        // Get inorder traversal
        ArrayList<Integer> result = tree.inOrder(root);

        System.out.println("Inorder Traversal:");
        for (int val : result) {
            System.out.print(val + " ");
        }
    }
}
