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

public class CandyDistributor {
    int totalMoves = 0;

    public int distCandy(Node root) {
        dfs(root);
        return totalMoves;
    }

    private int dfs(Node node) {
        if (node == null) {
            return 0;
        }

        int leftFlow = dfs(node.left);
        int rightFlow = dfs(node.right);

        totalMoves += Math.abs(leftFlow) + Math.abs(rightFlow);

        return node.data + leftFlow + rightFlow - 1;
    }

    public static void main(String[] args) {
        /*
         * Example Tree:
         * 3
         * / \
         * 0 0
         * This tree has 3 candies at root, and 0 at each child.
         * The goal is to make every node have exactly 1 candy.
         * Expected output: 2 moves
         */

        Node root = new Node(3);
        root.left = new Node(0);
        root.right = new Node(0);

        CandyDistributor distributor = new CandyDistributor();
        int moves = distributor.distCandy(root);

        System.out.println("Minimum number of moves required: " + moves);
    }
}
