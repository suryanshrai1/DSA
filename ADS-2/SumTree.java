public class SumTree {
    /*
     * Structure for Tree Node
     * class Node {
     * int data;
     * Node left, right;
     * 
     * // Constructor
     * Node(int val) {
     * data = val;
     * left = null;
     * right = null;
     * }
     * };
     */
    /*
     * Structure for Tree Node
     * class Node {
     * int data;
     * Node left, right;
     * 
     * // Constructor
     * Node(int val) {
     * data = val;
     * left = null;
     * right = null;
     * }
     * };
     */
    public void toSumTree(Node root) {
        transform(root);
    }

    private int transform(Node node) {
        // Base case: empty node contributes 0 to the sum
        if (node == null) {
            return 0;
        }

        int oldVal = node.data;

        int leftSum = transform(node.left);
        int rightSum = transform(node.right);

        node.data = leftSum + rightSum;

        return node.data + oldVal;
    }
}
