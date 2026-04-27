public class smallestWinContaining012 {
    public int smallestSubstring(String S) {
        int last0 = -1, last1 = -1, last2 = -1;
        int minLength = Integer.MAX_VALUE;

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);

            if (c == '0') last0 = i;
            else if (c == '1') last1 = i;
            else if (c == '2') last2 = i;

            if (last0 != -1 && last1 != -1 && last2 != -1) {
            
                int windowStart = Math.min(last0, Math.min(last1, last2));
                int currentLength = i - windowStart + 1;
                minLength = Math.min(minLength, currentLength);
            }
        }
        return (minLength == Integer.MAX_VALUE) ? -1 : minLength;
    }
};
