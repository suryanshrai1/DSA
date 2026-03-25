
import java.util.*;

public class minHeightRoots {
    public ArrayList<Integer> minHeightRoot(int V, int[][] edges) {
        if (V == 0) return new ArrayList<>();
        if (V == 1) {
            ArrayList<Integer> result = new ArrayList<>();
            result.add(0);
            return result;
        }

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        int[] degree = new int[V];

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
            degree[u]++;
            degree[v]++;
        }

        Queue<Integer> leaves = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (degree[i] == 1) {
                leaves.add(i);
            }
        }

        int remainingNodes = V;
        while (remainingNodes > 2) {
            int leavesCount = leaves.size();
            remainingNodes -= leavesCount;
            for (int i = 0; i < leavesCount; i++) {
                int leaf = leaves.poll();
                for (int neighbor : adj.get(leaf)) {
                    degree[neighbor]--;
                    if (degree[neighbor] == 1) {
                        leaves.add(neighbor);
                    }
                }
            }
        }
        return new ArrayList<>(leaves);
    }
}