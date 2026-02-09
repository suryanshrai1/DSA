import java.util.HashMap;
import java.util.Map;

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class BuildTreeFromPreorderInorder {

    int i = 0;

    TreeNode helper(int[] pre, Map<Integer, Integer> mp, int l, int r) {
        if (l > r || i >= pre.length) {
            return null;
        }

        TreeNode root = new TreeNode(pre[i]);
        int id = mp.get(pre[i]);
        i++;

        root.left = helper(pre, mp, l, id - 1);
        root.right = helper(pre, mp, id + 1, r);

        return root;
    }

    public TreeNode buildTree(int[] pre, int[] in) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            mp.put(in[i], i);
        }
        return helper(pre, mp, 0, in.length - 1);
    }

    // Inorder traversal for verification
    static void printInorder(TreeNode root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder  = {9, 3, 15, 20, 7};

        BuildTreeFromPreorderInorder builder = new BuildTreeFromPreorderInorder();
        TreeNode root = builder.buildTree(preorder, inorder);

        System.out.print("Inorder traversal of constructed tree: ");
        printInorder(root);
    }
}
