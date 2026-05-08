import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class removeInvalidParenthesis {
    // helper fn
    private boolean isValid(String s) {
        int cnt = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                cnt++;
            } else if (ch == ')') {
                cnt--;
            }
            if (cnt < 0) {
                return false;
            }
        }
        return cnt == 0;
    }

    public List<String> validParenthesis(String s) {
        // code here
        List<String> res = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        Set<String> vis = new HashSet<>();

        q.add(s);
        vis.add(s);
        boolean found = false;
        while (!q.isEmpty()) {
            String curr = q.poll();
            if (isValid(curr)) {
                res.add(curr);
                found = true;
            }
            if (found == true) {
                continue;
            }
            // generate all strings by removing one parrenth.
            for (int i = 0; i < curr.length(); i++) {
                if (curr.charAt(i) != '(' && curr.charAt(i) != ')') {// non parent.
                    continue;
                }
                String next = curr.substring(0, i) + curr.substring(i + 1);

                if (!vis.contains(next)) {
                    vis.add(next);
                    q.add(next);
                }
            }
        }
        Collections.sort(res);
        return res;
    }
}