import java.util.ArrayList;
import java.util.List;

class DuplicateFinder {
    
    // Method to find duplicates in the array
    public ArrayList<Integer> findDuplicates(int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();
        int n = arr.length;

        // Iterate through the array
        for (int i = 0; i < n; i++) {
            int index = Math.abs(arr[i]) - 1;
            if (arr[index] < 0) {
                result.add(Math.abs(arr[i])); // Duplicate found
            } else {
                arr[index] = -arr[index]; // Mark this index as visited
            }
        }
        return result;
    }

    // Main method to test the findDuplicates method
    public static void main(String[] args) {
        DuplicateFinder finder = new DuplicateFinder();
        
        // Example array with duplicates
        int[] arr = {4, 3, 2, 7, 8, 2, 3, 1};
        
        // Call the findDuplicates method and print the result
        ArrayList<Integer> duplicates = finder.findDuplicates(arr);
        
        System.out.println("Duplicates: " + duplicates);
    }
}
