public class KthCharacterInSequence {

    /**
     * Returns the k-th character in the generated sequence.
     * The sequence starts with 'a', and for each character in the current sequence,
     * we append its next character in the alphabet (wrapping from 'z' to 'a').
     */
    public char kthCharacter(int k) {
        // Create a large enough array to hold the characters up to the k-th index
        char[] word = new char[2 * k];
        int length = 1;
        word[0] = 'a';

        // Generate the sequence until it contains at least k characters
        while (length < k) {
            int currentLength = length;
            for (int i = 0; i < currentLength; i++) {
                char c = word[i];
                char nextChar = (char) ((c - 'a' + 1) % 26 + 'a');
                word[length++] = nextChar;
            }
        }

        // Return the k-th character (1-based index, so subtract 1)
        return word[k - 1];
    }

    // Main method for testing
    public static void main(String[] args) {
        KthCharacterInSequence solution = new KthCharacterInSequence();

        int k = 10; // You can change this value to test other positions
        char result = solution.kthCharacter(k);

        System.out.println("The " + k + "-th character in the sequence is: " + result);
    }
}
