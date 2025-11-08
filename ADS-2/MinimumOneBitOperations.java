public class MinimumOneBitOperations {

    public int minimumOneBitOperations(int n) {
        int ans = 0, f = 0;

        for (int i = 31; i >= 0; i--) {
            if (((n >> i) & 1) == 1) {
                if (f == 0) {
                    ans = ans + ((1 << (i + 1))) - 1;
                    f = 1;
                } else {
                    ans = ans - ((1 << (i + 1)) - 1);
                    f = 0;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MinimumOneBitOperations solution = new MinimumOneBitOperations();

        // Example test cases
        int n1 = 3;
        int n2 = 6;
        int n3 = 9;

        System.out.println("Minimum one-bit operations to reduce " + n1 + " to 0: " + solution.minimumOneBitOperations(n1));
        System.out.println("Minimum one-bit operations to reduce " + n2 + " to 0: " + solution.minimumOneBitOperations(n2));
        System.out.println("Minimum one-bit operations to reduce " + n3 + " to 0: " + solution.minimumOneBitOperations(n3));
    }
}
