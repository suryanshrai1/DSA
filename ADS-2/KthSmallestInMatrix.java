public class KthSmallestInMatrix {

    public int kthSmallest(int[][] mat, int k) {
        int n = mat.length;
        int low = mat[0][0], high = mat[n - 1][n - 1];

        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = 0;

            for (int i = 0; i < n; i++) {
                int j = n - 1;
                while (j >= 0 && mat[i][j] > mid) {
                    j--;
                }
                count += (j + 1);
            }

            if (count < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        KthSmallestInMatrix solution = new KthSmallestInMatrix();

        int[][] matrix = {
            {1, 5, 9},
            {10, 11, 13},
            {12, 13, 15}
        };

        int k = 8;
        int result = solution.kthSmallest(matrix, k);

        System.out.println("The " + k + "th smallest element is: " + result);
    }
}
