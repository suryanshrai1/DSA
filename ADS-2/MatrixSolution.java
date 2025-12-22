class MatrixSolution {

    public int rowWithMax1s(int arr[][]) {
        int rows = arr.length;
        if (rows == 0) return -1;
        int cols = arr[0].length;
        if (cols == 0) return -1;

        int maxOnesRowIndex = -1;
        int j = cols - 1; 

        for (int i = 0; i < rows; i++) {
            while (j >= 0 && arr[i][j] == 1) {
                maxOnesRowIndex = i;
                j--;
            }
        }
        return maxOnesRowIndex;
    }

    public static void main(String[] args) {
        MatrixSolution solution = new MatrixSolution();
        
        int[][] arr = {
            {0, 1, 1, 1},
            {1, 1, 1, 1},
            {0, 0, 1, 1},
            {1, 0, 0, 0}
        };
        
        int row = solution.rowWithMax1s(arr);
        
        System.out.println("Row with the maximum 1s: " + row);
    }
}
