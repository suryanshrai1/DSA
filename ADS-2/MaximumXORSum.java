public class MaximumXORSum {
    // Function to calculate the maximum XOR of a subarray of size k
    public int maxSubarrayXOR(int[] arr, int k) {
        int current_xor = 0;
        
        // Compute XOR for the first k elements
        for (int i = 0; i < k; i++) {
            current_xor ^= arr[i];
        }
        
        // Initialize max_xor with the first subarray XOR value
        int max_xor = current_xor;
        
        // Slide the window over the array
        for (int i = k; i < arr.length; i++) {
            current_xor ^= arr[i - k]; // Remove the element that is sliding out of the window
            current_xor ^= arr[i];     // Add the new element coming into the window
            
            // Update the max_xor if a greater XOR is found
            if (current_xor > max_xor) {
                max_xor = current_xor;
            }   
        }
        
        // Return the maximum XOR value found
        return max_xor;
    }

    public static void main(String[] args) {
        // Create an instance of MaximumXORSum
        MaximumXORSum solution = new MaximumXORSum();
        
        // Example array and subarray size
        int[] arr = {3, 8, 2, 10, 5, 1, 7};
        int k = 3;
        
        // Call the function and print the result
        int result = solution.maxSubarrayXOR(arr, k);
        System.out.println("Maximum XOR of subarray of size " + k + ": " + result);
    }
}
