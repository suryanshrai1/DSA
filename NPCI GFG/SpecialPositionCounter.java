public class SpecialPositionCounter {

    public int numSpecial(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int special = 0;

        for (int r = 0; r < m; r++) {
            int rowSum = 0;
            int col = -1;

            for (int c = 0; c < n; c++) {
                rowSum += mat[r][c];
                if (mat[r][c] == 1)
                    col = c;
            }

            if (rowSum == 1) {
                int colSum = 0;
                for (int rr = 0; rr < m; rr++)
                    colSum += mat[rr][col];

                if (colSum == 1)
                    special++;
            }
        }

        return special;
    }

    public static void main(String[] args) {
        SpecialPositionCounter solution = new SpecialPositionCounter();

        int[][] matrix = {
            {1, 0, 0},
            {0, 0, 1},
            {1, 0, 0}
        };

        int result = solution.numSpecial(matrix);
        System.out.println("Number of special positions: " + result);
    }
}