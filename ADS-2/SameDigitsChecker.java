public class SameDigitsChecker {
    public boolean hasSameDigits(String s) {
        int n = s.length();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = s.charAt(i) - '0';
        }

        while (n > 2) {
            for (int i = 0; i < n - 1; i++) {
                arr[i] = (arr[i] + arr[i + 1]) % 10;
            }
            n--;
        }
        return arr[0] == arr[1];
    }

    public static void main(String[] args) {
        SameDigitsChecker checker = new SameDigitsChecker();

        // Test cases
        String test1 = "1234";
        String test2 = "1111";
        String test3 = "987654321";
        String test4 = "29";

        System.out.println("Test 1 (" + test1 + "): " + checker.hasSameDigits(test1));
        System.out.println("Test 2 (" + test2 + "): " + checker.hasSameDigits(test2));
        System.out.println("Test 3 (" + test3 + "): " + checker.hasSameDigits(test3));
        System.out.println("Test 4 (" + test4 + "): " + checker.hasSameDigits(test4));
    }
}
