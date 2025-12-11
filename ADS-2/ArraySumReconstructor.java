import java.util.ArrayList;

public class ArraySumReconstructor {

    // Method to reconstruct the array from the sums array
    public ArrayList<Integer> constructArr(int[] arr) {
        ArrayList<Integer> res = new ArrayList<>();
        
        int m = arr.length;
        if (m == 0) return res;

        // Find n from m = n*(n-1)/2
        int n = (int)( (1 + Math.sqrt(1 + 8*m)) / 2 );

        if (n == 2) {
            // arr has one element: res[0] + res[1] = arr[0]
            res.add(1);
            res.add(arr[0] - 1);
            return res;
        }

        // First three sums
        int s01 = arr[0];
        int s02 = arr[1];
        int s12 = arr[n - 1];

        int res0 = (s01 + s02 - s12) / 2;
        int res1 = s01 - res0;
        int res2 = s02 - res0;

        res.add(res0);
        res.add(res1);
        res.add(res2);

        // Compute remaining elements
        for (int k = 3; k < n; k++) {
            res.add(arr[k - 1] - res0);
        }
        return res;
    }

    // Main method to test the function
    public static void main(String[] args) {
        ArraySumReconstructor reconstructor = new ArraySumReconstructor();
        
        // Example input
        int[] inputArray = {5, 8, 13, 21, 34};  // Example array that needs reconstruction
        
        // Get the reconstructed array
        ArrayList<Integer> result = reconstructor.constructArr(inputArray);
        
        // Print the result
        System.out.println("Reconstructed Array: " + result);
    }
}
