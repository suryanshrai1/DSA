import java.util.ArrayList;

public class nDigitNo {
        public static ArrayList<Integer> increasingNumbers(int n) {
        ArrayList<Integer> result = new ArrayList<>();
        
        // Special case: Single digit numbers include 0
        if (n == 1) {
            for (int i = 0; i <= 9; i++) {
                result.add(i);
            }
            return result;
        }
        
        // Impossible to have strictly increasing numbers longer than 9 digits
        if (n > 9) {
            return result;
        }
        
        // Start backtracking from the first digit (1 to 9)
        for (int i = 1; i <= 9; i++) {
            findNumbers(i, i, 1, n, result);
        }
        
        return result;
    }
    
    private static void findNumbers(int lastDigit, int currentNum, int currentLength, int targetLength, ArrayList<Integer> result) {
        // Base case: if the number reaches the required length, add to result
        if (currentLength == targetLength) {
            result.add(currentNum);
            return;
        }
        
        // Try appending a larger digit (from lastDigit + 1 to 9)
        for (int nextDigit = lastDigit + 1; nextDigit <= 9; nextDigit++) {
            findNumbers(nextDigit, currentNum * 10 + nextDigit, currentLength + 1, targetLength, result);
        }
    }
}
