import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

public class MajorityFrequencyGroup {

    public String majorityFrequencyGroup(String s) {
        // Count character frequencies
        int[] charCnts = new int[26];
        for (char ch : s.toCharArray()) {
            charCnts[ch - 'a']++;
        }

        // Group characters by their frequencies
        Map<Integer, List<Character>> freqMap = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            int freq = charCnts[i];
            if (freq > 0) {
                char c = (char) ('a' + i);
                freqMap.computeIfAbsent(freq, k -> new ArrayList<>()).add(c);
            }
        }

        int maxGrp = 0;
        int majFreq = 0;
        List<Character> res = new ArrayList<>();

        for (Map.Entry<Integer, List<Character>> entry : freqMap.entrySet()) {
            int currFreq = entry.getKey();
            List<Character> currGrp = entry.getValue();

            // Choose group with more characters, or higher frequency if tie
            if (currGrp.size() > maxGrp || (currGrp.size() == maxGrp && currFreq > majFreq)) {
                maxGrp = currGrp.size();
                majFreq = currFreq;
                res = currGrp;
            }
        }

        // Build result string
        StringBuilder sb = new StringBuilder();
        for (char ch : res) {
            sb.append(ch);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MajorityFrequencyGroup obj = new MajorityFrequencyGroup();

        // Example test cases
        String input1 = "aabbccddeee";  // e appears 3 times, rest twice
        String input2 = "abcabcabc";    // a, b, c appear 3 times each
        String input3 = "zzzxy";        // z = 3, x = 1, y = 1

        System.out.println("Input: " + input1 + " => Output: " + obj.majorityFrequencyGroup(input1));
        System.out.println("Input: " + input2 + " => Output: " + obj.majorityFrequencyGroup(input2));
        System.out.println("Input: " + input3 + " => Output: " + obj.majorityFrequencyGroup(input3));
    }
}
