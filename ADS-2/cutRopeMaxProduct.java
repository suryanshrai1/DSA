public class cutRopeMaxProduct {
    public int maxProduct(int n) {
        if (n == 2) return 1; // 1 * 1
        if (n == 3) return 2; // 2 * 1

        long product = 1;
        while (n > 4) {
            product *= 3;
            n -= 3;
        }
        return (int)(product * n);
    }
}
