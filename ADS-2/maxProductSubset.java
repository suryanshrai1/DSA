public class maxProductSubset{
    int MOD = 1000000007;

    public int findMaxProduct(int[] arr) {

        int n = arr.length;

        if (n == 1)
            return arr[0];

        int negCount = 0;
        int zeroCount = 0;

        int maxNegative = Integer.MIN_VALUE;

        long product = 1;

        for (int x : arr) {

            if (x == 0) {
                zeroCount++;
                continue;
            }

            if (x < 0) {
                negCount++;
                maxNegative = Math.max(maxNegative, x);
            }

            product = (product * x) % MOD;
        }

        // all zeros
        if (zeroCount == n)
            return 0;

        // one negative and all others zero
        if (negCount == 1 && zeroCount + negCount == n)
            return 0;

        // odd number of negatives
        if ((negCount & 1) == 1) {

            // modular inverse of maxNegative
            long inv = modPow(maxNegative, MOD - 2);

            product = (product * inv) % MOD;
        }

        if (product < 0)
            product += MOD;

        return (int) product;
    }

    long modPow(long a, long b) {
        a %= MOD;
        if (a < 0) a += MOD;

        long res = 1;

        while (b > 0) {
            if ((b & 1) == 1)
                res = (res * a) % MOD;

            a = (a * a) % MOD;
            b >>= 1;
        }
        return res;
    }
}