public class MaxBinaryOperations {
    public int maxOperations(String s) {
        int op = 0, countOfOne = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0' && (i + 1 == s.length() || s.charAt(i + 1) == '1')) {
                op += countOfOne;
            } else if (s.charAt(i) == '1') {
                countOfOne++;
            }
        }
        return op;
    }

    public static void main(String[] args) {
        MaxBinaryOperations mbo = new MaxBinaryOperations();

        String test1 = "110001";
        String test2 = "101010";
        String test3 = "11111";
        String test4 = "1001";

        System.out.println("Input: " + test1 + " → Max Operations: " + mbo.maxOperations(test1));
        System.out.println("Input: " + test2 + " → Max Operations: " + mbo.maxOperations(test2));
        System.out.println("Input: " + test3 + " → Max Operations: " + mbo.maxOperations(test3));
        System.out.println("Input: " + test4 + " → Max Operations: " + mbo.maxOperations(test4));
    }
}
