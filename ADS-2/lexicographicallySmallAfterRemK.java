import java.util.Stack;

public class lexicographicallySmallAfterRemK {
    public String lexicographicallySmallest(String s, int k) {
        int n = s.length();

        // Correct k
        if ((n & (n - 1)) == 0) {
            k /= 2;
        } else {
            k *= 2;
        }

        // Invalid cases
        if (k >= n) {
            return "-1";
        }

        Stack<Character> st = new Stack<>();
        int toRemove = k;

        for (char ch : s.toCharArray()) {
            while (!st.isEmpty() && toRemove > 0 && st.peek() > ch) {
                st.pop();
                toRemove--;
            }
            st.push(ch);
        }

        // Remove remaining characters from the end
        while (toRemove > 0) {
            st.pop();
            toRemove--;
        }

        StringBuilder sb = new StringBuilder();
        for (char ch : st) {
            sb.append(ch);
        }
        return sb.length() == 0 ? "-1" : sb.toString();
    }
}
