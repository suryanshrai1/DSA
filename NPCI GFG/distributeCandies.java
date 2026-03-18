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

public class distributeCandies {
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
}