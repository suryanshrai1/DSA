
public class MinimumCostStringTransformation {

    public long minimumCost(String source, String target,
            char[] original, char[] changed, int[] cost) {

        int[][] mat = new int[26][26];

        // Initialize matrix
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                if (i == j)
                    mat[i][j] = 0;
                else
                    mat[i][j] = Integer.MAX_VALUE;
            }
        }

        // Fill direct transformation costs
        for (int i = 0; i < cost.length; i++) {
            int r = original[i] - 'a';
            int c = changed[i] - 'a';
            mat[r][c] = Math.min(cost[i], mat[r][c]);
        }

        // Floyd–Warshall for all-pairs shortest paths
        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    if (mat[i][k] == Integer.MAX_VALUE || mat[k][j] == Integer.MAX_VALUE)
                        continue;
                    mat[i][j] = Math.min(mat[i][j], mat[i][k] + mat[k][j]);
                }
            }
        }

        // Calculate total minimum cost
        long sum = 0;
        for (int i = 0; i < source.length(); i++) {
            int r = source.charAt(i) - 'a';
            int c = target.charAt(i) - 'a';
            if (mat[r][c] == Integer.MAX_VALUE)
                return -1;
            sum += mat[r][c];
        }

        return sum;
    }

    public static void main(String[] args) {
        MinimumCostStringTransformation obj = new MinimumCostStringTransformation();

        String source = "abcd";
        String target = "bcda";

        char[] original = { 'a', 'b', 'c', 'd' };
        char[] changed = { 'b', 'c', 'd', 'a' };
        int[] cost = { 1, 1, 1, 1 };

        long result = obj.minimumCost(source, target, original, changed, cost);
        System.out.println("Minimum cost to transform: " + result);
    }
}
