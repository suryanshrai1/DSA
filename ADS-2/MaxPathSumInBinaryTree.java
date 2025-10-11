// class Node {
//     int data;
//     Node left, right;

//     Node(int d) {
//         data = d;
//         left = right = null;
//     }
// }

public class MaxPathSumInBinaryTree {
    int maxSum = Integer.MIN_VALUE;

    public int findMaxSum(Node root) {
        maxPathSum(root);
        return maxSum;
    }

    private int maxPathSum(Node node) {
        if (node == null) {
            return 0;
        }

        int leftSum = Math.max(0, maxPathSum(node.left));
        int rightSum = Math.max(0, maxPathSum(node.right));

        maxSum = Math.max(maxSum, node.data + leftSum + rightSum);

        return node.data + Math.max(leftSum, rightSum);
    }

    // Main method for testing
    public static void main(String[] args) {
        /*
                Sample Tree:
                      10
                     /  \
                    2    10
                   / \     \
                  20  1     -25
                             /  \
                            3    4
        Expected max path sum = 42 (20 + 2 + 10 + 10)
        */

        Node root = new Node(10);
        root.left = new Node(2);
        root.right = new Node(10);
        root.left.left = new Node(20);
        root.left.right = new Node(1);
        root.right.right = new Node(-25);
        root.right.right.left = new Node(3);
        root.right.right.right = new Node(4);

        MaxPathSumInBinaryTree solution = new MaxPathSumInBinaryTree();
        int result = solution.findMaxSum(root);
        System.out.println("Maximum path sum: " + result);
    }
}
