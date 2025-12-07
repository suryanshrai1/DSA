public class OddCounter {

    public int countOdds(int low, int high) {
        if ((low & 1) == 1) {  // If low is odd
            return (high - low + 2) / 2;
        }
        return (high - low + 1) / 2;
    }

    public static void main(String[] args) {
        OddCounter counter = new OddCounter();

        int low = 3;
        int high = 10;

        int result = counter.countOdds(low, high);

        System.out.println("Number of odd integers between " + low + " and " + high + ": " + result);
    }
}
