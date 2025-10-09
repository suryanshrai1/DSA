import java.util.ArrayList;

class TreeNode {
    int data;
    TreeNode left, right;

    TreeNode(int val) {
        data = val;
        left = right = null;
    }
}

public class BinaryTreePostOrderTraversal {

    public ArrayList<Integer> postOrder(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        postOrderTraversal(root, result);
        return result;
    }

    private void postOrderTraversal(TreeNode node, ArrayList<Integer> result) {
        if (node == null) {
            return;
        }

        postOrderTraversal(node.left, result);

        postOrderTraversal(node.right, result);

        result.add(node.data);
    }

    public static void main(String[] args) {
        // Create the tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        // Create the solution object and get the post-order traversal
        BinaryTreePostOrderTraversal solution = new BinaryTreePostOrderTraversal();
        ArrayList<Integer> postOrderResult = solution.postOrder(root);

        // Print the result
        System.out.println(postOrderResult);
    }
}
