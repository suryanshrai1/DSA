import java.util.*;

public class courseSchedule {
    public boolean canFinish(int n, int[][] prerequisites) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[n];

        // build graph
        for (int[] it : prerequisites) {
            int u = it[0];
            int v = it[1];

            adj.get(v).add(u); // v → u
            indegree[u]++;
        }

        Queue<Integer> q = new LinkedList<>();

        // push nodes with indegree 0
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }

        int cnt = 0;

        while (!q.isEmpty()) {
            int node = q.poll();
            cnt++;
            for (int adjNode : adj.get(node)) {
                indegree[adjNode]--;
                if (indegree[adjNode] == 0) {
                    q.add(adjNode);
                }
            }
        }
        return cnt == n;
    }
}