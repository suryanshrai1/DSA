public class MaxMatrixSumCalculator {

    public long maxMatrixSum(int[][] matrix) {
        long total = 0;
        int min = Integer.MAX_VALUE;
        int negativesCount = 0;

        for (int[] row : matrix) {
            for (int value : row) {
                if (value < 0) {
                    negativesCount++;
                    value = -value;
                }
                total += value;
                min = Math.min(min, value);
            }
        }

        if (negativesCount % 2 == 0) {
            return total;
        }

        return total - 2L * min;
    }

    public static void main(String[] args) {
        MaxMatrixSumCalculator calculator = new MaxMatrixSumCalculator();

        int[][] matrix = {
            {1, -2, 3},
            {-4, 5, -6},
            {7, -8, 9}
        };

        long result = calculator.maxMatrixSum(matrix);
        System.out.println("Maximum Matrix Sum: " + result);
    }
}
