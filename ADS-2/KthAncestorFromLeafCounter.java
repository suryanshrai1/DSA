import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}

public class KthAncestorFromLeafCounter {

    int kthFromLeaf(Node root, int k) {
        Set<Node> res = new HashSet<>();
        List<Node> path = new ArrayList<>();
        findKth(root, k, path, res);
        return res.size();
    }

    private void findKth(Node node, int k, List<Node> path, Set<Node> res) {
        if (node == null) return;

        path.add(node);

        if (node.left == null && node.right == null) {
            int idx = path.size() - k - 1;
            if (idx >= 0) {
                res.add(path.get(idx));
            }
        } else {
            findKth(node.left, k, path, res);
            findKth(node.right, k, path, res);
        }

        path.remove(path.size() - 1);
    }

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

        KthAncestorFromLeafCounter counter = new KthAncestorFromLeafCounter();

        int k = 1;
        int result = counter.kthFromLeaf(root, k);
        System.out.println("Number of unique nodes that are " + k + "th from any leaf: " + result);
    }
}
