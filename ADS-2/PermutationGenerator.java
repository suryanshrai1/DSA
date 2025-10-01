import java.util.ArrayList;
import java.util.Arrays;

class PermutationGenerator {

    // Method to generate unique permutations
    public static ArrayList<ArrayList<Integer>> uniquePerms(int[] arr) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Arrays.sort(arr); // Sort the array to handle duplicates and ensure sorted output
        boolean[] used = new boolean[arr.length]; // To keep track of used elements
        ArrayList<Integer> currentPermutation = new ArrayList<>();
        backtrack(arr, used, currentPermutation, result);
        return result; // Return the result after backtracking
    }

    // Backtracking function to generate permutations
    private static void backtrack(int[] arr, boolean[] used, ArrayList<Integer> currentPermutation, ArrayList<ArrayList<Integer>> result) {
        if (currentPermutation.size() == arr.length) {
            result.add(new ArrayList<>(currentPermutation)); // Add a copy of the current permutation
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            // Skip if the element is already used
            if (used[i]) {
                continue;
            }

            // Skip duplicates: if current element is same as previous AND previous was not used (meaning it was skipped)
            if (i > 0 && arr[i] == arr[i - 1] && !used[i - 1]) {
                continue;
            }

            used[i] = true; // Mark element as used
            currentPermutation.add(arr[i]); // Add element to current permutation
            backtrack(arr, used, currentPermutation, result); // Recurse
            currentPermutation.remove(currentPermutation.size() - 1); // Backtrack: remove last element
            used[i] = false; // Backtrack: mark element as unused
        }
    }

    // Main method to test the solution
    public static void main(String[] args) {
        int[] arr = {1, 1, 2}; // Example input array
        ArrayList<ArrayList<Integer>> result = uniquePerms(arr);

        // Print the result
        System.out.println("Unique Permutations:");
        for (ArrayList<Integer> perm : result) {
            System.out.println(perm);
        }
    }
}
