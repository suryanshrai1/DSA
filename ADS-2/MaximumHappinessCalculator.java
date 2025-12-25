import java.util.Arrays;

public class MaximumHappinessCalculator {

    public static long maximumHappinessSum(int[] happiness, int k) {
        int n = happiness.length;
        Arrays.sort(happiness);

        // Reverse the array to get descending order
        for (int i = 0; i < n / 2; i++) {
            int temp = happiness[n - 1 - i];
            happiness[n - 1 - i] = happiness[i];
            happiness[i] = temp;
        }

        long result = 0;
        long decrement = 0;

        for (int i = 0; i < k; i++) {
            long currentHighest = Math.max(0, happiness[i] - decrement);
            result += currentHighest;
            decrement++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] happiness = {5, 3, 9, 1};
        int k = 2;

        long maxHappiness = maximumHappinessSum(happiness, k);
        System.out.println("Maximum Happiness Sum: " + maxHappiness);
    }
}
