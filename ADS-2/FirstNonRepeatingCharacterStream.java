import java.util.LinkedHashMap;

public class FirstNonRepeatingCharacterStream {

    public String firstNonRepeating(String s) {
        StringBuilder result = new StringBuilder();
        LinkedHashMap<Character, Integer> charCount = new LinkedHashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);

            char firstNonRepeating = '#';
            for (char key : charCount.keySet()) {
                if (charCount.get(key) == 1) {
                    firstNonRepeating = key;
                    break;
                }
            }
            result.append(firstNonRepeating);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        FirstNonRepeatingCharacterStream solution = new FirstNonRepeatingCharacterStream();

        String input = "aabc";
        String output = solution.firstNonRepeating(input);

        System.out.println("Input: " + input);
        System.out.println("Output: " + output);  // Expected: "a#bb"
    }
}
