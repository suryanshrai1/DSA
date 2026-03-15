import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class BTverticalTraversal {
    static class Pair {
        Node node;
        int hd;

        Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }
    
    public ArrayList<ArrayList<Integer>> verticalOrder(Node root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        // Map to store nodes at each horizontal distance, sorted by HD
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        // Queue for BFS, storing Node and its HD
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair current = q.poll();
            Node currentNode = current.node;
            int currentHd = current.hd;

            // Add the current node's data to the list for its horizontal distance
            if (!map.containsKey(currentHd)) {
                map.put(currentHd, new ArrayList<>());
            }
            map.get(currentHd).add(currentNode.data);

            // Process left child: HD-1
            if (currentNode.left != null) {
                q.add(new Pair(currentNode.left, currentHd - 1));
            }

            // Process right child: HD+1
            if (currentNode.right != null) {
                q.add(new Pair(currentNode.right, currentHd + 1));
            }
        }

        // Extract the values from the TreeMap in sorted order of HD
        for (ArrayList<Integer> list : map.values()) {
            result.add(list);
        }
        return result;
    }
}