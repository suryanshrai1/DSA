import java.util.ArrayList;
import java.util.TreeMap;

public class verticalSumFind {

    // Function to return a list containing the vertical sum of the tree.
    public ArrayList<Integer> verticalSum(Node root) {

        TreeMap<Integer, Integer> map = new TreeMap<>();
        ArrayList<Integer> result = new ArrayList<>();

        calculateSum(root, 0, map);

        for (int sum : map.values()) {
            result.add(sum);
        }

        return result;
    }

    // Helper function
    private void calculateSum(Node node, int hd, TreeMap<Integer, Integer> map) {

        if (node == null) {
            return;
        }

        // Add current node data to its horizontal distance
        map.put(hd, map.getOrDefault(hd, 0) + node.data);

        // Traverse left and right subtree
        calculateSum(node.left, hd - 1, map);
        calculateSum(node.right, hd + 1, map);
    }
}