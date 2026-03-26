
import java.util.*;

public class waysToArriveDestination {
    public int countPaths(int V, int[][] edges) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int time = edge[2];
            adj.get(u).add(new int[] { v, time });
            adj.get(v).add(new int[] { u, time });
        }

        long[] dist = new long[V];
        long[] ways = new long[V];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        pq.add(new long[] { 0, 0 }); // {time, node}

        int mod = 1000000007;

        while (!pq.isEmpty()) {
            long[] current = pq.poll();
            long currentTime = current[0];
            int u = (int) current[1];

            if (currentTime > dist[u])
                continue;

            for (int[] neighbor : adj.get(u)) {
                int v = neighbor[0];
                int time = neighbor[1];

                if (dist[u] + time < dist[v]) {
                    dist[v] = dist[u] + time;
                    ways[v] = ways[u];
                    pq.add(new long[] { dist[v], v });
                } else if (dist[u] + time == dist[v]) {
                    ways[v] = (ways[v] + ways[u]) % mod;
                }
            }
        }

        return (int) ways[V - 1];
    }
}