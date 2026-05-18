import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;

public class jumpGameIV {
    public int minJumps(int[] arr) {

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        boolean vis[] = new boolean[arr.length];

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.get(arr[i]).add(i);
            } else {
                map.put(arr[i], new ArrayList<>());
                map.get(arr[i]).add(i);
            }
        }

        Queue<Integer> q = new ArrayDeque<>();

        q.offer(0);
        vis[0] = true;

        int level = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            for (int i = 0; i < size; i++) {

                int curr = q.poll();

                if (curr == arr.length - 1)
                    return level;

                List<Integer> l = map.get(arr[curr]);

                for (int j = 0; j < l.size(); j++) {

                    int idx = l.get(j);

                    if (!vis[idx]) {
                        vis[idx] = true;
                        q.offer(idx);
                    }
                }

                l.clear();

                if (curr + 1 < arr.length && !vis[curr + 1]) {
                    vis[curr + 1] = true;
                    q.offer(curr + 1);
                }

                if (curr - 1 >= 0 && !vis[curr - 1]) {
                    vis[curr - 1] = true;
                    q.offer(curr - 1);
                }
            }

            level++;
        }

        return -1;
    }
}
