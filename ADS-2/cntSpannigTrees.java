public class cntSpannigTrees {
    public int countSpanTree(int n, int[][] edges) {
        if (n <= 1)
            return 1;

        double[][] laplacian = new double[n][n];
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            laplacian[u][u]++;
            laplacian[v][v]++;
            laplacian[u][v]--;
            laplacian[v][u]--;
        }

        int size = n - 1;
        double[][] matrix = new double[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = laplacian[i][j];
            }
        }
        return (int) Math.round(Math.abs(getDeterminant(matrix)));
    }

    private double getDeterminant(double[][] matrix) {
        int n = matrix.length;
        double det = 1.0;

        for (int i = 0; i < n; i++) {
            int pivot = i;
            for (int j = i + 1; j < n; j++) {
                if (Math.abs(matrix[j][i]) > Math.abs(matrix[pivot][i]))
                    pivot = j;
            }

            // Swap rows
            double[] temp = matrix[i];
            matrix[i] = matrix[pivot];
            matrix[pivot] = temp;

            if (pivot != i)
                det *= -1;
            if (Math.abs(matrix[i][i]) < 1e-9)
                return 0;

            for (int j = i + 1; j < n; j++) {
                double factor = matrix[j][i] / matrix[i][i];
                for (int k = i + 1; k < n; k++) {
                    matrix[j][k] -= factor * matrix[i][k];
                }
            }
            det *= matrix[i][i];
        }
        return det;
    }
}
