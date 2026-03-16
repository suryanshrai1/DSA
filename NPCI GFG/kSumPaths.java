
// class Node {
//     int data;
//     Node left;
//     Node right;

//     Node(int data) {
//         this.data = data;
//         left = null;
//         right = null;
//     }
// }

class kSumPaths {
    public int countAllPaths(Node root, int k) {
        if (root == null) {
            return 0;
        }
        int paths = countPathsFromNode(root, k, 0);
        paths += countAllPaths(root.left, k);
        paths += countAllPaths(root.right, k);
        return paths;
    }

    private int countPathsFromNode(Node node, int k, long currentSum) {
        if (node == null) {
            return 0;
        }
        currentSum += node.data;
        int count = 0;
        if (currentSum == k) {
            count++;
        }
        count += countPathsFromNode(node.left, k, currentSum);
        count += countPathsFromNode(node.right, k, currentSum);
        return count;
    }
}