import java.util.*;

public class MinimumCostPath {

    public static int minCost(int n, int[][] edges) {
        List<List<int[]>> adj = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int[] dist = new int[n];

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
            dist[i] = Integer.MAX_VALUE;
        }

        // Build graph
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w * 2});
        }

        // Dijkstra
        dist[0] = 0;
        pq.offer(new int[]{0, 0}); // {distance, node}

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int d = curr[0], node = curr[1];

            if (d > dist[node]) continue;

            for (int[] neigh : adj.get(node)) {
                int nei = neigh[0], w = neigh[1];
                if (dist[nei] > d + w) {
                    dist[nei] = d + w;
                    pq.offer(new int[]{dist[nei], nei});
                }
            }
        }

        return dist[n - 1] == Integer.MAX_VALUE ? -1 : dist[n - 1];
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] edges = {
            {0, 1, 1},
            {1, 2, 3},
            {2, 3, 1},
            {0, 3, 10}
        };

        int result = minCost(n, edges);
        System.out.println("Minimum cost from node 0 to node " + (n - 1) + ": " + result);
    }
}
