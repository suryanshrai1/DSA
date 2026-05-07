
//Definition for Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int x) {
        data = x;
        left = right = null;
    }
}

public class checkIfSubtree {
    public boolean isSubTree(Node root1, Node root2) {
        // code here
        if (root2 == null)
            return true;// null is subtree of all
        if (root1 == null)
            return false;// if main null but sencond not
        if (isIdentical(root1, root2)) {
            return true;
        }
        return isSubTree(root1.left, root2) || isSubTree(root1.right, root2);
    }

    // helper
    private boolean isIdentical(Node x, Node y) {
        if (x == null && y == null) {
            return true;
        }
        if (x == null || y == null) {
            return false;
        }
        return (x.data == y.data) && isIdentical(x.left, y.left)
                && isIdentical(x.right, y.right);
    }
}