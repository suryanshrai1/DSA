import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class motherVertex {

    private void dfs(int node, List<List<Integer>> adj, boolean[] vis) {
        vis[node] = true;
        for (int no : adj.get(node)) {
            if (!vis[no]) {
                dfs(no, adj, vis);
            }
        }
    }

    public int findMotherVertex(int V, int[][] edges) {

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
        }

        boolean[] vis = new boolean[V];
        int candidate = 0;

        // Find candidate
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(i, adj, vis);
                candidate = i;
            }
        }

        // Verify
        Arrays.fill(vis, false);
        dfs(candidate, adj, vis);

        for (boolean x : vis) {
            if (!x) {
                return -1;
            }
        }
        return candidate;
    }
}
