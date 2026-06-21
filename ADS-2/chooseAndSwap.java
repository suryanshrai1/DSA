import java.util.Arrays;

public class chooseAndSwap {
    public String chooseSwap(String s) {
        int n = s.length();

        // Array to store the first occurrence index of each character ('a' to 'z')
        int[] firstOccur = new int[26];
        Arrays.fill(firstOccur, -1);

        // Record the first time each character appears
        for (int i = 0; i < n; i++) {
            int charIndex = s.charAt(i) - 'a';
            if (firstOccur[charIndex] == -1) {
                firstOccur[charIndex] = i;
            }
        }

        // Find the first character that can be replaced by a smaller one
        for (int i = 0; i < n; i++) {
            char currentChar = s.charAt(i);
            boolean swapFound = false;
            char charToSwapWith = ' ';

            // Check if there is any strictly smaller character available later in the
            // string
            for (char ch = 'a'; ch < currentChar; ch++) {
                int smallerCharIndex = firstOccur[ch - 'a'];

                // If the smaller character exists and appears after the current position
                if (smallerCharIndex != -1 && smallerCharIndex > i) {
                    swapFound = true;
                    charToSwapWith = ch;
                    break; // Greedy choice: pick the smallest possible character
                }
            }

            // If a valid swap is found, perform it and return
            if (swapFound) {
                char[] charArray = s.toCharArray();
                for (int j = 0; j < n; j++) {
                    if (charArray[j] == currentChar) {
                        charArray[j] = charToSwapWith;
                    } else if (charArray[j] == charToSwapWith) {
                        charArray[j] = currentChar;
                    }
                }
                return new String(charArray);
            }
        }
        return s;
    }
}
