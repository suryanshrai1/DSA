class TilingWaysCalculator {
    public int numTilings(int n) {
        final int M = 1000000007;

        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        if (n == 3)
            return 5;

        int[] t = new int[n + 1];

        t[1] = 1;
        t[2] = 2;
        t[3] = 5;

        for (int i = 4; i <= n; i++) {
            t[i] = (int) ((2L * t[i - 1] % M + t[i - 3]) % M);
        }

        return t[n];
    }
}

public class TilingWaysMain {
    public static void main(String[] args) {
        TilingWaysCalculator calculator = new TilingWaysCalculator();

        // Test cases
        int[] testCases = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        for (int n : testCases) {
            int result = calculator.numTilings(n);
            System.out.println("Number of ways to tile a 2x" + n + " board: " + result);
        }
    }
}