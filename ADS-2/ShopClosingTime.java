public class ShopClosingTime {

    public int bestClosingTime(String customers) {
        int penalty = 0;

        // Initial penalty: count all 'Y'
        for (char c : customers.toCharArray()) {
            if (c == 'Y') {
                penalty++;
            }
        }

        int minPenalty = penalty;
        int minHour = 0;

        // Evaluate penalty hour by hour
        for (int i = 0; i < customers.length(); i++) {
            if (customers.charAt(i) == 'Y') {
                penalty--;   // staying open avoids penalty
            } else {
                penalty++;   // staying open causes penalty
            }

            if (penalty < minPenalty) {
                minPenalty = penalty;
                minHour = i + 1;
            }
        }

        return minHour;
    }

    // Main method for testing
    public static void main(String[] args) {
        ShopClosingTime solution = new ShopClosingTime();

        String customers1 = "YYNY";
        String customers2 = "NNNNN";
        String customers3 = "YYYY";

        System.out.println(solution.bestClosingTime(customers1)); // Expected: 2
        System.out.println(solution.bestClosingTime(customers2)); // Expected: 0
        System.out.println(solution.bestClosingTime(customers3)); // Expected: 4
    }
}
