import java.util.Stack;

// Node definition


class BSTFromPreorder {
    // Function to build BST from preorder traversal
    public Node bstFromPreorder(int[] pre, int size) {
        if (size == 0)
            return null;

        Node root = new Node(pre[0]);
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        for (int i = 1; i < size; i++) {
            Node temp = null;

            // Find parent for current node
            while (!stack.isEmpty() && pre[i] > stack.peek().data) {
                temp = stack.pop();
            }

            if (temp != null) {
                temp.right = new Node(pre[i]);
                stack.push(temp.right);
            } else {
                stack.peek().left = new Node(pre[i]);
                stack.push(stack.peek().left);
            }
        }

        return root;
    }

    public void postOrder(Node root) {
        if (root == null)
            return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {
        int[] preorder = { 40, 30, 35, 80, 100 };
        int size = preorder.length;

        BSTFromPreorder bst = new BSTFromPreorder();
        Node root = bst.bstFromPreorder(preorder, size);

        System.out.println("Postorder Traversal of the BST:");
        bst.postOrder(root);
    }
}
