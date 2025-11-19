import java.util.*;

public class SolutionFinalValue {

    public static int findFinalValue(int[] nums, int original) {
        HashSet<Integer> set = new HashSet<>();
        for (int x : nums)
            set.add(x);

        while (set.contains(original)) {
            original *= 2;
        }
        return original;
    }

    public static void main(String[] args) {
        // Example usage:
        int[] nums = {5, 3, 6, 1, 12};
        int original = 3;

        int result = findFinalValue(nums, original);
        System.out.println("Final Value = " + result);
    }
}
