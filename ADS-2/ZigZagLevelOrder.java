
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int length = 0;
        boolean bool = false;
        while (!queue.isEmpty()) {
            length = queue.size();
            List<Integer> sub = new ArrayList<>(length);
            for (int i = 0; i < length; i++) {
                TreeNode top = queue.poll();
                sub.add(top.val);
                if (top.left != null) {
                    queue.offer(top.left);
                }
                if (top.right != null) {
                    queue.offer(top.right);
                }
            }
            if (bool) {
                Collections.reverse(sub);
            }
            result.add(sub);
            bool = !bool;
        }
        return result;
    }
}

public class ZigZagLevelOrder{
    public static void main(String[] args) {
        // Create a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        // Create an instance of Solution and call zigzagLevelOrder
        Solution solution = new Solution();
        List<List<Integer>> result = solution.zigzagLevelOrder(root);

        // Print the result
        System.out.println(result);
    }
}
