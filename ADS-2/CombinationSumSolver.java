import java.util.ArrayList;
import java.util.List;

class CombinationSumSolver {
    public ArrayList<ArrayList<Integer>> combinationSum(int n, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> currentCombination = new ArrayList<>();
        backtrack(result, currentCombination, n, k, 1);
        return result;
    }

    private void backtrack(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> currentCombination, int targetSum, int count, int startNum) {
        if (targetSum == 0 && count == 0) {
            result.add(new ArrayList<>(currentCombination));
            return;
        }
        if (targetSum < 0 || count < 0 || startNum > 9) {
            return;
        }

        for (int i = startNum; i <= 9; i++) {
            currentCombination.add(i);
            backtrack(result, currentCombination, targetSum - i, count - 1, i + 1);
            currentCombination.remove(currentCombination.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSumSolver solver = new CombinationSumSolver();
        int n = 7; // Example target sum
        int k = 3; // Example number of elements in the combination

        ArrayList<ArrayList<Integer>> combinations = solver.combinationSum(n, k);

        // Print the result
        System.out.println("Combinations that sum to " + n + " with " + k + " elements:");
        for (ArrayList<Integer> combination : combinations) {
            System.out.println(combination);
        }
    }
}
