public class BitReversal {

    // Treat n as an unsigned value
    public int reverseBits(int n) {
        int ans = 0;

        for (int i = 0; i < 32; i++) {
            if (((n >> i) & 1) == 1) {
                int lsb = 1 << (31 - i);
                ans = ans | lsb;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        BitReversal solution = new BitReversal();

        int input = 43261596; // Example input
        int result = solution.reverseBits(input);

        System.out.println("Input:  " + input);
        System.out.println("Output: " + result);
    }
}
