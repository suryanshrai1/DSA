import java.util.*;

public class SuccessfulPairsFinder {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        Arrays.sort(potions);
        int maxPotion = potions[m - 1];
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            int spell = spells[i];
            // Minimum potion strength required to succeed
            double minPotion = Math.ceil((1.0 * success) / spell);

            if (minPotion > maxPotion) {
                res[i] = 0;
                continue;
            }

            // Find the first potion that satisfies potions[j] >= minPotion
            int index = lowerBound(0, m - 1, potions, minPotion);

            // Count of successful pairs for this spell
            res[i] = m - index;
        }
        return res;
    }

    int lowerBound(int low, int high, int[] potions, double minPotion) {
        int isPossible = high + 1;  // default to end if not found
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (potions[mid] >= minPotion) {
                isPossible = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return isPossible;
    }

    // Main method for testing
    public static void main(String[] args) {
        SuccessfulPairsFinder solver = new SuccessfulPairsFinder();

        int[] spells = {5, 1, 3};
        int[] potions = {1, 2, 3, 4, 5};
        long success = 7;

        int[] result = solver.successfulPairs(spells, potions, success);

        System.out.println("Successful pairs count for each spell:");
        System.out.println(Arrays.toString(result));
    }
}
