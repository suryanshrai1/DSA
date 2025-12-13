public class CorridorDivider {

    public int numberOfWays(String corridor) {
        final int n = corridor.length();
        final byte[] corr = new byte[n];
        corridor.getBytes(0, n, corr, 0);

        long ways = 1;
        int seatCount = 0;
        int prevSeatIdx = -1;

        for (int i = n - 1; i >= 0; i--) {
            if (corr[i] == 'P')
                continue;

            if (seatCount != 0)
                prevSeatIdx = i;
            else if (prevSeatIdx > 0)
                ways = (ways * (prevSeatIdx - i)) % 1_000_000_007L;

            seatCount ^= 1;
        }

        return (prevSeatIdx < 0 || seatCount != 0) ? 0 : (int) ways;
    }

    public static void main(String[] args) {
        CorridorDivider solution = new CorridorDivider();

        // Example test cases
        String corridor1 = "SSPPSPS";
        String corridor2 = "PPSPSP";
        String corridor3 = "S";

        System.out.println("Ways for \"" + corridor1 + "\": " +
                solution.numberOfWays(corridor1));
        System.out.println("Ways for \"" + corridor2 + "\": " +
                solution.numberOfWays(corridor2));
        System.out.println("Ways for \"" + corridor3 + "\": " +
                solution.numberOfWays(corridor3));
    }
}
