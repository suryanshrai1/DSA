public class BitCharacterChecker {
    
    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length;
        int i = 0;
        while (i <= n - 1) {
            if (bits[i] == 0) {
                if (i == n - 1)
                    return true;
                i = i + 1;
            } else
                i = i + 2;
        }
        return false;
    }

    public static void main(String[] args) {
        BitCharacterChecker checker = new BitCharacterChecker();
        
        // Test case 1
        int[] bits1 = {1, 0, 0};
        System.out.println("Test Case 1: " + checker.isOneBitCharacter(bits1)); // Expected: true
        
        // Test case 2
        int[] bits2 = {1, 1, 0};
        System.out.println("Test Case 2: " + checker.isOneBitCharacter(bits2)); // Expected: false
        
        // Test case 3
        int[] bits3 = {0};
        System.out.println("Test Case 3: " + checker.isOneBitCharacter(bits3)); // Expected: true
    }
}
