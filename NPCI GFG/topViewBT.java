import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}

public class topViewBT {
        public ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        // TreeMap will keep keys sorted
        Map<Integer, Integer> map = new TreeMap<>();

        // Queue stores pairs of (node, horizontal distance)
        Queue<AbstractMap.SimpleEntry<Node, Integer>> q = new LinkedList<>();
        q.add(new AbstractMap.SimpleEntry<>(root, 0));

        while (!q.isEmpty()) {
            AbstractMap.SimpleEntry<Node, Integer> current = q.poll();
            Node currentNode = current.getKey();
            int hd = current.getValue();

            // Only add the first node at each horizontal distance
            if (!map.containsKey(hd)) {
                map.put(hd, currentNode.data);
            }

            if (currentNode.left != null) {
                q.add(new AbstractMap.SimpleEntry<>(currentNode.left, hd - 1));
            }
            if (currentNode.right != null) {
                q.add(new AbstractMap.SimpleEntry<>(currentNode.right, hd + 1));
            }
        }

        // Add nodes to result from leftmost to rightmost
        for (int value : map.values()) {
            res.add(value);
        }

        return res;
    }

    // For testing
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        topViewBT sol = new topViewBT();
        System.out.println(sol.topView(root));  // Output: [2, 1, 3]
    }
}
