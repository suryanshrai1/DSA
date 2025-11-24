import java.util.ArrayList;
import java.util.List;

public class BinaryPrefixesDivisibleBy5 {

    // Method to compute prefixes divisible by 5
    public static List<Boolean> prefixesDivBy5(int[] nums) {
        int value = 0;
        List<Boolean> result = new ArrayList<>();

        for (int bit : nums) {
            value = (value * 2 + bit) % 5;
            result.add(value == 0);
        }

        return result;
    }

    // Main method for testing
    public static void main(String[] args) {

        // Sample input
        int[] nums = {1, 0, 1, 1, 1};

        List<Boolean> output = prefixesDivBy5(nums);

        // Print results
        System.out.println("Input bits:");
        for (int n : nums) System.out.print(n + " ");
        System.out.println("\n\nPrefixes divisible by 5:");
        System.out.println(output);
    }
}
