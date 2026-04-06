import java.util.*;

class Node implements Comparable<Node> {
    int freq;
    int index; // smallest original index in subtree
    Node left, right;

    // Leaf node
    Node(int freq, int index) {
        this.freq = freq;
        this.index = index;
        this.left = this.right = null;
    }

    // Internal node
    Node(Node l, Node r) {
        this.freq = l.freq + r.freq;
        this.index = Math.min(l.index, r.index); // IMPORTANT
        this.left = l;
        this.right = r;
    }

    public int compareTo(Node other) {
        if (this.freq != other.freq)
            return this.freq - other.freq;
        return this.index - other.index; // tie-break
    }
}

public class huffmanEncoding {

    public ArrayList<String> huffmanCodes(String s, int f[]) {
        int n = s.length();

        PriorityQueue<Node> pq = new PriorityQueue<>();

        // create leaf nodes
        for (int i = 0; i < n; i++) {
            pq.add(new Node(f[i], i));
        }

        // single character case
        if (n == 1) {
            ArrayList<String> res = new ArrayList<>();
            res.add("0");
            return res;
        }

        //build tree
        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();

            Node parent = new Node(left, right);
            pq.add(parent);
        }

        Node root = pq.poll();

        //preorder traversal
        ArrayList<String> result = new ArrayList<>();
        generate(root, "", result);

        return result;
    }

    private void generate(Node node, String code, ArrayList<String> res) {
        if (node == null) return;

        // leaf node
        if (node.left == null && node.right == null) {
            if (code.length() == 0) code = "0";
            res.add(code);
            return;
        }

        generate(node.left, code + "0", res);
        generate(node.right, code + "1", res);
    }
}