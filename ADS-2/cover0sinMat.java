public class cover0sinMat {
        public int findCoverage(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int totalCoverage = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    // Check Left
                    for (int k = j - 1; k >= 0; k--) {
                        if (mat[i][k] == 1) {
                            totalCoverage++;
                            break;
                        }
                    }
                    // Check Right
                    for (int k = j + 1; k < m; k++) {
                        if (mat[i][k] == 1) {
                            totalCoverage++;
                            break;
                        }
                    }
                    // Check Up
                    for (int k = i - 1; k >= 0; k--) {
                        if (mat[k][j] == 1) {
                            totalCoverage++;
                            break;
                        }
                    }
                    // Check Down
                    for (int k = i + 1; k < n; k++) {
                        if (mat[k][j] == 1) {
                            totalCoverage++;
                            break;
                        }
                    }
                }
            }
        }
        return totalCoverage;
    }
}
