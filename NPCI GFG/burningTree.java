/*
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
*/

import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;

public class burningTree {
    public int minTime(Node root, int target) {
        HashMap<Node, Node> parentMap = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node targetNode = null;

        while (!q.isEmpty()) {
            Node current = q.poll();
            if (current.data == target) {
                targetNode = current;
            }
            if (current.left != null) {
                parentMap.put(current.left, current);
                q.add(current.left);
            }
            if (current.right != null) {
                parentMap.put(current.right, current);
                q.add(current.right);
            }
        }

        Queue<Node> burnQueue = new LinkedList<>();
        burnQueue.add(targetNode);
        HashSet<Node> visited = new HashSet<>();
        visited.add(targetNode);
        int time = 0;

        while (!burnQueue.isEmpty()) {
            int size = burnQueue.size();
            boolean burned = false;
            for (int i = 0; i < size; i++) {
                Node current = burnQueue.poll();
                if (current.left != null && !visited.contains(current.left)) {
                    visited.add(current.left);
                    burnQueue.add(current.left);
                    burned = true;
                }
                if (current.right != null && !visited.contains(current.right)) {
                    visited.add(current.right);
                    burnQueue.add(current.right);
                    burned = true;
                }
                if (parentMap.containsKey(current) && !visited.contains(parentMap.get(current))) {
                    visited.add(parentMap.get(current));
                    burnQueue.add(parentMap.get(current));
                    burned = true;
                }
            }
            if (burned) {
                time++;
            }
        }
        return time;
    }
}