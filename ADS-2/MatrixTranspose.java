import java.util.ArrayList;

class MatrixTranspose {

    public ArrayList<ArrayList<Integer>> transpose(int[][] mat) {
        int n = mat.length;

        // In-place transpose
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }

        // Convert to ArrayList<ArrayList<Integer>>
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(mat[i][j]);
            }
            res.add(row);
        }
        return res;
    }

    // Main method to test the transpose function
    public static void main(String[] args) {
        MatrixTranspose mt = new MatrixTranspose();

        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        ArrayList<ArrayList<Integer>> result = mt.transpose(matrix);

        System.out.println("Transposed Matrix:");
        for (ArrayList<Integer> row : result) {
            System.out.println(row);
        }
    }
}
