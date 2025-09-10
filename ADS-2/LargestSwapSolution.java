public class LargestSwapSolution {
    public String largestSwap(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int max_digit = arr[i];
            int max_idx = i;

            // Find the largest digit in the remaining part of the string
            for (int j = i + 1; j < n; j++) {
                if (arr[j] >= max_digit) { // to find the rightmost largest if duplicates exist
                    max_digit = arr[j];
                    max_idx = j;
                }
            }

            // If a larger digit is found, perform the swap
            if (max_digit > arr[i]) {
                char temp = arr[i];
                arr[i] = arr[max_idx];
                arr[max_idx] = temp;
                return new String(arr); // Only one swap allowed
            }
        }
        return s; 
    }

    public static void main(String[] args) {
        LargestSwapSolution solution = new LargestSwapSolution();
        
        String input1 = "2736";
        String result1 = solution.largestSwap(input1);
        System.out.println("Input: " + input1 + " -> Largest Swap Result: " + result1);

        String input2 = "9973";
        String result2 = solution.largestSwap(input2);
        System.out.println("Input: " + input2 + " -> Largest Swap Result: " + result2);

        String input3 = "1234";
        String result3 = solution.largestSwap(input3);
        System.out.println("Input: " + input3 + " -> Largest Swap Result: " + result3);
    }
}
