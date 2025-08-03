public class HeightOfBinaryTree {
    Node root;

    // A binary tree node as an inner static class
    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    int maxDepth(Node node) {
        if (node == null)
            return 0;

        int lDepth = maxDepth(node.left);
        int rDepth = maxDepth(node.right);

        return Math.max(lDepth, rDepth) + 1;
    }

    public static void main(String[] args) {
        HeightOfBinaryTree tree = new HeightOfBinaryTree();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("Height of tree is " + tree.maxDepth(tree.root));
    }
}
