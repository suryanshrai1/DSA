public class wifiRouterRange {
    public boolean wifiRange(String s, int x) {
        int n = s.length();
        int nextToCover = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                int rangeStart = i - x;
                int rangeEnd = i + x;

                if (rangeStart > nextToCover) {
                    return false;
                }

                nextToCover = rangeEnd + 1;
                
                if (nextToCover >= n) {
                    return true;
                }
            }
        }
        return nextToCover >= n;
    }
}
