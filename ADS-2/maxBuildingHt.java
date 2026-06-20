import java.util.ArrayList;
import java.util.List;

public class maxBuildingHt {
        public int maxBuilding(int n, int[][] restrictions) {
        int m = restrictions.length;

        List<int[]> list = new ArrayList<>();
        list.add(new int[] { 1, 0 });

        for (int[] r : restrictions) {
            list.add(new int[] { r[0], r[1] });
        }

        list.sort((a, b) -> Integer.compare(a[0], b[0]));

        if (list.get(list.size() - 1)[0] != n) {
            list.add(new int[] { n, n - 1 });
        } else {
            list.get(list.size() - 1)[1] = Math.min(list.get(list.size() - 1)[1], n - 1);
        }

        int size = list.size();

        // Left -> Right
        for (int i = 1; i < size; i++) {
            int dist = list.get(i)[0] - list.get(i - 1)[0];
            list.get(i)[1] = Math.min(
                    list.get(i)[1],
                    list.get(i - 1)[1] + dist);
        }

        // Right -> Left
        for (int i = size - 2; i >= 0; i--) {
            int dist = list.get(i + 1)[0] - list.get(i)[0];
            list.get(i)[1] = Math.min(
                    list.get(i)[1],
                    list.get(i + 1)[1] + dist);
        }

        long ans = 0;

        for (int i = 1; i < size; i++) {
            long x1 = list.get(i - 1)[0];
            long h1 = list.get(i - 1)[1];
            long x2 = list.get(i)[0];
            long h2 = list.get(i)[1];

            long dist = x2 - x1;
            ans = Math.max(ans, (h1 + h2 + dist) / 2);
        }
        return (int) ans;
    }
}
