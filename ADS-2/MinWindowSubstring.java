public class MinWindowSubstring {

    public static String minWindow(String s, String p) {
        if (s == null || p == null || s.length() < p.length()) {
            return "";
        }

        int[] freq = new int[256];
        for (char c : p.toCharArray()) {
            freq[c]++;
        }

        int start = 0, end = 0;
        int minLength = Integer.MAX_VALUE, minStart = 0, count = p.length();

        while (end < s.length()) {
            char endChar = s.charAt(end);
            if (freq[endChar] > 0) {
                count--;
            }
            freq[endChar]--;

            while (count == 0) {
                if (end - start + 1 < minLength) {
                    minLength = end - start + 1;
                    minStart = start;
                }

                char startChar = s.charAt(start);
                freq[startChar]++;
                if (freq[startChar] > 0) {
                    count++;
                }
                start++;
            }
            end++;
        }

        if (minLength == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(minStart, minStart + minLength);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String p = "ABC";

        String result = minWindow(s, p);
        System.out.println("Minimum Window Substring: " + result);
    }
}