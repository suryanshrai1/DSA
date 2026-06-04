public class maxO1Diff {
    int maxSubstring(String s) {
        // code here
        int ans = -1;
        int curr = 0;
        for (char ch : s.toCharArray()) {
            int val = ch == '0' ? +1 : -1;

            curr += val;

            ans = Math.max(ans, curr);

            if (curr < 0) {
                curr = 0;
            }
        }
        return ans;
    }
}
