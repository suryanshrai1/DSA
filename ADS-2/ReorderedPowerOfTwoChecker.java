import java.util.Arrays;

public class ReorderedPowerOfTwoChecker {
    
    public boolean reorderedPowerOf2(int n) {
        int[] digitCount = count(n);
        int a = 1;
        for (int i = 0; i < 30; i++) {
            int[] powerDigitCount = count(a);
            if (Arrays.equals(digitCount, powerDigitCount)) {
                return true;
            }
            a = a << 1;
        }
        return false;
    }

    public int[] count(int n) {
        int[] arr = new int[10];
        while (n > 0) {
            arr[n % 10]++;
            n = n / 10;
        }
        return arr;
    }

    public static void main(String[] args) {
        ReorderedPowerOfTwoChecker checker = new ReorderedPowerOfTwoChecker();

        int[] testCases = {1, 10, 16, 24, 46, 61, 218, 123, 256};

        for (int testCase : testCases) {
            boolean result = checker.reorderedPowerOf2(testCase);
            System.out.println("Input: " + testCase + " -> Reordered Power of 2: " + result);
        }
    }
}
