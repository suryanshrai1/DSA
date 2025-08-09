import java.util.*;

// Definition for a binary tree node.
class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

public class BinaryTreeLevelOrderTraversal {

    public ArrayList<ArrayList<Integer>> levelOrder(Node root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int levelSize = q.size();
            ArrayList<Integer> currLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                Node curr = q.poll();
                currLevel.add(curr.data);
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }

            res.add(currLevel);
        }

        return res;
    }

    // Main method to test the level order traversal
    public static void main(String[] args) {
        /*
              1
             / \
            2   3
           / \   \
          4   5   6
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        BinaryTreeLevelOrderTraversal tree = new BinaryTreeLevelOrderTraversal();
        ArrayList<ArrayList<Integer>> result = tree.levelOrder(root);

        System.out.println("Level order traversal:");
        for (ArrayList<Integer> level : result) {
            System.out.println(level);
        }
    }
}
