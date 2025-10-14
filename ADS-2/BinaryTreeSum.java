public class BinaryTreeSum {
    
    public int nodeSum(Node root, int l, int r) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        if (root.data >= l && root.data <= r) {
            sum += root.data;
        }
        if (root.data > l) {
            sum += nodeSum(root.left, l, r);
        }
        if (root.data < r) {
            sum += nodeSum(root.right, l, r);
        }
        return sum;
    }

    public static void main(String[] args) {
        // Creating a sample binary tree
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(3);
        root.left.right = new Node(7);
        root.right.left = new Node(12);
        root.right.right = new Node(18);
        
        BinaryTreeSum tree = new BinaryTreeSum();
        
        // Define the range [l, r]
        int l = 7, r = 15;
        
        // Call nodeSum method
        int sum = tree.nodeSum(root, l, r);
        
        // Print the result
        System.out.println("Sum of nodes in the range [" + l + ", " + r + "] is: " + sum);
    }
}