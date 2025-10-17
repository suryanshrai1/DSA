public class BinaryTreeTransformer {
    private int sum = 0;

    // Transforms the tree
    public void transformTree(Node root) {
        reverseInOrder(root);
    }

    // Reverse in-order traversal (right -> node -> left)
    private void reverseInOrder(Node node) {
        if (node == null) {
            return;
        }

        reverseInOrder(node.right);

        int originalData = node.data;
        node.data = sum;
        sum += originalData;

        reverseInOrder(node.left);
    }

    // In-order traversal to print tree nodes
    public void printInOrder(Node node) {
        if (node == null) return;

        printInOrder(node.left);
        System.out.print(node.data + " ");
        printInOrder(node.right);
    }

    // Main method to test the transformation
    public static void main(String[] args) {
        /*
              5
             / \
            3   7
           / \   \
          2   4   8
        */

        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(7);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right.right = new Node(8);

        BinaryTreeTransformer transformer = new BinaryTreeTransformer();

        System.out.println("Original In-order:");
        transformer.printInOrder(root);
        System.out.println();

        transformer.transformTree(root);

        System.out.println("Transformed In-order:");
        transformer.printInOrder(root);
        System.out.println();
    }
}