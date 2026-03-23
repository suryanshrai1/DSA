import java.util.HashMap;
import java.util.Map;

public class longestCycleInGraph {
        public int longestCycle(int V, int[][] edges) {
        int[] edge = new int[V];
        for (int i = 0; i < V; i++) edge[i] = -1;
        
        // Convert edges[][] into single outgoing edge array
        for (int[] e : edges) {
            edge[e[0]] = e[1];
        }
        
        boolean[] visited = new boolean[V];
        int[] timeVisited = new int[V];
        
        int timer = 1;
        int maxCycle = -1;

        for (int i = 0; i < V; i++) {
            if (visited[i]) continue;

            int curr = i;
            Map<Integer, Integer> map = new HashMap<>();

            while (curr != -1 && !visited[curr]) {
                visited[curr] = true;
                map.put(curr, timer++);
                curr = edge[curr];
            }

            // Check if cycle exists
            if (curr != -1 && map.containsKey(curr)) {
                int cycleLength = timer - map.get(curr);
                maxCycle = Math.max(maxCycle, cycleLength);
            }
        }
        return maxCycle;
    }
}
