import java.util.Stack;

public class StringDecoder {

    public static String decodeString(String s) {
        // Use a stack to store counts (k)
        Stack<Integer> countStack = new Stack<>();
        // Use a stack to store previous decoded strings
        Stack<String> stringStack = new Stack<>();
        String result = "";
        int index = 0;

        while (index < s.length()) {
            char currentChar = s.charAt(index);

            if (Character.isDigit(currentChar)) {
                int count = 0;
                while (Character.isDigit(s.charAt(index))) {
                    count = count * 10 + (s.charAt(index) - '0');
                    index++;
                }
                countStack.push(count);
            } else if (currentChar == '[') {
                stringStack.push(result); // Save current result before starting new segment
                result = ""; // Reset result for the new segment
                index++;
            } else if (currentChar == ']') {
                StringBuilder temp = new StringBuilder(stringStack.pop()); // Get previous string
                int repeatTimes = countStack.pop(); // Get repeat count

                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(result); // Append current result (decoded inner string)
                }
                result = temp.toString(); // Update result with the newly decoded string
                index++;
            } else {
                result += currentChar; // Append character to current result
                index++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Example test cases
        String input1 = "3[a2[c]]";
        String input2 = "2[abc]3[cd]ef";
        
        System.out.println(decodeString(input1));  // Output: "accaccacc"
        System.out.println(decodeString(input2));  // Output: "abcabccdcdcdef"
    }
}
