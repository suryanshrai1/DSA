// TreeNode class to represent each node in the binary tree
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    // Constructor to create a new node
    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class MaximumPathSum {  // Rename the class to MaxPathSum

    public int maxPathSum(TreeNode root) {
        int[] maxSum = new int[1];  // To store the global maximum path sum
        maxSum[0] = Integer.MIN_VALUE;  // Initialize the maxSum with the lowest possible value
        maxPathDown(root, maxSum);  // Helper method to calculate the path sum
        return maxSum[0];  // Return the global maximum sum
    }

    private int maxPathDown(TreeNode node, int maxSum[]) {
        if (node == null)  // If node is null, return 0
            return 0;

        // Get the maximum sum of the left and right subtrees, but we discard negative values
        int left = Math.max(0, maxPathDown(node.left, maxSum));
        int right = Math.max(0, maxPathDown(node.right, maxSum));

        // Update the global maximum path sum with the sum of the current node and its left and right subtrees
        maxSum[0] = Math.max(maxSum[0], left + right + node.val);

        // Return the maximum path sum that can be extended to the parent node
        return Math.max(left, right) + node.val;
    }

    public static void main(String[] args) {
        // Construct a binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        // Create a MaxPathSum object and find the maximum path sum
        MaxPathSum solution = new MaxPathSum();  // Change to MaxPathSum
        int result = solution.maxPathSum(root);

        // Print the result
        System.out.println("Maximum Path Sum: " + result);  // Output should be the maximum sum
    }
}
