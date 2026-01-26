import java.util.ArrayList;

public class ArrayPermutationUtils {

    public static ArrayList<ArrayList<Integer>> permuteDistinct(int[] arr) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        backtrack(arr, 0, result);
        return result;
    }

    private static void backtrack(int[] arr, int index, ArrayList<ArrayList<Integer>> result) {
        if (index == arr.length) {
            ArrayList<Integer> currentPermutation = new ArrayList<>();
            for (int num : arr) {
                currentPermutation.add(num);
            }
            result.add(currentPermutation);
            return;
        }

        for (int i = index; i < arr.length; i++) {
            swap(arr, index, i);
            backtrack(arr, index + 1, result);
            swap(arr, index, i); // backtrack
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};

        ArrayList<ArrayList<Integer>> permutations = permuteDistinct(arr);

        System.out.println("All permutations:");
        for (ArrayList<Integer> permutation : permutations) {
            System.out.println(permutation);
        }
    }
}
