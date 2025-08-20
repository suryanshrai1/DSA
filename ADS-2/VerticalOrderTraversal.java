import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}

class VerticalOrderTraversal {

    // Helper class to pair a Node with its horizontal distance
    static class Pair {
        Node node;
        int hd;

        Pair(Node n, int h) {
            node = n;
            hd = h;
        }
    }

    // Main logic for vertical order traversal
    static ArrayList<ArrayList<Integer>> verticalOrder(Node root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair curr = queue.poll();
            Node node = curr.node;
            int hd = curr.hd;

            map.computeIfAbsent(hd, k -> new ArrayList<>()).add(node.data);

            if (node.left != null) queue.offer(new Pair(node.left, hd - 1));
            if (node.right != null) queue.offer(new Pair(node.right, hd + 1));
        }

        for (ArrayList<Integer> level : map.values()) {
            result.add(level);
        }

        return result;
    }

    // Build tree from level-order input (with "N" as null)
    static Node buildTree(String[] input) {
        if (input.length == 0 || input[0].equals("N")) return null;

        Node root = new Node(Integer.parseInt(input[0]));
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;

        while (!queue.isEmpty() && i < input.length) {
            Node current = queue.poll();

            // Left child
            if (!input[i].equals("N")) {
                current.left = new Node(Integer.parseInt(input[i]));
                queue.offer(current.left);
            }
            i++;
            if (i >= input.length) break;

            // Right child
            if (!input[i].equals("N")) {
                current.right = new Node(Integer.parseInt(input[i]));
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

    // Main method to test the code
    public static void main(String[] args) {
        // Example input
        String[] input = {"1", "2", "3", "4", "5", "6", "7", "N", "N", "N", "N", "N", "8", "N", "9"};

        Node root = buildTree(input);

        ArrayList<ArrayList<Integer>> result = verticalOrder(root);

        // Print the result
        for (ArrayList<Integer> level : result) {
            System.out.println(level);
        }
    }
}
