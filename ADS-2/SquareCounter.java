public class SquareCounter {

    public static int countSquare(int[][] mat, int x) {
        int n = mat.length;
        if (n == 0) return 0;
        int m = mat[0].length;
        if (m == 0) return 0;

        int[][] ps = new int[n + 1][m + 1];

        // Build prefix sum matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ps[i + 1][j + 1] = mat[i][j]
                        + ps[i][j + 1]
                        + ps[i + 1][j]
                        - ps[i][j];
            }
        }

        int count = 0;

        // Check all square submatrices
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 1; i + k <= n && j + k <= m; k++) {
                    int sum = ps[i + k][j + k]
                            - ps[i][j + k]
                            - ps[i + k][j]
                            + ps[i][j];

                    if (sum == x) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {

        int[][] matrix = {
                {1, 1, 0},
                {1, 1, 1},
                {0, 1, 1}
        };

        int targetSum = 4;

        int result = countSquare(matrix, targetSum);

        System.out.println("Number of square submatrices with sum " 
                + targetSum + " = " + result);
    }
}