import java.util.ArrayList;
import java.util.Arrays;

public class MatrixPrefixSum {

    public static ArrayList<Integer> prefixSum2D(int[][] mat, int[][] queries) {
        int R = mat.length;
        int C = mat[0].length;
        int[][] P = new int[R + 1][C + 1];

        // Build prefix sum matrix
        for (int r = 1; r <= R; r++) {
            for (int c = 1; c <= C; c++) {
                P[r][c] = mat[r - 1][c - 1]
                        + P[r - 1][c]
                        + P[r][c - 1]
                        - P[r - 1][c - 1];
            }
        }

        // Answer queries
        ArrayList<Integer> results = new ArrayList<>();
        for (int[] query : queries) {
            int r1 = query[0];
            int c1 = query[1];
            int r2 = query[2];
            int c2 = query[3];

            int sum = P[r2 + 1][c2 + 1]
                    - P[r1][c2 + 1]
                    - P[r2 + 1][c1]
                    + P[r1][c1];

            results.add(sum);
        }
        return results;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int[][] queries = {
            {0, 0, 1, 1}, // sum of submatrix from (0,0) to (1,1)
            {1, 1, 2, 2}, // sum of submatrix from (1,1) to (2,2)
            {0, 0, 2, 2}  // sum of entire matrix
        };

        ArrayList<Integer> result = prefixSum2D(matrix, queries);

        System.out.println("Matrix:");
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }

        System.out.println("\nQuery Results:");
        System.out.println(result);
    }
}
