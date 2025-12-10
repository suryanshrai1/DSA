import java.util.ArrayList;

public class FindMissingAndRepeating {
    
    // Method to find the missing and repeating elements
    public ArrayList<Integer> findTwoElement(int arr[]) {
        long n = arr.length;
        long sum = 0;
        long sumSq = 0;

        // Calculate the sum and sum of squares of elements in the array
        for (int i = 0; i < n; i++) {
            sum += (long) arr[i];
            sumSq += (long) arr[i] * (long) arr[i];
        }

        // Calculate the expected sum and sum of squares for numbers 1 to n
        long expectedSum = n * (n + 1) / 2;
        long expectedSumSq = n * (n + 1) * (2 * n + 1) / 6;

        // Calculate differences
        long diffSum = sum - expectedSum; // A - B
        long diffSumSq = sumSq - expectedSumSq; // A^2 - B^2

        // Calculate sum of A and B
        long sumAB = diffSumSq / diffSum; // A + B

        // Calculate repeating and missing elements
        long repeating = (diffSum + sumAB) / 2; // A
        long missing = (sumAB - diffSum) / 2; // B

        // Return the result as an ArrayList
        ArrayList<Integer> result = new ArrayList<>();
        result.add((int) repeating);
        result.add((int) missing);
        return result;
    }

    // Main method to test the functionality
    public static void main(String[] args) {
        FindMissingAndRepeating solution = new FindMissingAndRepeating();

        // Test array with a repeating and missing element
        int[] arr = {4, 3, 2, 7, 8, 2, 1};
        
        // Call the method and get the result
        ArrayList<Integer> result = solution.findTwoElement(arr);
        
        // Output the result
        System.out.println("Repeating: " + result.get(0));
        System.out.println("Missing: " + result.get(1));
    }
}
