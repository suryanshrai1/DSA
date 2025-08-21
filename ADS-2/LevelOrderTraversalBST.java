import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int value) {
        data = value;
        left = right = null;
    }
}

public class LevelOrderTraversalBST {
    
    // Function to return the level order traversal of a BST.
    static ArrayList<Integer> levelOrder(Node node) {
        ArrayList<Integer> res = new ArrayList<>();
        if (node == null) return res;

        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        
        while (!q.isEmpty()) {
            Node curr = q.poll();
            res.add(curr.data);
            if (curr.left != null) {
                q.offer(curr.left);
            }
            if (curr.right != null) {
                q.offer(curr.right);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        /*
            Constructing the following BST:
                     10
                    /  \
                   5   15
                  / \    \
                 3   7    20
        */
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(3);
        root.left.right = new Node(7);
        root.right.right = new Node(20);

        ArrayList<Integer> result = levelOrder(root);
        System.out.println("Level Order Traversal:");
        for (int val : result) {
            System.out.print(val + " ");
        }
    }
}
