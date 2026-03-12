import java.util.*;

public class LargestSpecialBinaryString {

    public String makeLargestSpecial(String s) {
        List<String> strings = new ArrayList<>();   // special substrings
        int st = 0;                                 // starting index of substring
        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            sum += s.charAt(i) == '1' ? 1 : -1;

            if (sum == 0) {
                String in = s.substring(st + 1, i);   // inner string
                strings.add("1" + makeLargestSpecial(in) + "0");  // recursively process
                st = i + 1;
            }
        }

        Collections.sort(strings, Collections.reverseOrder());
        StringBuilder result = new StringBuilder();

        for (String str : strings) {
            result.append(str);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        LargestSpecialBinaryString solution = new LargestSpecialBinaryString();
        
        String input = "11011000";
        String output = solution.makeLargestSpecial(input);
        
        System.out.println("Input:  " + input);
        System.out.println("Output: " + output);
    }
}