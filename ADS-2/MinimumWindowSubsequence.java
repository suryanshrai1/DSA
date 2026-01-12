public class MinimumWindowSubsequence {

    public String minWindow(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if (m == 0)
            return "";

        int minLen = Integer.MAX_VALUE;
        int startIdx = -1;
        int i = 0;

        while (i < n) {
            int j = 0;

            // Find the end of a valid window
            while (i < n && j < m) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    j++;
                }
                i++;
            }

            // If a valid subsequence is found
            if (j == m) {
                int end = i - 1;
                j--;

                // Backtrack to find the start of the minimal window
                while (j >= 0) {
                    if (s1.charAt(end) == s2.charAt(j)) {
                        j--;
                    }
                    end--;
                }
                end++; // start of minimal window

                if (i - end < minLen) {
                    minLen = i - end;
                    startIdx = end;
                }

                // Move i to search for the next possible window
                i = end + 1;
            }
        }

        if (startIdx == -1) {
            return "";
        }
        return s1.substring(startIdx, startIdx + minLen);
    }

    public static void main(String[] args) {
        MinimumWindowSubsequence solution = new MinimumWindowSubsequence();

        String s1 = "abcdebdde";
        String s2 = "bde";

        String result = solution.minWindow(s1, s2);
        System.out.println("Minimum window subsequence: " + result);
    }
}