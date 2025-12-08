public class PythagoreanTripletsCounter {

    public int countTriples(int n) {
        int count = 0;

        // Iterate over possible values for a and b
        for (int a = 1; a <= n; a++) {
            int a2 = a * a; // Calculate a^2
            for (int b = 1; b <= n; b++) {
                int b2 = b * b; // Calculate b^2

                // Sum of squares of a and b
                int sum = a2 + b2;
                int c = (int) Math.sqrt(sum); // Calculate the possible c

                // Check if c^2 equals the sum and c is within the range
                if (c * c == sum && c <= n) {
                    count++; // Found a valid triplet
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        // Create an object of PythagoreanTripletsCounter
        PythagoreanTripletsCounter counter = new PythagoreanTripletsCounter();

        // Example input
        int n = 10;

        // Output the result
        int result = counter.countTriples(n);
        System.out.println("Number of Pythagorean triplets for n = " + n + ": " + result);
    }
}
